package com.kodewala.app.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AccountMangement {
	
	@Autowired
	@Qualifier("acc2")
	Account account;
	
	@Autowired
	Payment payment;
	
	public void printDetails()
	{
		System.out.println("Account Name: " + account.getName() + " ,Type: " + account.getType());
		payment.print();
	}
}
