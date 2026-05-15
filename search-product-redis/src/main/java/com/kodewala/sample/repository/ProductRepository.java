package com.kodewala.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kodewala.sample.entity.Product;

@Repository
public interface  ProductRepository extends JpaRepository<Product, Long> {

}
