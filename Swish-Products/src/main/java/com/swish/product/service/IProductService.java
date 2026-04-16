package com.swish.product.service;

import com.swish.product.request.ProductRequest;
import com.swish.product.request.ProductResponse;

public interface IProductService {

	public ProductResponse createProduct(ProductRequest productRequest);

	public String checkProductStatus(int productId);

}
