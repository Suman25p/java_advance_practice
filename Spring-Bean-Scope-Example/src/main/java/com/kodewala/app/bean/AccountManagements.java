package com.kodewala.app.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AccountManagements {
	
	@Autowired
	@Qualifier("acc1")
	Account1 account;

	@Autowired
	Payment1 payment;

	public void printDetails() {
		System.out.println(account.getName() + " and " + account.getType());
		payment.print();
	}
}
