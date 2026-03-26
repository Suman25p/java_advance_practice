package com.kodewala.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	
	@Value("Suman")
	private String name;
	@Value("B1")
	private String band;

	@Autowired
	private Address address;

	public void print() {
		System.out.println("Employee Details:");
		System.out.println("Name: " + name);
		System.out.println("Band: " + band);
		System.out.println("Address: " + address.getAddress());
	}
}
