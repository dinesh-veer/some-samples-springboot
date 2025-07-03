

# Spring Boot WAR Deployment Examples

This repository contains two Spring Boot projects demonstrating how to package and run Spring Boot applications as WAR files using two different approaches:

1. `war-with-initializer`: Deployable to external servlet containers like Tomcat, WildFly, or Jetty.
2. `war-without-initializer`: Self-executable WAR (runs with `java -jar`) using embedded Tomcat.

---

## 📁 Projects Overview

### ✅ 1. war-with-initializer

A Spring Boot project configured to produce a WAR file suitable for **external servlet containers**.

- Uses `SpringBootServletInitializer`
- Sets `spring-boot-starter-tomcat` as `provided`
- Not self-executable — deploy via servlet container (e.g., `webapps/` in Tomcat)

**Main Class:**
```java
@SpringBootApplication
public class SpringBootDemoWarApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DemoApplication.class);
    }
}
````

**Run:**

```bash
mvn clean package
# Deploy `target/war-with-initializer-0.0.1-SNAPSHOT.war` to Tomcat's /webapps
```

---

### ✅ 2. war-without-initializer

A Spring Boot project that creates a **self-executable WAR** using embedded Tomcat.

* Does **not** use `SpringBootServletInitializer`
* Keeps embedded Tomcat in default scope
* Can be run using `java -jar` directly

**Main Class:**

```java
@SpringBootApplication
public class SpringBootDemoWarApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
```

**Run:**

```bash
mvn clean package
java -jar target/war-without-initializer-0.0.1-SNAPSHOT.war
```

---

## ⚙️ Project Structure

Each project follows this structure:

```
project-name/
├── pom.xml
└── src/
    ├── main/
    │   ├── java/com/spring/demo/SpringBootDemoWarApplication.java
    │   └── resources/application.properties
```

---

## 📝 Notes

* Both projects use `server.port=8080` by default.
* Only the `war-with-initializer` project is deployable in external containers.
* Only the `war-without-initializer` is self-executable using `java -jar`.

---

## 📦 Build with Maven

Run the following in either project directory:

```bash
mvn clean package
```

---

## 📃 License

[MIT](../LICENSE) © Dinesh Veer


---

## 📬 Contact

For questions, feedback, or collaboration:

**Dinesh Veer**

📧 Email: [dveer123@hotmail.com](mailto:dveer123@hotmail.com)

🔗 GitHub: [@dinesh-veer](https://github.com/dinesh-veer)

---