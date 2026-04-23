package com.practice.product.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.practice.product.entity.ProductEntity;

public interface IProductRepository extends CrudRepository<ProductEntity, Integer> {
	public void findByStatus(String name);

	public ProductEntity findByProductNameAndStatus(@Param("name") String productName, @Param("status") String productStatus);
}
