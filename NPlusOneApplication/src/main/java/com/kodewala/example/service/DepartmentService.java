package com.kodewala.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.kodewala.example.entity.Department;
import com.kodewala.example.repository.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepository repo;
	
	public List<Department> getDepartments(){
		List<Department> departments = repo.findAll();
		
		departments.forEach(dept-> {
			System.out.println(dept.getEmployees());
		});
		
		return departments;
		
	}
	
	public List<Department> getDepartmentsOptimized(){
		return repo.findAllWithEmployees();
	}
}
