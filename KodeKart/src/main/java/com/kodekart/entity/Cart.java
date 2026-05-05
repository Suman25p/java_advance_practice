package com.kodekart.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue
    private int id;

    private int productId;
    private int quantity;
    @Column(name = "user_id")
    private int userId;

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public int getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setUserId(int userId) {
        this.userId = userId;   
    }
}