# Limit Service

A simple Spring Boot microservice that provides configuration-based limits. This service is typically used as part of a microservices architecture for practicing concepts like Spring Cloud Config, service discovery (Eureka), and API composition.

## Features

- Exposes minimum and maximum limits via a REST endpoint.
- Connects to Eureka Server for service registration and discovery.
- Spring Boot and Spring Cloud ready.

---

## Prerequisites

- Java 17 or above
- Maven
- Git
- Eureka Server running (locally or remotely)

---

## Getting Started

### Clone the repository

```bash
git clone https://github.com/dinesh-veer/some-samples-springboot.git
cd some-samples-springboot/limit-service
````

### Eureka Client Setup

To enable Eureka Client functionality, ensure the following dependency is in `pom.xml`:

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```

In `application.properties`, add Eureka configuration:

```properties
spring.application.name=limit-service

eureka.client.service-url.defaultZone=http://localhost:8761/eureka
eureka.instance.prefer-ip-address=true
```

Make sure Eureka Server is up and running on port `8761` before starting this service.

---

## Build and Run

```bash
mvn spring-boot:run
```

Or

```bash
mvn clean install
java -jar target/limit-service-0.0.1-SNAPSHOT.jar
```

---

## API Endpoint

```http
GET /limit
```

#### Sample Response:

```json
{
  "minimum": 1,
  "maximum": 1000
}
```

---

## Configuration

By default, the limits are configured in `application.properties`:

```properties
limits.minimum=1
limits.maximum=1000
```

This service can also be configured to retrieve its properties from a Spring Cloud Config Server.

---

## Service Discovery with Eureka

Once registered with Eureka, you can access the service using its logical name (`limit-service`) from other microservices. For example:

```http
http://limit-service/limit
http://limit-service/limitConfig
```

This works only when using a service discovery-aware client (like Feign or RestTemplate with Ribbon).

---

## Project Structure

* `LimitConfiguration` – Configuration properties holder.
* `LimitsConfigurationController` – REST controller exposing the limits.
* `application.properties` – Default configuration file.
* Eureka Client configuration is included for service registration.

---

## Useful Commands

```bash
# Run tests
mvn test

# Package the application
mvn clean package

#Run application
mvn spring-boot:run -Dspring-boot.run.arguments="--server.port=8081"
mvn spring-boot:run -Dspring-boot.run.arguments="--server.port=8082"

```
---
## 📄 License

This project is licensed under the [MIT License](../LICENSE).
© Dinesh Veer

---

## 📬 Contact

For questions, feedback, or collaboration:

**Dinesh Veer**

Feel free to raise issues or pull requests!

📧 Email: [dveer123@hotmail.com](mailto:dveer123@hotmail.com)

🔗 GitHub: [@dinesh-veer](https://github.com/dinesh-veer)

---
