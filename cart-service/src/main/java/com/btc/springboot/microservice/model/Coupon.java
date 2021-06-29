package com.btc.springboot.microservice.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coupon {

	private String couponCode;
	private double discount;
	private LocalDate validTill;
	private double minimumOrderAmt;
	private double maxDiscount;
	private int serverPort;
}