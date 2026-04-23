package com.practice.product.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "zepto_info")
public class ProductEntity {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String productId;
	@Column
	private String productName;

	@Column
	private String status;
	@Column
	private String qty;
	private String description;
	private String soldBy;
	private String price;
	private String priceType;
	
	@OneToOne(mappedBy = "productEntity", cascade = CascadeType.ALL)
	private PriceEntity priceEntity;

	public ProductEntity() {
		
	}
	
	public ProductEntity(int id, String productId, String productName, String status, String qty, String description,
			String soldBy, String price, String priceType, PriceEntity priceEntity) {
		this.id = id;
		this.productId = productId;
		this.productName = productName;
		this.status = status;
		this.qty = qty;
		this.description = description;
		this.soldBy = soldBy;
		this.price = price;
		this.priceType = priceType;
		this.priceEntity = priceEntity;
	}


	public int getId() {
		return id;
	}

	public String getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public String getStatus() {
		return status;
	}

	public String getQty() {
		return qty;
	}

	public String getDescription() {
		return description;
	}

	public String getSoldBy() {
		return soldBy;
	}

	public String getPrice() {
		return price;
	}

	public PriceEntity getPriceEntity() {
		return priceEntity;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setSoldBy(String soldBy) {
		this.soldBy = soldBy;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void setPriceEntity(PriceEntity priceEntity) {
		this.priceEntity = priceEntity;
	}
	public String getPriceType() {
		return priceType;
	}
	public void setPriceType(String priceType) {
		this.priceType = priceType;
	}
	
	
	
	
}
