package com.blinket.product.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.blinket.product.entity.ProductEntity;

@Repository
public class ProductRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional   
    public String uploadProduct(String input) {

        String productId = java.util.UUID
                .nameUUIDFromBytes(input.getBytes())
                .toString()
                .replace("-", "")
                .substring(0, 4)
                .toUpperCase();

        ProductEntity product = new ProductEntity(productId, input);

        String prodId = (String) sessionFactory
                .getCurrentSession()
                .save(product);

        return prodId;
    }
}