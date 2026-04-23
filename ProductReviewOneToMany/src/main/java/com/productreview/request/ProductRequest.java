package com.productreview.request;

import java.util.List;

public class ProductRequest {
	private String name;
	private List<String> comments;
	
    public String getName() {
		return name;
	}
	public List<String> getComments() {
		return comments;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setComments(List<String> comments) {
		this.comments = comments;
	}
	
}
