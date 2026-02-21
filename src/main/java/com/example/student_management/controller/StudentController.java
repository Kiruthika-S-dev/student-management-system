package com.example.student_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.student_management.entity.Student;
import com.example.student_management.repository.StudentRepository;
import com.example.student_management.service.StudentService;

import jakarta.validation.Valid;

@RestController 
@RequestMapping("/students")
public class StudentController {     // command line full of repository and real code is serrvice
	
	@Autowired
	private StudentService studentService; // (private StudentRepository studentRepository;)
	
	@PostMapping //add student POST API 
	public Student addStudent(@Valid @RequestBody Student student) {
		return studentService.saveStudent(student);
	}
	
	@GetMapping //get all student GET API
	public List<Student>getAllStudents(){
		return studentService.getAllStudents(); //findAll();
	}
	
	@GetMapping("/{id}") //get student by id
	public Student getStudentById(@PathVariable Long id) {
		return studentService.getStudentById(id);
	}
	

	@PutMapping("/{id}") // PUT API update student by id
	public Student updateStudent(@Valid @PathVariable Long id, @RequestBody Student student) {
		return studentService.updateStudent(id, student);
	}
	
	/*public Student updateStudent(@PathVariable Long id, @RequestBody Student newStudent) {
	    return studentRepository.findById(id)
	            .map(student -> {
	                student.setName(newStudent.getName());
	                student.setEmail(newStudent.getEmail());
	                student.setCourse(newStudent.getCourse());
	                return studentRepository.save(student);
	            })
	            .orElseThrow(() -> new RuntimeException("Student not found with id " + id));
	}*/
	
	@DeleteMapping("/{id}") // delete student by id
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return "Student deleted successfully";
	}
	
	// search by name
	@GetMapping("/search/name")
	public List<Student>searchByName(@RequestParam String name) {
		return studentService.searchByName(name);
	}
	
	// search by email
	@GetMapping("/search/email")
	public List<Student>searchByEmail(@RequestParam String email) {
		return studentService.searchByEmail(email);
	}
}
