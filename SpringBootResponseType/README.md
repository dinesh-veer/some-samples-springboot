
# SpringBootResponseType – JSON/XML Response Type Base in Spring Boot

This project demonstrates how a Spring Boot application can respond with JSON or XML depending on the client's `Accept` header, with separate controllers for Student and Employee entities.

---

## ✨ Features

- ✔️ Spring Boot base project with JSON and XML support  
- 🔁 Content negotiation to respond with JSON or XML automatically  
- 🚀 Separate REST controllers for Student and Employee  
- 🧩 Simple POJO models for domain entities  

---

## 📁 Project Structure

```

SpringBootResponseType/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/example/springbootresponsetype/
│       │       ├── SpringBootResponseTypeApplication.java                 # Main Spring Boot application class
│       │       │
│       │       ├── controller/
│       │       │   ├── SpringBootResponseTypeApplication.java           # REST controller for Student ane employee endpoints
│       │       │   
│       │       │
│       │       └── model/
│       │           ├── Student.java                      # Student POJO model
│       │           └── Employee.java                     # Employee POJO model
│       │
│       └── resources/
│           └── application.properties                    # Spring Boot configuration file
│
└── pom.xml                                               # Maven dependencies including JSON & XML support

````

---

## 🛠 Dependencies (pom.xml)

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<dependency>
  <groupId>com.fasterxml.jackson.dataformat</groupId>
  <artifactId>jackson-dataformat-xml</artifactId>
</dependency>
````

> Jackson handles both JSON and XML serialization. No additional JAXB dependencies are required.

---

## 🚀 Running the Application

1. Clone the repository:

   ```bash
   git clone https://github.com/dinesh-veer/some-samples-springboot.git
   cd some-samples-springboot/SpringBootResponseType
   ```

2. Run the app:

   ```bash
   mvn spring-boot:run
   ```

3. Access the endpoints exposed by the `SharedController`.
   The response format (JSON or XML) will depend on the `Accept` header sent by the client.

---

## 🧪 Example Requests

```bash
curl http://localhost:8080/student -H "Accept: application/json"
curl http://localhost:8080/student/all -H "Accept: application/json"

curl http://localhost:8080/employee -H "Accept: application/xml"
curl http://localhost:8080/employee/all -H "Accept: application/xml"

```

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