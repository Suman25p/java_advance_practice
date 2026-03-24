package com.kodewala;

public class AccountInfo {

	private String name;
	private String accountType;
	
	public AccountInfo(String name, String accountType) {
		
		this.name = name;
		this.accountType = accountType;
	}
	
	public void printDetails()
	{
		System.out.println("Account Details: " + name + " and " + accountType);
	}
}
