package com.kodewala.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kodewala.bean.Employee2;
import com.kodewala.config.SpringConfig2;

public class Application {
	public static void main(String[] args) {
		
	ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig2.class);
	
	Employee2 emp1 = context.getBean(Employee2.class);
	
	emp1.printInfo();
	}
}
