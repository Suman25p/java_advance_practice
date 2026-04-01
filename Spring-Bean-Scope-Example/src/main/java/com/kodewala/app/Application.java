package com.kodewala.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kodewala.app.bean.AccountManagements;
import com.kodewala.app.config.SpringConfig;

public class Application {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

		AccountManagements accountMgmt = context.getBean(AccountManagements.class);

		accountMgmt = context.getBean(AccountManagements.class);
		accountMgmt.printDetails();
		
		context.close(); // close the ioc container
	}
}
