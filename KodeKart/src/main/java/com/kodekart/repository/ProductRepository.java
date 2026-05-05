package com.kodekart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodekart.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByCategory(String category);

	List<Product> findByNameContainingIgnoreCase(String keyword);
}
