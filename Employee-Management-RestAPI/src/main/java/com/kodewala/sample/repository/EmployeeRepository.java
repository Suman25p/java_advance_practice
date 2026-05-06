package com.kodewala.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodewala.sample.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
