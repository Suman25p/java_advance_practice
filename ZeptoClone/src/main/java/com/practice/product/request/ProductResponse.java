package com.practice.product.request;

public class ProductResponse {
	private int id;

	private String confirmationMsg;
	private String status;
	
	private String name;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String productId;
	
	
	

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getConfirmationMsg() {
		return confirmationMsg;
	}

	public String getStatus() {
		return status;
	}

	public String getName() {
		return name;
	}


	public void setConfirmationMsg(String confirmationMsg) {
		this.confirmationMsg = confirmationMsg;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setName(String name) {
		this.name = name;
	}

	

}
	
