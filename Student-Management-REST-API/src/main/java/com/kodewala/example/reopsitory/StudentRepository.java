package com.kodewala.example.reopsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kodewala.example.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
