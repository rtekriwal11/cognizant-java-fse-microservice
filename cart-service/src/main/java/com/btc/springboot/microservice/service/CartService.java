package com.btc.springboot.microservice.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.btc.springboot.microservice.model.CartDetails;
import com.btc.springboot.microservice.model.Coupon;
import com.btc.springboot.microservice.model.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class CartService {
	
	@Autowired
	RestTemplate rTemplate;
	
	@HystrixCommand(fallbackMethod = "getCartInfoFallback",
			commandProperties = {
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
					@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
					@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),
					@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "50")
			}
			)
	public CartDetails getCartInfo(int productId, String couponCode) {
		
		Product product=rTemplate.getForObject("http://PRODUCT-SERVICE/products/product-id/"+productId,Product.class);
		Coupon coupon=rTemplate.getForObject("http://COUPON-SERVICE/coupons/coupon-code/"+couponCode,Coupon.class);
		
		
		
		CartDetails cartDetails=new CartDetails();
		cartDetails.setProduct(product);
		cartDetails.setCoupon(coupon);
		boolean couponApplicable=true;
		double discount=0;
		
		if(coupon.getValidTill().isBefore(LocalDate.now())) {
			couponApplicable=false;
		}
		if(product.getPrice()<coupon.getMinimumOrderAmt()) {
			couponApplicable=false;
		}
		if(couponApplicable) {
			discount = product.getPrice()*(coupon.getDiscount()/100.0);
			discount = discount<coupon.getMaxDiscount()?discount:coupon.getMaxDiscount();
		}
		cartDetails.setCoponApplied(couponApplicable);
		cartDetails.setFinalPrice(product.getPrice()-discount);
		
		return cartDetails;
	}
	
	public CartDetails getCartInfoFallback(int productId, String couponCode) {
		Product product =new Product(productId, "Blah Blah", 1000, 0);
		Coupon coupon=new Coupon(couponCode,5, LocalDate.now(), 1000, 100, 0);
		return new CartDetails(product, coupon, false, 1000);
	}
	
	
	public Coupon addCoupon(Coupon coupon) {
		return rTemplate.postForObject("http://COUPON-SERVICE/coupons", coupon, Coupon.class);
	}

}