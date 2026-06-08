package com.kodewala.order.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kodewala.order.entity.OrderEntity;

@Repository
public interface OrderRepositoy extends CrudRepository<OrderEntity, Integer>{

}
