package com.kodewala.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kodewala.app.bean.AccountMangement;
import com.kodewala.app.config.SpringConfig;

public class Application {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		
		AccountMangement account = context.getBean(AccountMangement.class);
		
		account.printDetails();

	}

}

//Account Name: Kodewala2 ,Type: Current Account2
//Printing Deatils....