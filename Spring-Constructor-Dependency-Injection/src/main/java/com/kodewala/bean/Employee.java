package com.kodewala.bean;

import org.springframework.beans.factory.annotation.Autowired;

public class Employee {
	private String name;
	private String band;
	
	private Address address;
	
	@Autowired
	public Employee(Address address)
	{
		this.address = address;
	}
	
	public Employee(String name, String band, Address address) {
		this.name = name;
		this.band = band;
		this.address = address;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}	
	
	public void print()
	{
		System.out.println("Employee Details:");
		System.out.println("Employee Name: " + name);
		System.out.println("Band: " + band);
		System.out.println("Address: " + address.getAddress());
	}
}
