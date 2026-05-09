package com.kodewala.profile.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodewala.profile.service.MesseageService;

@RestController
public class MyController {

	@Autowired
    private MesseageService  service;
	
	@GetMapping("msg")
	public String getMsg() {
		return service.getmessage();
	}
}
