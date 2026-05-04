package com.kodekart.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kodekart.entity.Cart;

public interface CartRepository extends CrudRepository<Cart, Integer> {
	List<Cart> findByUserId(int userId);
}
