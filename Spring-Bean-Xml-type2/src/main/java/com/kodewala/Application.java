package com.kodewala;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kodewala.pojo.Account;

public class Application {
	public static void main(String[] args) {
		
		String config = "applicationContext.xml";
	
		ApplicationContext context = new ClassPathXmlApplicationContext(config);
	
		Account account  = (Account) context.getBean("acc1");
	
		System.out.println(account.getFirstName() + " and " + account.getLastName());
		
		
	}
}
