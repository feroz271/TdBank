# TdBank
# 🏦 TD Bank REST API

A **TD Bank REST API** built with **Spring Boot**, **JPA**, **MySQL**, and **Lombok**.  
It manages **Customers** and their **Bank Accounts**, following a clean **layered architecture**.

---

## 📖 Overview
This project demonstrates how to build a **banking backend** using Spring Boot.  
It follows a **5-layer architecture**:
- **Entity** – Represents database tables.  
- **Repository** – Handles CRUD operations.  
- **Service** – Business logic layer.  
- **Controller** – REST API endpoints.  
- **Exception** – Centralized error handling.

---

## ✨ Features
### 👤 Customer Management
- CRUD operations (Create, Read, Update, Delete) for customers.  
- Validation and global error handling (`@RestControllerAdvice`).  

### 💳 Bank Account Management
- One-to-Many mapping: **Each Customer can have multiple Bank Accounts**.  
- CRUD operations with validation to ensure every account is linked to a valid customer.  

### ⚠️ Exception Handling
- **Custom `ResourceNotFoundException`** for missing entities.  
- Centralized responses using **GlobalExceptionHandler**.  

### 🗄️ Database Integration
- **MySQL** as the relational database.  
- Auto schema updates using `spring.jpa.hibernate.ddl-auto=update`.  
- SQL query logging with `spring.jpa.show-sql=true`.

---

## 🛠️ Tech Stack
| Technology      | Purpose                          |
|-----------------|-----------------------------------|
| **Java 17**     | Programming language             |
| **Spring Boot 3.2** | Application framework         |
| **Spring Data JPA** | ORM for database operations   |
| **MySQL**       | Relational database              |
| **Maven**       | Dependency management            |
| **Lombok**      | Reduces boilerplate code         |
| **Postman**     | API testing                      |

---

## ⚡ Getting Started
### Prerequisites
- Java 17+
- MySQL database
- Maven

### Steps
```bash
# 1️⃣ Clone the repository
git clone https://github.com/your-username/tdbank-api.git
cd tdbank-api

# 2️⃣ Configure MySQL in application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/tdbank
spring.datasource.username=YOUR_USER
spring.datasource.password=YOUR_PASS

# 3️⃣ Build and run
mvn clean install
mvn spring-boot:run
