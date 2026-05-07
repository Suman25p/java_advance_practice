package com.kodewala.sample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodewala.sample.exception.ProductNotFoundException;

@RestController
public class ProductController {
	
	@GetMapping("/product")
	public String getProduct() {
		throw new ProductNotFoundException("Product not available");
	}
}
