package com.kodewala.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.kodewala.app.bean.Account1;
import com.kodewala.app.bean.Payment1;

@Configuration
@ComponentScan(basePackages = "com.kodewala.app")
public class SpringConfig {

	@Bean("acc1")
	public Account1 createAccount1() {
		return new Account1("Kodewala1", "Current Account1");
	}

	@Lazy
	@Bean("acc2")
	public Account1 createAccount2() {
		return new Account1("Kodewala2", "Current Account2");
	}

	@Bean("pay")
	public Payment1 createPayment() {
		return new Payment1();
	}
}