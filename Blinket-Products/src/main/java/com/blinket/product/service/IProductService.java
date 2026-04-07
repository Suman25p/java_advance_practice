package com.blinket.product.service;

import com.blinket.product.request.ProductRequest;
import com.blinket.product.request.ProductResponse;

public interface IProductService {

	public ProductResponse createProduct(ProductRequest productRequest);
	
}