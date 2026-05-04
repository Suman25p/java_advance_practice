package com.kodekart.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue
    private int id;

    private double totalAmount;
    private String orderDate;
	public int getId() {
		return id;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

    
}
