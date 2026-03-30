package com.kodewala.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kodewala.app.bean.AccountMgmt;
import com.kodewala.config.SpringConfig;

public class Application {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		
		
		AccountMgmt accountMgmt= context.getBean(AccountMgmt.class);
		accountMgmt.printDetails();
		context.close();

	}

}
