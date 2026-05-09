package com.kodewala.profile.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class DevMessageService implements MesseageService{

	@Override
	public String getmessage() {
		
		return "Running Dev Environment";
	}

}
