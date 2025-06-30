# Audit Service

The **Audit Service** is a Spring Boot microservice designed to track and log user activities and events across the system. It plays a crucial role in providing traceability and accountability in a microservices architecture.

## 🔧 Features

- Records user actions and system events
- Stores logs in a persistent database (e.g., MySQL, PostgreSQL)
- RESTful API endpoints for storing and retrieving audit data
- Integration with other services using REST or Kafka (optional)

## 📦 Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL/PostgreSQL
- Maven

## 🚀 API Endpoints

| Method | Endpoint          | Description            |
|--------|-------------------|------------------------|
| POST   | /audit            | Create audit log entry |
| GET    | /audit            | Get all audit entries  |
| GET    | /audit/{id}       | Get audit by ID        |

## ⚙️ Configuration

Update `application.yml` or `application.properties` with DB connection info:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/audit_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update

