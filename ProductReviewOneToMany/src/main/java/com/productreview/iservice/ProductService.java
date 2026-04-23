package com.productreview.iservice;

import org.springframework.stereotype.Service;

import com.productreview.request.ProductRequest;
import com.productreview.response.ProductResponse;


public interface ProductService {
	ProductResponse createProduct(ProductRequest request);
}
