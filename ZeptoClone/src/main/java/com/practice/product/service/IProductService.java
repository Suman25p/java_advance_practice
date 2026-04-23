package com.practice.product.service;

import com.practice.product.request.ProductRequest;
import com.practice.product.request.ProductResponse;

public interface IProductService {

	public ProductResponse createProduct(ProductRequest productRequest);

	public ProductResponse findProducts(String name, String status);

	public String checkProductStatus(int productIDInt);

}
