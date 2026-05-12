package com.kodewala.example.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodewala.example.entity.Employee;
import com.kodewala.example.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repo;
	
	// POST
    public Employee save(Employee employee) {
        return repo.save(employee);
    }
    
 // GET ALL
    public List<Employee> getAll() {
        return repo.findAll();
    }

    // GET BY ID
    public Employee getById(int id) {
        return repo.findById(id).orElse(null);
    }

    // PUT
    public Employee update(int id, Employee employee) {

        Employee old = repo.findById(id).orElse(null);

        if(old != null) {
            old.setName(employee.getName());
            old.setEmail(employee.getEmail());
            old.setSalary(employee.getSalary());

            return repo.save(old);
        }

        return null;
    }

    // PATCH
    public Employee partialUpdate(int id,
                                  Map<String, Object> updates) {

        Employee employee = repo.findById(id).orElse(null);

        if(employee != null) {

            if(updates.containsKey("name")) {
                employee.setName((String) updates.get("name"));
            }

            if(updates.containsKey("email")) {
                employee.setEmail((String) updates.get("email"));
            }

            if(updates.containsKey("salary")) {
                employee.setSalary(
                        Double.parseDouble(
                                updates.get("salary").toString()));
            }

            return repo.save(employee);
        }

        return null;
    }

    // DELETE
    public String delete(int id) {

        repo.deleteById(id);

        return "Employee Deleted Successfully";
    }
}
