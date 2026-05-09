package com.kodewala.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kodewala.example.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

	//N+1 problem
	List<Department> findAll();

	  // SOLUTION USING JOIN FETCH
    @Query("""
        SELECT DISTINCT d
        FROM Department d
        JOIN FETCH d.employees
    """)
	List<Department> findAllWithEmployees();
}
