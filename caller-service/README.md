
# Caller Service 🚀

A Spring Boot microservice that demonstrates service-to-service communication using **Eureka Service Discovery**, **Spring WebClient**, and **RestTemplate**.

---

## 🔧 Features

- Registers itself with a Eureka server
- Discovers and invokes the `limit-service` via Eureka
- Supports both **Reactive WebClient** and **Traditional RestTemplate**
- Provides two endpoints: `/getLimit` and `/getLimitConfig`

---

## 🧱 Prerequisites

- Java 17+
- Maven 3.8+
- A running **Eureka Server** (e.g., `http://localhost:8761`)
- A running **Limit Service** registered as `spring.application.name=limit-service` in Eureka

---

## 📦 Project Structure

- `CallerConfig.java` – Configures `@LoadBalanced` WebClient and RestTemplate beans
- `CallerController.java` – Contains `/getLimit` and `/getLimitConfig` endpoints
- `application.yml` – Eureka client and application settings

---

## 🛠️ Setup & Run

1. **Clone this repo**:
    ```bash
    git clone https://github.com/dinesh-veer/some-samples-springboot
    cd some-samples-springboot/caller-service
    ```

2. **Configure** (optional):

    Update Eureka settings in `src/main/resources/application.yml` if necessary:

    ```yaml
    spring:
      application:
        name: caller-service

    eureka:
      client:
        service-url:
          defaultZone: http://localhost:8761/eureka/
    ```

3. **Build**:
    ```bash
    mvn clean package
    ```

4. **Run**:
    ```bash
    java -jar target/caller-service-0.0.1-SNAPSHOT.jar
    ```

---

## 🧪 Usage

- Ensure **Eureka Server** and **Limit Service** are running and registered.
- Access the endpoints:

    ```
    GET http://localhost:8080/getLimit         # Uses RestTemplate
    GET http://localhost:8080/getLimitConfig   # Uses WebClient
    ```

- Both will call `limit-service` and return its response.

---

## ✅ Code Snippets

### CallerConfig.java

```java
@Configuration
public class CallerConfig {

    @Bean
    @LoadBalanced
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
````

### CallerController.java

```java
@RestController
public class CallerController {

    private final WebClient.Builder webClientBuilder;
    private final RestTemplate restTemplate;

    public CallerController(WebClient.Builder webClientBuilder, RestTemplate restTemplate) {
        this.webClientBuilder = webClientBuilder;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/getLimitConfig")
    public Mono<String> getLimit() {
        return webClientBuilder.build()
                .get()
                .uri("http://limit-service/limits")
                .retrieve()
                .bodyToMono(String.class);
    }

    @GetMapping("/getLimit")
    public String getLimitConfig() {
        return restTemplate.getForObject("http://limit-service/limits", String.class);
    }
}
```

---

## 🧭 Endpoints

| Endpoint          | Method | Description                               |
| ----------------- | ------ |-------------------------------------------|
| `/getLimit`       | GET    | Calls `limit-service` using RestTemplate  |
| `/getLimitConfig` | GET    | Calls `limit-service` using  WebClient    |

---

## 📘 Learn More

* [Spring Cloud Netflix Eureka](https://spring.io/projects/spring-cloud-netflix)
* [Spring WebClient](https://docs.spring.io/spring-framework/docs/current/reference/html/web-reactive.html#webflux-client)
* [Spring Cloud LoadBalancer](https://docs.spring.io/spring-cloud-commons/docs/current/reference/html/#spring-cloud-loadbalancer)

---

## 🤝 Contributions

Open issues or submit PRs to improve this sample project.

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