package com.kodewala.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.kodewala.sample.entity.Product;
import com.kodewala.sample.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	
	
	public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
	
	
	@Cacheable(value = "products", key = "#id")
	public Product getProductById(Long id) {

		System.out.println("Fetching from DB...");

		// simulateSlowService();

		return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
	}

	private void simulateSlowService() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
