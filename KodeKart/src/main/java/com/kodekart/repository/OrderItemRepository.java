package com.kodekart.repository;

import org.springframework.data.repository.CrudRepository;

import com.kodekart.entity.OrderItem;

public interface OrderItemRepository extends CrudRepository<OrderItem, Integer> {
	
}
