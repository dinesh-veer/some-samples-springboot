
# 🚦 RateLimiterSpringBoot

This project demonstrates how to implement a **custom pluggable rate limiter** in a Spring Boot application. It showcases how to build reusable rate-limiting logic that can be extended with different algorithms and integrated seamlessly with Spring’s request handling.

---

## 📌 Features

* Custom rate-limiting interceptor
* Pluggable strategy pattern for different algorithms
* Token Bucket and Fixed Window implementations
* Simple configuration via `web configuration` or  `application.properties`
* Logs request flow and limit breaches
* Easy integration into existing controllers

---

## 🧰 Technologies Used

* Java 17+
* Spring Boot 3.x
* Spring Web

---

## 🏁 Getting Started

### Prerequisites

* Java 17+
* Maven

### Steps

1. Clone the repository:

   ```bash
   git clone https://github.com/dinesh-veer/some-samples-springboot.git
   cd some-samples-springboot/RateLimiterSpringBoot
   ```

2. Build the project:

   ```bash
   mvn clean install
   ```

3. Run the application:

   ```bash
   mvn spring-boot:run
   ```

The service will be available at `http://localhost:8080`.

---
Sure! Here's the **updated README section** that includes both **YAML/property-based configuration** and **Java class-based configuration** as an alternative.

---

## ⚙️ Configuration Options

### 🔹 Option 1: Using `application.properties` or `application.yml`

```properties
# application.properties
ratelimiter.algorithm=token-bucket
ratelimiter.tokenBucket.capacity=10
ratelimiter.tokenBucket.refillRate=5
```

---

### 🔹 Option 2: Java-Based Configuration

Instead of external config files, you can configure rate limiter parameters directly in Java classes using `@Configuration`:

```java
@Configuration
public class RateLimiterConfig {

    @Bean
    public RateLimiterProperties rateLimiterProperties() {
        RateLimiterProperties props = new RateLimiterProperties();
        props.setAlgorithm("token-bucket");

        TokenBucketProperties tokenProps = new TokenBucketProperties();
        tokenProps.setCapacity(10);
        tokenProps.setRefillRate(5);

        props.setTokenBucket(tokenProps);
        return props;
    }
}
```

Ensure the `RateLimiterProperties` and nested `TokenBucketProperties` classes are standard POJOs with setters/getters. Inject them into your strategy/limiter service as needed.

---

Would you like me to include a full example of these Java config classes in your codebase?


---

## 📂 Project Structure

```
├── config/                    # Configuration classes
├── controller/                # Sample REST endpoints
├── interceptor/               # Rate-limiting interceptor
├── service/                   # Rate limiter logic (TokenBucket, FixedWindow)
├── RateLimiterSpringBootApp   # Main application class
```

---

## 🧪 Usage

Try hitting endpoints like:

```
GET /api/data
```

After the limit is exceeded, the server will return a `429 Too Many Requests` response.

---


## 📄 License

This project is licensed under the [MIT License](../LICENSE).
© Dinesh Veer

---

## 📬 Contact

For questions, feedback, or collaboration:

**Dinesh Veer**

📧 Email: [dveer123@hotmail.com](mailto:dveer123@hotmail.com)

🔗 GitHub: [@dinesh-veer](https://github.com/dinesh-veer)

---