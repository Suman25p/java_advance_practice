package com.blinket.product.service;

import com.blinket.product.request.ProductRequest;
import com.blinket.product.response.ProductResponse;


public interface IProductService {

	public ProductResponse createProduct(ProductRequest productRequest);
	
}