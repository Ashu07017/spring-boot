# 🔐 RBAC System using Spring Boot

Note: Images attached in "main"

## 📌 Overview

This project implements a **Role-Based Access Control (RBAC)** system using **Spring Boot**.
It demonstrates authentication and authorization using **Spring Security**, with users stored in an **H2 in-memory database**.

---

## 🚀 Features

* 🔑 Basic Authentication (Spring Security)
* 👥 Role-Based Access Control (USER / ADMIN)
* 🗄️ H2 Database (in-memory)
* 🔄 REST APIs for public, user, and admin access
* 📡 Tested using Postman
* 🎨 Simple frontend UI (Single Page Application)

---

## 🏗️ Tech Stack

* Java 17
* Spring Boot
* Spring Security
* Spring Data JPA
* H2 Database
* Maven

---

## 📂 Project Structure

```
src/
 └── main/
     ├── java/com/example/experiment7/
     │    ├── config        # Security configuration
     │    ├── controller    # REST controllers
     │    ├── entity        # User entity
     │    ├── repository    # JPA repository
     │    ├── service       # UserDetailsService
     │    └── Experiment7Application.java
     └── resources/
          ├── static        # Frontend (index.html)
          ├── application.properties
          └── data.sql      # Initial users
```

---

## 🧑‍💻 Default Users

| Username | Password | Role  |
| -------- | -------- | ----- |
| Ashok    | 123456   | ADMIN |
| Pritam   | 123456   | USER  |
| Santy    | 123456   | USER  |

---

## 🔗 API Endpoints

### 🌐 Public

```
GET /api/public/hello
```

✔ No authentication required

---

### 👤 User

```
GET /api/user/profile
```

✔ Accessible by USER and ADMIN

---

### 🔐 Admin

```
GET /api/admin/dashboard
GET /api/admin/users
```

✔ Accessible only by ADMIN

---

## 🔐 Authentication

* Type: **Basic Auth**
* Managed via Spring Security
* Custom `UserDetailsService` fetches users from database

---

## 🧪 Testing with Postman

### ✅ Public API

```
GET http://localhost:8080/api/public/hello
```

➡️ 200 OK

---

### ✅ User Access

```
GET http://localhost:8080/api/user/profile
Auth: Pritam / 123456
```

➡️ 200 OK

---

### ❌ User accessing Admin

```
GET http://localhost:8080/api/admin/dashboard
Auth: Pritam / 123456
```

➡️ 403 Forbidden

---

### ✅ Admin Access

```
GET http://localhost:8080/api/admin/users
Auth: Ashok / 123456
```

➡️ 200 OK

---

### ❌ No Authentication

```
GET http://localhost:8080/api/user/profile
```

➡️ 401 Unauthorized

---

## 🗄️ H2 Database

Access H2 console:

```
http://localhost:8080/h2-console
```

Open in browser:

```
http://localhost:8080/index.html
```

---

## 🧠 Concepts Demonstrated

* Authentication vs Authorization
* Role-Based Access Control (RBAC)
* Spring Security configuration
* REST API design
* HTTP Status Codes (200, 401, 403)

---

## 📸 Screenshots

Images are uploaded in Github

---

## 👨‍💻 Author

Ashok Chaturvedi
