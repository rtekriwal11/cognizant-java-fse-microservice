package com.btc.springboot.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.btc.springboot.microservice.model.Coupon;
import com.btc.springboot.microservice.repository.CouponRepo;

@RestController
@RequestMapping("/coupons")
public class CouponController {
	
	@Autowired
	private CouponRepo repo;
	
	@Autowired
	Environment env;
	
	@GetMapping("/coupon-code/{couponCode}")
	public Coupon getCoupon(@PathVariable String couponCode) {
		Coupon coupon= repo.getCoupon(couponCode);
		int port=Integer.parseInt(env.getProperty("local.server.port"));
		coupon.setServerPort(port);
		return coupon;
	}

	
	@PostMapping
	public Coupon addCoupon(@RequestBody Coupon coupon) {
		return repo.addCoupon(coupon);
	}
}