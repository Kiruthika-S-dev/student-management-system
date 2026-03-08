package com.example.student_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.student_management.DTO.StudentDTO;
import com.example.student_management.entity.Student;
import com.example.student_management.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	// Save student
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	//old entity Get all students
	public List<Student> getAllStudents() { //old entity
		return studentRepository.findAll();
	}

	// Get student by id
	public Student getStudentById(Long id) {
		return studentRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
	}

	// Update student
	public Student updateStudent(Long id, Student newStudent) {
		Student student = getStudentById(id);
		student.setName(newStudent.getName());
		student.setEmail(newStudent.getEmail());
		student.setCourse(newStudent.getCourse());

		return studentRepository.save(student);
	}

	// Delete student
	public void deleteStudent(Long id) {
		Student student = getStudentById(id);
		studentRepository.delete(student);
	}

	/*
	 * // Update student public Student updateStudent(Long id, Student newStudent) {
	 * Student student = studentRepository.findById(id) .orElseThrow(() -> new
	 * RuntimeException("Student not found with id: " + id));
	 * 
	 * student.setName(newStudent.getName());
	 * student.setEmail(newStudent.getEmail());
	 * student.setCourse(newStudent.getCourse());
	 * 
	 * return studentRepository.save(student); }
	 * 
	 * // Delete student public void deleteStudent(Long id) {
	 * studentRepository.deleteById(id); }
	 */

	// search students by name
	public List<Student> searchByName(String name) {
		return studentRepository.findByNameContainingIgnoreCase(name);
	}

	// search students by email
	public List<Student> searchByEmail(String email) {
		return studentRepository.findByEmailContainingIgnoreCase(email);
	}

	// search students by course
	public List<Student> searchByCourse(String course) {
		return studentRepository.findByCourseContainingIgnoreCase(course);
	}

	// add Page(pagination)
	public Page<Student> getStudents(Pageable pageable) {
		return studentRepository.findAll(pageable);
	}

	/*DTO Method
	public List<StudentDTO> getAllStudentsDTO() {
		List<Student> students = studentRepository.findAll();
		return students.stream().map(s -> new StudentDTO(s.getId(), s.getName(), s.getEmail(), s.getCourse())).toList();
	}*/
}