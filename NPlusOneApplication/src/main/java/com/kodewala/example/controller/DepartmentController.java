package com.kodewala.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodewala.example.entity.Department;
import com.kodewala.example.service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService service;
	
	//N+1 problem API
	@GetMapping("/departments")
	public List<Department> getDepartments(){
		return service.getDepartments();
	}
	
	//Optimized API
	@GetMapping("/optimized")
	public List<Department> getOptimizedDepartments(){
		return service.getDepartmentsOptimized();
	}
}
