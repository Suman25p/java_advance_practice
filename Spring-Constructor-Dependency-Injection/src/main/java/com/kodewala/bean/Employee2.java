package com.kodewala.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Employee2 {
	private String name;
	private String band;
	private Address2 address;
	
	@Autowired
	public Employee2(Address2 address)
	{
		this.address = address;
		this.name = "Suman Chaudhary";
		this.band = "S7";
	}
	
	public void printInfo()
	{
		System.out.println("Employee Details: ");
		System.out.println("Employee Name: " + name);
		System.out.println("Band: " + band);
		System.out.println("Address: " + address.getAddress2());
	}
}
