Absolutely! Below is the **complete copyable `README.md`** file. You can copy this content and paste it directly into your project's root directory as `README.md`.

---

````markdown
# Spring Boot Application Properties Demo

This project demonstrates how to use external configuration in a Spring Boot application using `application.yml` and profile-specific settings.

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

This will use the base configuration and start the server on port `8080`.

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
src/
├── main/
│   ├── java/com/example/demo/
│   │   └── DemoApplication.java
│   └── resources/
│       └── application.yml
└── test/
    └── java/...
```

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

