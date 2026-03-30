package com.kodewala.app.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountMgmt {
	
	@Autowired
	Account account;
	
	public void printDetails()
	{
		System.out.println("Account Name: " + account.getName() + " ,Type: " + account.getType());
	}
}
