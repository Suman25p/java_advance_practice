package com.productreview.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productreview.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer>{

}
