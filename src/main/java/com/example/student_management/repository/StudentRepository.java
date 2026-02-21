package com.example.student_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.student_management.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
	// search by name
	List<Student>findByNameContainingIgnoreCase(String name);
	
	// search by email
	List<Student>findByEmail(String email);

}
