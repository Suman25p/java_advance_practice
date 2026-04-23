package com.productreview.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productreview.entity.ProductEntity;
import com.productreview.entity.ReviewEntity;
import com.productreview.iservice.ProductService;
import com.productreview.repository.ProductRepository;
import com.productreview.request.ProductRequest;
import com.productreview.response.ProductResponse;

import jakarta.transaction.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Transactional
	@Override
	public ProductResponse createProduct(ProductRequest request) {

	    ProductEntity product = new ProductEntity();
	    product.setName(request.getName());

	    List<ReviewEntity> reviewList = new ArrayList<>();

	    for (String comment : request.getComments()) {

	        if (comment != null && !comment.isEmpty()) {  // ✅ extra safe

	            ReviewEntity review = new ReviewEntity();
	            review.setComment(comment);

	            review.setProduct(product);  // relationship

	            reviewList.add(review);
	        }
	    }

	    product.setReviews(reviewList);

	    ProductEntity saved = productRepository.save(product);

	    ProductResponse response = new ProductResponse();
	    response.setProductId(saved.getId());
	    response.setMessage("Product with reviews saved successfully");

	    return response;
	}

}
