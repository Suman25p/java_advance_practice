package com.zepto.product.request;

public class ProductRequest {
	private String name;
	private String qty;
	private String description;
	private String price;
	private String soldby;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getSoldby() {
		return soldby;
	}
	public void setSoldby(String soldby) {
		this.soldby = soldby;
	}
	
}
