# 🎓 Student Management System — Spring Boot REST API

![Java](https://img.shields.io/badge/Java-17-orange?style=flat&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.2-brightgreen?style=flat&logo=springboot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Cloud-blue?style=flat&logo=postgresql)
![Docker](https://img.shields.io/badge/Docker-Deployed-2496ED?style=flat&logo=docker)
![JWT](https://img.shields.io/badge/JWT-Security-black?style=flat&logo=jsonwebtokens)
![Swagger](https://img.shields.io/badge/Swagger-UI-85EA2D?style=flat&logo=swagger)
![Render](https://img.shields.io/badge/Render-Live-46E3B7?style=flat&logo=render)

A **production-ready RESTful backend API** built with Java 17 and Spring Boot.
Fully secured with JWT Authentication, Dockerized, and deployed live on Render cloud platform.

---

## 🌐 Live Links

| Link | Description |
|------|-------------|
| [🖥️ Live Demo Webpage](https://kiruthika-s-dev.github.io/student-management-system/) | Beautiful dashboard UI |
| [⚡ Live REST API](https://student-management-system-rv47.onrender.com/students) | JSON API endpoint |
| [📖 Swagger UI Docs](https://student-management-system-rv47.onrender.com/swagger-ui/index.html) | Interactive API documentation |

> ⏳ **Note:** First load may take 30-60 seconds as Render free tier wakes up. Please refresh once!
  🔐 **Authentication Required:** This API is secured with JWT! All /students endpoints require a valid token.
> 👉 Use Swagger UI to test: https://student-management-system-rv47.onrender.com/swagger-ui/index.html
> register, login, get token, click Authorize and test! 🔓

---

## ✨ Features

- ✅ **Full CRUD Operations** — Create, Read, Update, Delete students
- ✅ **JWT Authentication** — Secure token-based login system
- ✅ **BCrypt Password Encryption** — Industry-standard password hashing
- ✅ **Search & Filter** — Search by name, email, or course
- ✅ **Pagination** — Efficient data retrieval with page support
- ✅ **Swagger UI Documentation** — Interactive API testing interface
- ✅ **Global Exception Handling** — Clean error responses with HTTP status codes
- ✅ **Layered Architecture** — Controller → Service → Repository → Entity
- ✅ **Docker Deployment** — Containerized for consistent cloud deployment
- ✅ **Cloud PostgreSQL** — Production database hosted on Render

---

## 🛠️ Tech Stack

| Category | Technology |
|----------|-----------|
| Language | Java 17 |
| Framework | Spring Boot 4.0.2 |
| Security | Spring Security, JWT, BCrypt |
| Database | PostgreSQL (Cloud) |
| ORM | Spring Data JPA, Hibernate |
| Build Tool | Maven |
| Container | Docker |
| API Docs | Swagger / OpenAPI 3.1 |
| Deployment | Render Cloud Platform |
| Version Control | Git & GitHub |
| Testing | Postman, JUnit, Mockito |

---

## 📡 API Endpoints

### 🔐 Authentication (Public)

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/auth/register` | Register new user |
| POST | `/auth/login` | Login & get JWT token |

### 👨‍🎓 Students (JWT Protected)

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/students` | Get all students |
| GET | `/students/{id}` | Get student by ID |
| POST | `/students` | Add new student |
| PUT | `/students/{id}` | Update student |
| DELETE | `/students/{id}` | Delete student |
| GET | `/students/search/name?name=` | Search by name |
| GET | `/students/search/email?email=` | Search by email |
| GET | `/students/search/course?course=` | Search by course |
| GET | `/students/page?page=0&size=5` | Get paginated students |

---

## 🔐 How to Use JWT Authentication

**Step 1 — Register:**
```json
POST /auth/register
{
  "username": "kiruthika",
  "password": "password123"
}
```

**Step 2 — Login & get token:**
```json
POST /auth/login
{
  "username": "kiruthika",
  "password": "password123"
}
```
Response:
```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```

**Step 3 — Use token in requests:**
```
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9...
```

---

## 🏗️ Project Architecture

```
src/main/java/com/example/student_management/
├── 📁 controller/
│   ├── StudentController.java    # REST endpoints
│   └── AuthController.java       # Auth endpoints
├── 📁 service/
│   └── StudentService.java       # Business logic
├── 📁 repository/
│   └── StudentRepository.java    # Database operations
├── 📁 entity/
│   └── Student.java              # Data model
├── 📁 security/
│   ├── JwtUtil.java              # JWT token handling
│   ├── SecurityConfig.java       # Security configuration
│   └── JwtFilter.java            # JWT request filter
├── 📁 exception/
│   └── GlobalExceptionHandler.java # Error handling
└── StudentManagementApplication.java
```

---

## 🐳 Docker Deployment

```dockerfile
# Build and run with Docker
docker build -t student-management .
docker run -p 8080:8080 student-management
```

---

## 🚀 Run Locally

**Prerequisites:**
- Java 17+
- Maven
- PostgreSQL

**Steps:**
```bash
# Clone the repository
git clone https://github.com/Kiruthika-S-dev/student-management-system.git

# Navigate to project
cd student-management-system

# Configure database in application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/student_db
spring.datasource.username=postgres
spring.datasource.password=yourpassword

# Run the application
mvn spring-boot:run
```

API will start at: `http://localhost:8080`
Swagger UI at: `http://localhost:8080/swagger-ui/index.html`

---

## 📸 API in Action

### ✅ GET All Students — 200 OK
![GET Students](get-students.png) 

### ✅ POST Add Student — 201 Created
![POST Student](POST-students.png)

### ✅ DELETE Student — 200 OK
![DELETE Student](DELETE-students.png)

---

## 🧪 Testing

- **Postman** — All endpoints tested manually
- **JUnit + Mockito** — 8 unit tests covering:
  - getAllStudents()
  - getStudentById()
  - saveStudent()
  - deleteStudent()
  - searchByName()
  - searchByCourse()
  - Pagination
  - Exception handling

---

## 👩‍💻 Author

**Kiruthika S** — Java Backend Developer

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=flat&logo=linkedin&logoColor=white)](http://www.linkedin.com/in/kiruthika-s05)
[![GitHub](https://img.shields.io/badge/GitHub-100000?style=flat&logo=github&logoColor=white)](https://github.com/Kiruthika-S-dev/)
[![LeetCode](https://img.shields.io/badge/LeetCode-FFA116?style=flat&logo=leetcode&logoColor=white)](https://leetcode.com/u/Kiruthika_S2005/)

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).
