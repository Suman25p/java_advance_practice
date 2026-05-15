package com.kodewala.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kodewala.example.entity.Employee;
import com.kodewala.example.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	// SAVE EMPLOYEE
	public Employee saveEmployee(Employee employee) {

		return employeeRepository.save(employee);
	}

	public Page<Employee> getEmployees(int page, int size) {

		Pageable pageable = PageRequest.of(page, size);

		return employeeRepository.findAll(pageable);
	}
}
