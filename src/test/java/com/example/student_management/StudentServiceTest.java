package com.example.student_management;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.example.student_management.DTO.StudentDTO;
import com.example.student_management.entity.Student;
import com.example.student_management.repository.StudentRepository;
import com.example.student_management.service.StudentService;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    private Student student1;
    private Student student2;

    @BeforeEach
    void setUp() {
        student1 = new Student();
        student1.setId(1L);
        student1.setName("Kiruthika");
        student1.setEmail("kiruthika@gmail.com");
        student1.setCourse("BCA");

        student2 = new Student();
        student2.setId(2L);
        student2.setName("Rahul");
        student2.setEmail("rahul@gmail.com");
        student2.setCourse("MCA");
    }

    // 1 — Get All Students
    @Test
    void shouldReturnAllStudents() {
        when(studentRepository.findAll())
            .thenReturn(Arrays.asList(student1, student2));

        List<Student> result = studentService.getAllStudents ();//DTO

        assertEquals(2, result.size());
        assertEquals("Kiruthika", result.get(0).getName());
        System.out.println("Test 1 Passed: getAllStudents()");
    }

    //2 — Get Student By ID
    @Test
    void shouldReturnStudentById() {
        when(studentRepository.findById(1L))
            .thenReturn(Optional.of(student1));

        Student result = studentService.getStudentById(1L);

        assertNotNull(result);
        assertEquals("Kiruthika", result.getName());
        assertEquals("BCA", result.getCourse());
        System.out.println("Test 2 Passed: getStudentById()");
    }

    //3 — Save Student
    @Test
    void shouldSaveStudent() {
        when(studentRepository.save(student1))
            .thenReturn(student1);

        Student result = studentService.saveStudent(student1);

        assertNotNull(result);
        assertEquals("kiruthika@gmail.com", result.getEmail());
        System.out.println("Test 3 Passed: saveStudent()");
    }

    //4 — Delete Student
    @Test
    void shouldDeleteStudent() {
        when(studentRepository.findById(1L))
            .thenReturn(Optional.of(student1));
        doNothing().when(studentRepository)
            .delete(student1);

        assertDoesNotThrow(() ->
            studentService.deleteStudent(1L));
        System.out.println("Test 4 Passed: deleteStudent()");
    }

    //5 — Student Not Found Exception
    @Test
    void shouldThrowExceptionWhenStudentNotFound() {
        when(studentRepository.findById(99L))
            .thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () ->
            studentService.getStudentById(99L));
        System.out.println("Test 5 Passed: StudentNotFoundException");
    }

    //6 — Search By Name
    @Test
    void shouldSearchByName() {
        when(studentRepository
            .findByNameContainingIgnoreCase("Kiruthika"))
            .thenReturn(Arrays.asList(student1));

        List<Student> result = 
            studentService.searchByName("Kiruthika");

        assertEquals(1, result.size());
        assertEquals("Kiruthika", result.get(0).getName());
        System.out.println("Test 6 Passed: searchByName()");
    }

    //7 — Search By Course
    @Test
    void shouldSearchByCourse() {
        when(studentRepository
            .findByCourseContainingIgnoreCase("BCA"))
            .thenReturn(Arrays.asList(student1));

        List<Student> result = 
            studentService.searchByCourse("BCA");

        assertEquals(1, result.size());
        assertEquals("BCA", result.get(0).getCourse());
        System.out.println("Test 7 Passed: searchByCourse()");
    }

    //8 — Pagination
    @Test
    void shouldReturnPagedStudents() {
        Pageable pageable = PageRequest.of(0, 5);
        Page<Student> page = new PageImpl<>(
            Arrays.asList(student1, student2));

        when(studentRepository.findAll(pageable))
            .thenReturn(page);

        Page<Student> result = 
            studentService.getStudents(pageable);

        assertEquals(2, result.getTotalElements());
        System.out.println("Test 8 Passed: getStudents() pagination");
      }
}