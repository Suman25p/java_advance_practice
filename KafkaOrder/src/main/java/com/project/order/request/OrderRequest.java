package com.project.order.request;

public class OrderRequest {
	private String customerName;
    private String productName;
    private String status;
    
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCustomerName() {
		return customerName;
	}
	public String getProductName() {
		return productName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}

}
