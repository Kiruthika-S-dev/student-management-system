🎓 Student Management System (Spring Boot)

📌 Project Description

Student Management System is a RESTful backend application developed using Java, Spring Boot, and PostgreSQL.
This project allows users to perform CRUD (Create, Read, Update, Delete) operations on student records through REST APIs.

This project is created as a backend portfolio project for learning Spring Boot and REST API development.

---

🚀 Tech Stack

- ☕ Java 17
- 🌱 Spring Boot
- 🗄️ PostgreSQL
- 📦 Maven
- 💻 Eclipse IDE
- 🔗 REST API
- 🧩 Spring Data JPA
- 🔍 Hibernate

---

📁 Project Structure

student-management-system
│── src/main/java/com/example/student_management
│   ├── controller
│   ├── service
│   ├── repository
│   ├── entity
│   └── exception
│
│── src/main/resources
│   └── application.properties
│
│── pom.xml
│── README.md

---

⚙️ Features

- ➕ Add Student
- 📄 Get All Students
- 🔍 Get Student by ID
- ✏️ Update Student
- ❌ Delete Student
- 🛑 Global Exception Handling
- 🗃️ Database Integration with PostgreSQL

---

🗄️ Database Configuration (PostgreSQL)

Update your "application.properties" file:

spring.datasource.url=jdbc:postgresql://localhost:5432/studentdb
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

---

▶️ How to Run the Project

1. Clone the repository:

git clone https://github.com/your-username/student-management-system.git

2. Open in Eclipse (Spring Tool Suite recommended)
3. Configure PostgreSQL database
4. Run:

StudentManagementApplication.java → Run As → Java Application

5. Server will start on:

http://localhost:8080

---

🔗 API Endpoints

📌 Base URL:

http://localhost:8080/students

1️⃣ Get All Students

GET /students

2️⃣ Get Student by ID

GET /students/{id}

3️⃣ Create Student

POST /students

Sample JSON:

{
  "name": "Kiruthika",
  "email": "kiruthika@gmail.com",
  "course": "Spring Boot"
}

4️⃣ Update Student

PUT /students/{id}

5️⃣ Delete Student

DELETE /students/{id}

---

🧪 Testing

You can test APIs using:

- Postman
- Browser (for GET APIs)
- Thunder Client (VS Code)

---

👩‍💻 Author

Kiruthika S
Java Full Stack Developer (Fresher)
Skills: Java, Spring Boot, Hibernate, PostgreSQL, REST API

---

⭐ Future Improvements

- Add Swagger Documentation
- Add Validation (@Valid)
- Add Pagination & Sorting
- Add Frontend (React/Angular)
- Deploy to Cloud (Render / Railway)
