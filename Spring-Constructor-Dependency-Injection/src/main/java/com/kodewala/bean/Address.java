package com.kodewala.bean;

public class Address {
	private String line1;
	private String line2;
	private String city;
	
	public Address(String line1, String line2, String city) {
		
		this.line1 = line1;
		this.line2 = line2;
		this.city = city;
	}
	
	public String getAddress() {
        return line1 + ", " + line2 + ", " + city;
    }

	
}
