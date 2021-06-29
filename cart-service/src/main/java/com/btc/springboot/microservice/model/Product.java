package com.btc.springboot.microservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//DATA comes with lombok so that we do not have to write getters and setters
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	private int productId;
	private String productName;
	private double price;
	private int serverPort;

}