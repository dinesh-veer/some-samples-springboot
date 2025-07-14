Absolutely! Below is the **complete copyable `README.md`** file. You can copy this content and paste it directly into your project's root directory as `README.md`.

# Spring Boot Application Properties Demo

This project demonstrates how to use external configuration in a Spring Boot application using `application.yml` and profile-specific settings.
Also adding properties using `@value ` also loading via `configurationProperties`.

## 🧩 Features

- Use of `application.yml` for centralized configuration
- Profile-specific overrides (`dev`, `prod`)
- Dynamically change server port based on the active profile

## 🚀 Getting Started

### Prerequisites

- Java JDK 17+
- Maven 3.6+

### Clone and Run the Project

```bash
git clone https://github.com/dinesh-veer/some-samples-springboot.git
cd some-samples-springboot/SpringBootApplicationPropertiesDemo
````

### Run with Default Profile

```bash
mvn spring-boot:run
```

This will use the base configuration and start the server on port `8081`.

### Run with a Specific Profile

```bash
# Development profile
mvn spring-boot:run -Dspring-boot.run.profiles=dev

# Production profile
mvn spring-boot:run -Dspring-boot.run.profiles=prod
```

Or using the packaged JAR:

```bash
java -jar target/SpringBootApplicationPropertiesDemo-0.0.1-SNAPSHOT.jar \
  --spring.profiles.active=dev
```

## 🛠 Configuration Files

This YAML file contains multiple documents separated by `---`, each defining settings for different profiles.

## 📂 Project Structure
```
SpringBootApplicationPropertiesDemo/
├── 📁 src/
│   ├── 📁 main/
│   │   ├── 📁 java/
│   │   │   └── com/spring/demo/
│   │   │       ├── SpringBootApplicationPropertiesDemoApplication.java      # Main class
│   │   │       ├────
│   │   │       │   └── PropertiesController.java         # REST controller
│   │   │       └────
│   │   │           └── AppConfigProperties.java        # Custom properties binding
│   │   └── 📁 resources/
│   │       ├── application.properties                  # Default configuration
│   │       ├── application-dev.properties              # Dev profile config
│   │       ├── application-prod.properties             # Prod profile config
│   │       └── banner.txt                              # Custom banner (optional)
│
├── 📁 test/
│   └── 📁 java/
│       └── com/sample/demo/
│           └── SpringBootApplicationPropertiesDemoApplicationTests.java     # Unit test
│
├── 📄 pom.xml                                            # Maven build file
├── 📄 .gitignore
└── 📄 README.md
```
Thanks for sharing the exact model! Since your `/loadproperties` endpoint returns an instance of this `AppConfig` class, here’s the updated **Endpoints** section with the accurate JSON response example reflecting your model:

---

## 🚀 Endpoints

### 1. GET `/loadproperties`

Returns the configuration properties mapped to the `AppConfig` model, example response:

```json
{
  "name": "Spring Boot Properties Demo",
  "timeout": 30,
  "javaVersion": 17.0,
  "springBootVersion": "3.0.0"
}
```

* **Note:**
  `timeout` is initialized with a default value (not loaded from properties).

---

### 2. GET `/`

Returns a welcome message:

```json
{
  "message": "Got the message from Properties Default properties."
}
```

---

### Example Usage

```bash
curl http://localhost:8081/loadproperties
curl http://localhost:8081/
```

---

## ⚙️ How to Enable `/env` Endpoint

By default, Actuator endpoints are limited. To expose `/env`, update your `application.properties`:

```properties
management.endpoints.web.exposure.include=env,health,info
```

Make sure Actuator dependency is added in your `pom.xml`:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

---

## 🚀 Accessing `/env` Endpoint

Once enabled, access the endpoint via:

```
GET http://localhost:8080/actuator/env
```

This will return JSON data structured like:

```json
{
  "activeProfiles": [],
  "propertySources": [
    {
      "name": "systemProperties",
      "properties": {
        "java.version": {
          "value": "17"
        },
        "os.name": {
          "value": "Linux"
        }
      }
    },
    {
      "name": "applicationConfig: [classpath:/application.properties]",
      "properties": {
        "server.port": {
          "value": "8080"
        },
        "spring.application.name": {
          "value": "demo-app"
        }
      }
    }
  ]
}
```

---

## 🔐 Securing the `/env` Endpoint

Because `/env` exposes sensitive configuration data, **it is recommended to secure this endpoint** in production:

* Use Spring Security to restrict access
* Enable HTTPS
* Limit exposure using `management.endpoints.web.exposure.include`

Example to restrict access in `application.properties`:

```properties
management.endpoints.web.exposure.include=health,info
```

Then selectively expose `/env` only for trusted environments or users.

---

## 📘 Additional Notes

* You can switch between profiles at runtime using the `--spring.profiles.active` flag.
* Properties like `server.port` can be changed per environment without modifying the codebase.

## 📝 License

[MIT](../LICENSE) © Dinesh Veer

---
## 📬 Contact

For questions, feedback, or collaboration:

**Dinesh Veer**

📧 Email: [dveer123@hotmail.com](mailto:dveer123@hotmail.com)

🔗 GitHub: [@dinesh-veer](https://github.com/dinesh-veer)

---

