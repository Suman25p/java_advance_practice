package com.zepto.product.service;

import java.util.List;

import com.zepto.product.entity.ProductEntity;
import com.zepto.product.request.ProductRequest;
import com.zepto.product.response.ProductResponse;

public interface IProductService {

	public ProductResponse createProduct(ProductRequest productRequest);

	public String checkProductStatus(int productId);

	public String updateProductStatus(int productId, String status);

	public String deleteProduct(int productId);

	public List<ProductEntity> getProductsWithPagination(int page, int size);

}