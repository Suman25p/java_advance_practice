package com.kodekart.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue
    private int id;

    private int productId;
    private int quantity;
    
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
		
		
	}

   
}
