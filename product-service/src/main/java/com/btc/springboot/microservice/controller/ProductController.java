package com.btc.springboot.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.btc.springboot.microservice.model.Product;
import com.btc.springboot.microservice.repository.ProductRepo;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductRepo repo;
	
	@Autowired
	private Environment env;

	@GetMapping("/product-id/{productId}")
	public Product getProduct(@PathVariable int productId) {
		Product product=repo.getProduct(productId);
		int port=Integer.parseInt(env.getProperty("local.server.port"));
		product.setServerPort(port);
		return product;
	}
	
}