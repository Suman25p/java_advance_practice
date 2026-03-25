package com.kodewala.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kodewala.AccountInfo;

@Configuration
public class SpringConfig {

	@Bean("acc1")
	public AccountInfo createAccount()
	{
		AccountInfo accountInfo = new AccountInfo();
		accountInfo.setAccountType("Current");
		accountInfo.setName("Suman");
		return accountInfo;
	}
	
}
