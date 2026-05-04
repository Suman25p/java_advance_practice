package com.kodekart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodekart.entity.InvalidProduct;

public interface InvalidProductRepository extends JpaRepository<InvalidProduct, Integer> {
}
