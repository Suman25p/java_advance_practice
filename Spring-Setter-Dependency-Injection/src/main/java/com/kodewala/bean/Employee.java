package com.kodewala.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	private String name;
	private String band;
	private Address address;
	
	public Employee()
	{
		this.name = "Suman";
		this.band = "A1";
	}
	
	// Setter Injection
	@Autowired
	public void setAddress(Address address)
	{
		this.address = address;
	}
	
	public void print() {
	    System.out.println("Employee Details:");
	    System.out.println("Name: " + name);
	    System.out.println("Band: " + band);

	    if (address != null) {
	        System.out.println("Address: " + address.getAddress());
	    } else {
	        System.out.println("Address not injected");
	    }
	}
}
