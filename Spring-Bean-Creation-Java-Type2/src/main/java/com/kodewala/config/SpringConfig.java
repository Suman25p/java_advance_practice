package com.kodewala.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kodewala.AccountInfo;

@Configuration
public class SpringConfig {

	@Bean("acc1")
	public AccountInfo createAccount1()
	{
		AccountInfo accountInfo = new AccountInfo();
		accountInfo.setAccountType("CURRENT");
		accountInfo.setName("Suman Pasi");
		accountInfo.setAccountNumber(12345);
		accountInfo.setBalance(5000000);
		return accountInfo;
	}
	
	@Bean("acc2")
	public AccountInfo createAccount2()
	{
		AccountInfo accountInfo = new AccountInfo();
		accountInfo.setAccountType("CURRENT");
		accountInfo.setName("Sunita Debi");
		accountInfo.setAccountNumber(54321);
		accountInfo.setBalance(1000000);
		return accountInfo;
	}
}
