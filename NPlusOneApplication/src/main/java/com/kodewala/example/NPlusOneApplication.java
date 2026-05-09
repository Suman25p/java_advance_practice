package com.kodewala.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kodewala.example.entity.Department;
import com.kodewala.example.entity.Employee;
import com.kodewala.example.repository.DepartmentRepository;

@SpringBootApplication
public class NPlusOneApplication implements CommandLineRunner {

	@Autowired
	private DepartmentRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(NPlusOneApplication.class, args);
	}

	@Override
	public void run(String... args)
	{
		Department it = new Department("IT");
		Department hr = new Department("HR");
		
		Employee e1 = new Employee("Suman", it);
		Employee e2 = new Employee("Ravi", it);
		Employee e3 = new Employee("Priya", hr);
		
		it.setEmployees(List.of(e1,e2));
		hr.setEmployees(List.of(e3));
		
		repo.save(it);
		repo.save(hr);
	}
	
	
}
