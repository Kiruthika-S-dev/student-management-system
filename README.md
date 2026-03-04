# Student Management System - Spring Boot REST API

A backend RESTful API built using Spring Boot to manage student records with full CRUD operations. The application is deployed on Render and connected to a cloud PostgreSQL database.

## 🚀 Live API
https://student-management-system-rv47.onrender.com/students

## 🛠 Tech Stack
- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven
- Docker
- Render (Cloud Deployment)

## 📌 Features
- Add new student
- Get all students
- Get student by ID
- Update student details
- Delete student

## 📡 API Endpoints

### Get all students
GET /students

### Get student by id
GET /students/{id}

### Add student
POST /students

Example JSON:
{
"name": "Kiruthika",
"email": "kiruthika@gmail.com",
"course": "BCA"
}

### Update student
PUT /students/{id}

### Delete student
DELETE /students/{id}

## 🗄 Database
PostgreSQL cloud database hosted on Render.

## 👩‍💻 Author
Kiruthika S
