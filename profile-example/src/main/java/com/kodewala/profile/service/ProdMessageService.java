package com.kodewala.profile.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class ProdMessageService implements MesseageService {

	@Override
	public String getmessage() {
		
		return "Running Production Environment";
	}

}
