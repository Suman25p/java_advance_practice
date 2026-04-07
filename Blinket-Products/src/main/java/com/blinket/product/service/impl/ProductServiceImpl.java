package com.blinket.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blinket.product.repository.ProductRepository;
import com.blinket.product.request.ProductRequest;
import com.blinket.product.request.ProductResponse;
import com.blinket.product.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public ProductResponse createProduct(ProductRequest productRequest) {

		String productName = productRequest.getProductName();
		String qty = productRequest.getQty();

		String description = productRequest.getDescription();

		String price = productRequest.getPrice();
		String soldBy = productRequest.getSoldBy();

		System.out.println("ProductServiceImpl -->  Received from Seller " + productName + " " + qty + " " + description
				+ " " + price + " " + soldBy);

		String input = productName + qty;

		// Calling DAO / Repository Layer
		String productId = productRepository.uploadProduct(input);

		ProductResponse productResponse = new ProductResponse();
		if (productId != null) {
			productResponse.setProductId(productId);
			productResponse.setConfirmationMsg("You product has been uploaded. It will be live on catalog soon!!");
		} else {
			productResponse.setProductId(productId);
			productResponse.setConfirmationMsg("Unable to upload the product!");
		}
		return productResponse;
	}

}