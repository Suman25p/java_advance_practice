package com.kodekart.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue
    private int id;

    private int orderId;
    private int productId;
    private int quantity;
    private double price;
	public int getId() {
		return id;
	}
	public int getOrderId() {
		return orderId;
	}
	public int getProductId() {
		return productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
