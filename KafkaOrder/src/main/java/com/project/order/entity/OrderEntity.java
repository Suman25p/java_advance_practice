package com.project.order.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class OrderEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;

	private String customerName;

	private String productName;

	private String status;

	public Long getOrderId() {
		return orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getProductName() {
		return productName;
	}

	public String getStatus() {
		return status;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
