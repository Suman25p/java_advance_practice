package com.kodewala;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kodewala.pojo.Account;

public class App {

	public static void main(String[] args) {

		String config = "applicationContext.xml";
		
		//Create IOC Container (BeanFactory / ApplicationContext)
		ApplicationContext context = new ClassPathXmlApplicationContext(config);

		//Requesting/ getting bean from Container
		Account account = (Account) context.getBean("acc1");

		//Using the account bean
		System.out.println(account.getFirstName() + " and " + account.getLastName());

		//Requesting/ getting bean from Container
		Account account2 = (Account) context.getBean("acc2");

		//Using the account bean
		System.out.println(account2.getAccountNumber() + " and " + account2.getAmount());

	}

}
