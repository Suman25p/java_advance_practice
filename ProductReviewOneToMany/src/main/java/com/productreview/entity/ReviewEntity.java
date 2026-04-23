package com.productreview.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "review_table")
public class ReviewEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String comment;
	
	 // 🔥 Many → One
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;
    
	public int getId() {
		return id;
	}

	public String getComment() {
		return comment;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

}
