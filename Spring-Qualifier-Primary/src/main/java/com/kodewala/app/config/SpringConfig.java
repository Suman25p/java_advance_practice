package com.kodewala.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.kodewala.app.bean.Account;
import com.kodewala.app.bean.Payment;

@Configuration
@ComponentScan(basePackages = "com.kodewala")
public class SpringConfig {
	
	@Bean("acc1")
	@Primary
	public Account createAccount1()
	{
		return new Account("Kodewala", "Current Account");
	}
	
	@Bean("acc2")
	public Account createAccount2()
	{
		return new Account("Kodewala2","Current Account2");
	}
	
	@Bean("pay")
	public Payment createPayment() {
		return new Payment();
	}
}
