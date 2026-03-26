package com.kodewala.bean;

import org.springframework.stereotype.Component;

@Component
public class Address {
	
	private String city = "Kolkata";
	
	  public String getAddress() {
	        return  city;
	    }
	
	
}
