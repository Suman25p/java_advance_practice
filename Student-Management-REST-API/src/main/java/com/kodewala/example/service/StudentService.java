package com.kodewala.example.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodewala.example.entity.Student;
import com.kodewala.example.reopsitory.StudentRepository;


@Service
public class StudentService {

	@Autowired
	private StudentRepository repo;

	// POST
	public Student save(Student student) {

		return repo.save(student);
	}

	public List<Student> getAll() {
		return repo.findAll();
	}

	public Student getById(int id) {
		return repo.findById(id).orElse(null);
	}

	// put
	public Student update(int id, Student student) {
		Student old = repo.findById(id).orElse(null);

		if (old != null) {
			old.setName(student.getName());
			old.setCourse(student.getCourse());
			old.setFee(student.getFee());

			return repo.save(old);
		}

		return null;
	}

	// PatCh
	public Student partialUpdate(int id, Map<String, Object> updates) {

		Student student = repo.findById(id).orElse(null);

		if (student != null) {
			if (updates.containsKey("name")) {
				student.setName(updates.get("name").toString());
			}

			if (updates.containsKey("course")) {
				student.setCourse(updates.get("course").toString());
			}

			if (updates.containsKey("fee")) {
				student.setFee(Double.parseDouble(updates.get("fee").toString()));
			}
			return repo.save(student);

		}
		return null;
	}

	// DELETE
	public String delete(int id) {

		repo.deleteById(id);

		return "Student Deleted Successfully";
	}

}
