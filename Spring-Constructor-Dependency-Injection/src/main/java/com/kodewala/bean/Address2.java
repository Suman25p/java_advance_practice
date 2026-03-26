package com.kodewala.bean;

import org.springframework.stereotype.Component;

@Component
public class Address2 {
	private String line1 = "BTM 1st Stage";
	private String line2 = "9th cross road";
	private String city = "BLR";
	
	public String getAddress2()
	{
		return line1 + " ," + line2 + ", " + city;
	}
}
