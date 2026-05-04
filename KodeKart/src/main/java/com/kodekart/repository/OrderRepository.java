package com.kodekart.repository;

import org.springframework.data.repository.CrudRepository;

import com.kodekart.entity.Orders;

public interface OrderRepository extends CrudRepository<Orders, Integer> {
	
}
