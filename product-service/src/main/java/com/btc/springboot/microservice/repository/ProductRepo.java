package com.btc.springboot.microservice.repository;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.btc.springboot.microservice.model.Product;
@Repository
public class ProductRepo {

	private Map<Integer, Product> productData;
	
	@PostConstruct
	public void init() {
		productData=new HashMap<>();
		Product p1,p2,p3;
		p1=new Product(10001,"Samsung S21", 70000.0,0);
		p2=new Product(10002,"iPad Pro", 99000.0,0);
		p3=new Product(10003,"HP Envy Laptop", 82000.0,0);
		productData.put(p1.getProductId(),p1);
		productData.put(p2.getProductId(),p2);
		productData.put(p3.getProductId(),p3);
		
	}
	
	public Product getProduct(int productId) {
		return productData.get(productId);
	}
	
}