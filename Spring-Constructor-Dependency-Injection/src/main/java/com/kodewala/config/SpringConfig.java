package com.kodewala.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.kodewala.bean.Address;
import com.kodewala.bean.Employee;

@Configuration
public class SpringConfig {
	
	@Bean
	public Address address()
	{
		return new Address("2nd Main", "27th Cross", "BLR");
	}
	
	@Bean
	public Employee employee(Address address)
	{
		return new Employee("Kodewala","B1",address);
	}

}
