package com.kodewala.example.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kodewala.example.entity.Employee;
import com.kodewala.example.service.EmployeeService;



@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	// POST
    @PostMapping
    public Employee saveEmployee(
            @RequestBody Employee employee) {

        return service.save(employee);
    }

    // GET ALL
    @GetMapping
    public List<Employee> getAllEmployees() {

        return service.getAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Employee getEmployeeById(
            @PathVariable int id) {

        return service.getById(id);
    }

    // PUT
    @PutMapping("/{id}")
    public Employee updateEmployee(
            @PathVariable int id,
            @RequestBody Employee employee) {

        return service.update(id, employee);
    }

    // PATCH
    @PatchMapping("/{id}")
    public Employee partialUpdate(
            @PathVariable int id,
            @RequestBody Map<String, Object> updates) {

        return service.partialUpdate(id, updates);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteEmployee(
            @PathVariable int id) {

        return service.delete(id);
    }

    // HEAD
    @RequestMapping(
            value = "/head",
            method = RequestMethod.HEAD)
    public ResponseEntity<Void> headMethod() {

        return ResponseEntity
                .ok()
                .header("Custom-Header",
                        "HEAD METHOD WORKING")
                .build();
    }

    // OPTIONS
    @RequestMapping(
            value = "/options",
            method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> optionsMethod() {

        return ResponseEntity
                .ok()
                .header(
                        "Allow",
                        "GET, POST, PUT, PATCH, DELETE, OPTIONS, HEAD")
                .build();
    }
}
