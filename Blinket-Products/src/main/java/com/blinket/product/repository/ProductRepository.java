package com.blinket.product.repository;

import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

	public String uploadProduct(String _input) {
		
		String productId = java.util.UUID.nameUUIDFromBytes(_input.getBytes()).toString().replace("-", "")
				.substring(0, 4).toUpperCase();
		return productId;
	}

}