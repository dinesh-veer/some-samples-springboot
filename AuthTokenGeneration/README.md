
# AuthTokenGeneration

This is a minimal Spring Boot application demonstrating token-based authentication using Java JWT (JJWT). It provides a simple mechanism to issue a token on login and validate it on subsequent secured requests. The application also includes a basic HTML UI.

## Overview

This project covers:

* JWT-based login and authentication
* Secured endpoint to fetch user-specific data
* Basic in-memory user storage (hardcoded credentials)
* Simple HTML interface (`index.html`) for testing login and token access

---

## Endpoints

### 1. `POST /api/login`

Generates a JWT token if the provided username and password are valid.

**Request Body:**

```json
{
  "username": "admin",
  "password": "password"
}
```

**Response:**

```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```

### 2. `GET /api/data`

Requires a valid JWT token in the `Authorization` header.

**Request Header:**

```
Authorization: Bearer <your_token>
```

**Response:**

```json
{
  "user": "admin",
  "message": "Data retrieved successfully"
}
```

---

## Frontend (`index.html`)

A simple web page (`index.html`) is included in the `static` folder to:

* Enter login credentials
* View the token response
* Call the `/api/data` endpoint using the retrieved token

To access the UI, visit:

```
http://localhost:8080/
```

---

## How to Run

### Prerequisites

* Java 17+
* Maven 3.6+

### Steps

```bash
git clone https://github.com/dinesh-veer/some-samples-springboot.git
cd some-samples-springboot/AuthTokenGeneration
mvn clean install
mvn spring-boot:run
```

The app starts on `http://localhost:8080`.

---

## Configuration

There are **no external properties** or database connections. All logic, secrets, and user credentials are hardcoded for demonstration purposes only.

Default credentials:

* **Username:** `admin`
* **Password:** `password`

---

## Tech Stack

* Spring Boot
* Java JWT (JJWT)
* HTML/CSS/Bootstrap/JS (static page)

---

