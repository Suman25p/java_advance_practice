package com.kodewala.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kodewala.AccountInfo;

@Configuration
public class SpringConfig {

	@Bean("acc1")
	public AccountInfo createAccount1()
	{
		AccountInfo accountInfo = new AccountInfo("Suraj Pal", "Saving");
		return accountInfo;
	}
	
	@Bean("acc2")
	public AccountInfo createAccount2()
	{
		AccountInfo accountInfo2 = new AccountInfo("Moni Roy", "Current");
		return accountInfo2;
	}
}
