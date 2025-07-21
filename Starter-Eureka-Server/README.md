
# Starter-Eureka-Server

A Spring Boot-based Eureka Server for service discovery in microservices architectures. Easily register and monitor your Spring Cloud clients.

## Features

- Standalone Eureka Server powered by Spring Cloud Netflix  
- Automatic service registration & registry endpoint at `/eureka/apps`  
- Web UI dashboard accessible at `/` (default port **8761**)  

## 📦 Prerequisites

- **Java 17+**  
- **Maven or Gradle**  
- (Optional) Additional Eureka Server instances for peer replication  

## 🚀 Getting Started

### 1. Clone the repo

```bash
git clone https://github.com/dinesh-veer/some-samples-springboot.git
cd some-samples-springboot/Starter-Eureka-Server
````

### 2. Add dependencies

Ensure your `pom.xml` (or `build.gradle`) includes:

```xml
<dependency>
  <groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency>
```

This enables the embedded Eureka Server via Spring Cloud Netflix ([GitHub][1], [about.gitlab.com][2], [Medium][3], [staleks.github.io][4], [cloud.spring.io][5], [Home][6], [Medium][7]).

### 3. Enable Eureka Server

In your Java main class:

```java
@SpringBootApplication
@EnableEurekaServer
public class StarterEurekaServerApplication {
  public static void main(String[] args) {
    SpringApplication.run(StarterEurekaServerApplication.class, args);
  }
}
```

### 4. Configure application properties

In `src/main/resources/application.yml` or `application.properties`:

```yaml
server:
  port: 8761

spring:
  application:
    name: eureka-server

eureka:
  instance:
    hostname: localhost
  client:
    register-with-eureka: false
    fetch-registry: false
    service-url:
      defaultZone: http://localhost:8761/eureka/
```

This sets up standalone mode: the server does not register to itself, but still exposes registry for clients ([cloud.spring.io][5]).

### 5. Build & Run

Using Maven:

```bash
mvn clean package
java -jar target/*.jar
```

Or simply:

```bash
mvn spring-boot:run
```

### 6. Verify

Once running, visit the dashboard:

```text
http://localhost:8761/
```

You should see the Eureka UI and “Applications” table (initially empty).

## 🧩 Adding Peer Awareness (Optional)

To add high availability via peer-aware cluster:

1. Duplicate the application with different profiles (e.g., `peer1`, `peer2`).
2. Configure each to register with the other:

```yaml
eureka:
  client:
    register-with-eureka: true
    fetch-registry: true
    service-url:
      defaultZone: http://peer2:8762/eureka/
```

See \[Spring Cloud docs on peer-awareness]\([Medium][7], [cloud.spring.io][5]).

## 📡 Registering Clients

Microservices can now use Eureka for registration. They should include:

```xml
<dependency>
  <groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```

And add to `application.yml`:

```yaml
spring:
  application:
    name: some-client
server:
  port: 8081

eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/
```

Once started, clients auto-register and appear in Eureka dashboard ([Home][6]).

## 🧪 Useful Commands

```bash
# Run server
mvn spring-boot:run

# Package the app
mvn clean package

# Run test suite
mvn test
```

## 🔍 API Endpoints

* UI Dashboard: `http://localhost:8761/`
* Registry endpoint: `http://localhost:8761/eureka/apps`

## 📘 Resources & References

* \[Spring Cloud Eureka Getting Started Guide]\([Home][6], [paigeniedringhaus.com][8])
* \[Standalone & Peer-aware Configuration]\([Medium][7])

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