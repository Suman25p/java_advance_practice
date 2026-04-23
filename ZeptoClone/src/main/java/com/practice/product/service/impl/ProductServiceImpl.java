package com.practice.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.product.entity.PriceEntity;
import com.practice.product.entity.ProductEntity;
import com.practice.product.repository.IProductRepository;
import com.practice.product.request.ProductRequest;
import com.practice.product.request.ProductResponse;
import com.practice.product.service.IProductService;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class ProductServiceImpl implements IProductService{

	@Autowired
	IProductRepository iProductRepository;
	
	
	@Override
	public ProductResponse createProduct(ProductRequest productRequest) {

	    String productName = productRequest.getProductName();
	    String qty = productRequest.getQty();
	    String description = productRequest.getDescription();
	    String price = productRequest.getPrice();
	    String soldBy = productRequest.getSoldBy();
	    String priceType = productRequest.getPriceType();

	    System.out.println("ProductServiceImpl --> Received from Seller "
	            + productName + " " + qty + " " + description + " " + price + " " + soldBy);

	    // ✅ Create PriceEntity
	    PriceEntity priceEntity = new PriceEntity();
	    priceEntity.setPrice(price);
	    priceEntity.setPriceType(priceType);

	    // ✅ Create ProductEntity
	    ProductEntity entity = new ProductEntity();
	    entity.setProductName(productName);
	    entity.setStatus("CREATED");
	    entity.setProductId(java.util.UUID.randomUUID().toString());

	    // 🔥 IMPORTANT: set all fields
	    entity.setQty(qty);
	    entity.setDescription(description);
	    entity.setPrice(price);
	    entity.setSoldBy(soldBy);
	    entity.setPriceType(priceType);

	    // ✅ Relationship
	    entity.setPriceEntity(priceEntity);
	    priceEntity.setProductEntity(entity);

	    // ✅ Save
	    ProductEntity saved = iProductRepository.save(entity);

	    // ✅ Response
	    ProductResponse response = new ProductResponse();

	    if (saved != null) {
	        response.setProductId(String.valueOf(saved.getId())); // int ID
	        response.setConfirmationMsg("Your product has been uploaded successfully!");
	    } else {
	        response.setConfirmationMsg("Unable to upload the product!");
	    }

	    return response;
	}
	
	
	@Override
	public ProductResponse findProducts(String name, String status) {
		ProductResponse response = new ProductResponse();

		ProductEntity entity = iProductRepository.findByProductNameAndStatus(name, status);

		response.setProductId(entity.getProductId());
		response.setName(entity.getProductName());
		response.setStatus(entity.getStatus());

		return response;
	}

	@Override
	public String checkProductStatus(int productId) {

		ProductEntity entity = iProductRepository.findById(productId).orElse(null);

		if (entity != null) {
			return entity.getStatus();
		}

		return "PRODUCT NOT FOUND";
	}
	
}
