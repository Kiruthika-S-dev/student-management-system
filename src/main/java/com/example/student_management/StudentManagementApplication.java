package com.example.student_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
    info = @Info(
        title = "Student Management API",
        version = "1.0",
        description = "Production REST API built with " +
            "Java 17, Spring Boot, JWT Authentication, " +
            "BCrypt Encryption & PostgreSQL. " +
            "Deployed on Render with Docker.",
        contact = @Contact(
            name = "Kiruthika S",
            email = "kiruthikasaravanan2005@gmail.com",
            url = "http://www.linkedin.com/in/kiruthika-s05"
        )
    )
)

@SpringBootApplication
public class StudentManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}

}
