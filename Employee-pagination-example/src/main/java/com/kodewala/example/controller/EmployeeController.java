package com.kodewala.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kodewala.example.entity.Employee;
import com.kodewala.example.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	// INSERT EMPLOYEE
	@PostMapping
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {

		Employee savedEmployee = employeeService.saveEmployee(employee);

		return ResponseEntity.ok(savedEmployee);
	}

	@GetMapping
	public Page<Employee> getEmployees(@RequestParam int page, @RequestParam int size) {

		return employeeService.getEmployees(page, size);
	}
}
