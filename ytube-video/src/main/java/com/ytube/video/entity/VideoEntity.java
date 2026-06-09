package com.ytube.video.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "videos")
public class VideoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	private String channelName;

	private String category;

	private String status;

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getChannelName() {
		return channelName;
	}

	public String getCategory() {
		return category;
	}

	public String getStatus() {
		return status;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
