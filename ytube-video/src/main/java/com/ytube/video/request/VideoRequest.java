package com.ytube.video.request;

public class VideoRequest {
	private String title;

    private String channelName;

    private String category;

    private String status;
    
    public VideoRequest() {
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
