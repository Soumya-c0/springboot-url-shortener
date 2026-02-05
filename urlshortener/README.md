# Spring Boot URL Shortener

A production-style URL shortening backend built using Spring Boot.  
The system converts long URLs into short, shareable links and redirects users using stored mappings.

---

## Features

- Generate short URLs
- Redirect to original URLs
- Input validation
- Global exception handling
- H2 database integration
- Swagger API documentation
- Layered architecture design

---

## Tech Stack

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Lombok
- Swagger 

---

## How To Run
```bash
.\mvnw.cmd spring-boot:run
```

---

## API Endpoints
-Shorten URL: POST /api/shorten
Request Body:
{
"url": "https://www.google.com"
}
-Redirect: GET /{shortCode}

---

## Database Console
http://localhost:8080/h2-console

-JDBC URL: jdbc:h2:mem:urlshortenerdb

---

## Swagger Documentation
http://localhost:8080/swagger-ui/index.html

---

## Learning Highlights

-Implemented layered backend architecture
-Designed REST APIs with validation
-Used JPA ORM for persistence
-Implemented HTTP redirect handling
-Added Swagger API documentation

---

## Future Improvements

-Click analytics tracking
-URL expiration support
-Persistent database (PostgreSQL/MySQL)
-User authentication
-Redis caching
-Docker deployment
