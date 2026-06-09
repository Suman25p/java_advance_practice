package com.ytube.video.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ytube.video.request.VideoRequest;
import com.ytube.video.service.VideoService;

@RestController
@RequestMapping("/video")
public class VideoController {
	@Autowired
	private VideoService videoService;

	@PostMapping("/upload")
	public String uploadVideo(@RequestBody VideoRequest request) {
		videoService.uploadVideo(request);
		return "Video Uploaded Successfully";
	}
	
}
