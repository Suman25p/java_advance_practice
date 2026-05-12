package com.kodewala.example.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kodewala.example.entity.Student;
import com.kodewala.example.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	//post
	@PostMapping
	public Student saveStudent(@RequestBody Student student) {
		return service.save(student);
	}
	
	//Get All
	@GetMapping
	public List<Student> getAllStudents()
	{
		return service.getAll();
	}
	
	//Get By Id
	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable int id) {
		return service.getById(id);
	}
	
	//put
	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable int id, @RequestBody Student student)
	{
		return service.update(id, student);
	}

	//patch
	@PatchMapping("/{id}")
	public Student partialUpdate(@PathVariable int id, @RequestBody Map<String, Object> updates) {
		return service.partialUpdate(id, updates);
	}
	
	//Delete
	public String deleteStudent(@PathVariable int id) {
		return service.delete(id);
	}
	
	//Head
    @RequestMapping(value = "/head",
    				method = RequestMethod.HEAD)
    public ResponseEntity<Void> headMethod(){
    	return ResponseEntity.ok()
    				.header("Student-App","HEAD METHOD WORKING")
    				.build();
    }
    
    // OPTIONS
    @RequestMapping(value= "/options",
    				method= RequestMethod.OPTIONS)
    public ResponseEntity<Void> optionsMethod(){
    	return ResponseEntity.ok()
    				.header("Allow", "GET,POST,PUT,PATCH,DELETE,HEAD,OPTIONS")
    				.build();
    }

}
