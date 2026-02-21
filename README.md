# 🔗 REST Assured Training — API Testing with Java

A structured, **day-by-day training course** for mastering **REST Assured** — the leading Java library for testing RESTful APIs. Covers HTTP methods, response parsing, authentication, schema validation, and full CRUD operations.

---

## 📖 Overview

This repository contains hands-on Java code examples organized by training days, covering everything from basic HTTP requests to advanced topics like JSON/XML schema validation, serialization/deserialization, and user CRUD operations with REST Assured.

---

## 📚 Topics Covered

| Day | Topics | Key Classes |
|-----|--------|-------------|
| **Day 1** | HTTP Requests (GET, POST, PUT, DELETE), Different ways to create POST body | `HTTPRequests`, `DiffWaysToCreatePostRequestBody` |
| **Day 3** | Headers, Cookies, Logging, Path & Query Parameters | `HeadersDemo`, `CookiesDemo`, `LoggingDemo`, `PathAndQueryParameters` |
| **Day 4** | Parsing JSON Response Data | `ParsingJSONResponseData` |
| **Day 6** | JSON Schema Validation, XML Schema Validation, Serialization & Deserialization | `JSONSchemaValidation`, `XMLSchemaValidation`, `SerilizationDeserilization` |
| **Day 7** | Authentication Methods, Fake Library Generator | `Authentications`, `FakeLibraryGenerator` |
| **Day 8** | Full CRUD Operations — Create, Read, Update, Delete User | `CreateUser`, `GetUser`, `UpdateUser`, `DeleteUser` |

---

## 📂 Project Structure

```
RestAssuredTraining/
├── pom.xml                             # Maven build with REST Assured dependencies
├── src/
│   └── test/java/
│       ├── day1/                       # HTTP methods & POST body creation
│       ├── day3/                       # Headers, cookies, logging, params
│       ├── day4/                       # JSON response parsing
│       ├── day6/                       # Schema validation & serialization
│       ├── day7/                       # Authentication & data generation
│       └── day8/                       # Full CRUD operations
└── test-output/                        # TestNG execution reports
```

---

## 🛠️ Tech Stack

| Technology | Purpose |
|-----------|---------|
| **Java** | Programming language |
| **REST Assured** | API testing library |
| **TestNG** | Test runner & assertions |
| **Maven** | Build & dependency management |
| **JSON Schema Validator** | Response schema validation |

---

## 🚀 Getting Started

### Prerequisites
- Java JDK 11+
- Maven 3.x
- Any IDE (IntelliJ IDEA / Eclipse)

### Installation
```bash
git clone https://github.com/Shubham00117/RestAssuredTraining.git
cd RestAssuredTraining
mvn clean install
```

### Running Tests
```bash
# Run all tests
mvn test

# Run specific day's tests
mvn test -Dtest=day1.HTTPRequests
```

---

## 📜 License

This project is open source and available for educational purposes.
