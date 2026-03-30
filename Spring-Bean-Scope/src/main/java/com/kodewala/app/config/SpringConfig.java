package com.kodewala.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.kodewala.app.bean.Account;

@Configuration
@ComponentScan(basePackages = "com.kodewala")
public class SpringConfig {
	
	@Bean("acc1")
	public Account createAccount1()
	{
		return new Account("Kodewala1", "Current Account1");
	}
	
	@Bean("acc2")
	public Account createAccount2()
	{
		return new Account("Kodewala2", "Current Account2");
	}
}
