package com.btc.springboot.microservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDetails {
	
	private Product product;
	private Coupon coupon;
	private boolean coponApplied;
	private double finalPrice;
	
	
	

}