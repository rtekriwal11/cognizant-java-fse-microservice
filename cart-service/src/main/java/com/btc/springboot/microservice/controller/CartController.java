package com.btc.springboot.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.btc.springboot.microservice.model.CartDetails;
import com.btc.springboot.microservice.model.Coupon;
import com.btc.springboot.microservice.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	CartService service;
	
	@GetMapping("/product-id/{productId}/coupon-code/{couponCode}")
	public CartDetails getCartInfo(@PathVariable int productId,@PathVariable String couponCode) {
		return service.getCartInfo(productId, couponCode);
	}
	
	@PostMapping("/coupons")
	public Coupon addCoupon(@RequestBody Coupon coupon) {
		return service.addCoupon(coupon);
	}
	

}