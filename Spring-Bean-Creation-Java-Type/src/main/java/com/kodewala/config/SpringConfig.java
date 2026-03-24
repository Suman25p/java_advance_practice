package com.kodewala.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kodewala.AccountInfo;

@Configuration //This class is responsible for Bean Definition
public class SpringConfig {

	//Define beans
	@Bean("acc1")
	public AccountInfo creatAccount()
	{
		AccountInfo accountInfo = new AccountInfo();
		accountInfo.setAccountType("CURRENT");
		accountInfo.setName("Suman");
		return accountInfo;
	}
}
