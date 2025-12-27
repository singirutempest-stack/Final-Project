# Final Project — Online Shop Backend

## 📌 Project Description

This project is a **Spring Boot REST API** for an online shop.  
It was developed as a **final project for the academic session** and demonstrates a complete backend application with security, business logic, database integration, and testing.

The system supports authentication, role-based access control, product management, carts, orders, and payments.

---

## 🛠 Technology Stack

- Java  
- Spring Boot  
- Spring Security + JWT  
- Gradle  
- PostgreSQL  
- Liquibase (database migrations)  
- MapStruct  
- Docker & Docker Compose  
- JUnit 5 + Mockito  

---

## 🧱 Application Architecture

The project follows a **layered architecture**:

Controller → Service → Repository → Database  
DTO ↔ Mapper ↔ Entity

### Main layers:
- **Controller layer** — REST API endpoints
- **Service layer** — business logic
- **Repository layer** — data access layer (JPA)
- **Security layer** — authentication and authorization using JWT

---

## 🔐 Security

Security is implemented using **Spring Security** and **JWT authentication**.

### Implemented features:
- User registration and login
- JWT token generation and validation
- Stateless authentication
- Role-based access control

### Roles:
- `ADMIN`
- `USER`
- `SELLER`

Access to API endpoints is restricted based on user roles.

---

## 🧩 Business Entities

Main business entities in the project:

- User  
- Role  
- Seller  
- Product  
- Category  
- Cart  
- CartItem  
- Order  
- OrderItem  
- Payment  

All REST controllers work **only with DTOs**.  
Entity objects are not returned directly.

---

## 📦 API Functionality

Implemented functionality includes:

- User registration and authentication
- Password change
- User management (admin)
- Role management
- Product and category management
- Shopping cart operations
- Order creation and viewing
- Payment processing
- Seller management

---

## 🗄 Database

- PostgreSQL is used as the main database
- Database schema and initial data are managed with **Liquibase**
- Migration scripts are located in:
