# OnDemand Backend

## Overview

**OnDemand Backend** is a Spring Boot application designed to power an on-demand services platform. It provides a robust RESTful API for managing service requests, user data, and administrative operations. Built with Java, Spring Boot, and MySQL, this project emphasizes scalability, performance, and clean code practices using object-oriented design and design patterns. It was developed as part of a real-world internship project to support a web and mobile application ecosystem.

---

## Features

- **RESTful APIs**: Endpoints for user management, service requests, and administrative dashboards.
- **Database Integration**: MySQL for persistent storage of user data, service details, and transactions.
- **Scalable Architecture**: Leverages Spring Boot’s microservices-ready framework for easy expansion.
- **Security**: Basic authentication and authorization mechanisms (configurable via Spring Security).
- **Real-Time Processing**: Optimized for handling concurrent requests efficiently.

---

## Tech Stack

- **Language**: Java
- **Framework**: Spring Boot
- **Database**: MySQL
- **Build Tool**: Maven

### Dependencies

- Spring Web (RESTful services)
- Spring Data JPA (database operations)
- MySQL Connector (JDBC driver)
- Lombok (boilerplate code reduction)

---

## 📁 Project Structure

```plaintext
OnDemand_Backend/
├── src/
│   ├── main/
│   │   ├── java/com/example/ondemand/
│   │   │   ├── controller/              # REST controllers for API endpoints
│   │   │   ├── service/                 # Business logic and service layer
│   │   │   ├── repository/              # Data access layer (JPA repositories)
│   │   │   ├── model/                   # Entity classes for database mapping
│   │   │   └── OnDemandApplication.java # Main application entry point
│   │   └── resources/
│   │       ├── application.properties   # Configuration (e.g., database, server port)
│   │       └── static/                  # Static resources (if any)
│   └── test/                            # Unit and integration tests
├── pom.xml                              # Maven configuration file
└── README.md                            # Project documentation (this file)
```

---

## Prerequisites

- Java: JDK 11 or higher  
- Maven: 3.6.0 or higher  
- MySQL: 8.0 or higher  
- Git: For cloning the repository

---

## Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/medamineharbaoui/OnDemand_Backend.git
cd OnDemand_Backend
```

### 2. Configure the Database

Create a MySQL database (e.g., `ondemand_db`), then update your `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ondemand_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### 3. Build the Project

```bash
mvn clean install
```

### 4. Run the Application

```bash
mvn spring-boot:run
```

The application will start at: [http://localhost:8080](http://localhost:8080)
---

## Development Notes

- **Design Patterns**: Utilizes Factory and Repository patterns for maintainable and modular code.
- **Complexity Management**: Focused on reducing time complexity in API responses through efficient queries.
- **Testing**: Unit and integration tests can be found under `src/test/`. Add more tests as needed for complete coverage.

---

## Author

**Amine Harbaoui**  
