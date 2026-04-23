package com.productreview.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_table")
public class ProductEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	// 🔥 One product → many reviews
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<ReviewEntity> reviews;
	
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<ReviewEntity> getReviews() {
		return reviews;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setReviews(List<ReviewEntity> reviews) {
		this.reviews = reviews;
	}

	
}
