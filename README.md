# 🔐 User Service – Compromised Password Checker

This Spring Boot microservice demonstrates how to **block user registration with leaked or compromised passwords** using  
Spring Security’s `CompromisedPasswordChecker`, integrated with **Have I Been Pwned (HIBP)**.


## 📌 Features
- ✅ Prevents registration with compromised passwords  
- ✅ Uses Spring Security’s built-in `CompromisedPasswordChecker`  
- ✅ MySQL persistence layer  
- ✅ Supports both **local DB setup** and **Dockerized DB**  


## ⚙️ Setup Instructions

### 1️⃣ Local Database Setup
- Create a database named **`taskFlowAI`** in your local MySQL.  
- Update the following properties inside `application.properties` with your own **username** and **password**:  

spring.datasource.username=<your-username>
spring.datasource.password=<your-password>

###🚀 **Running the Service**

mvn clean install
mvn spring-boot:run

**Service runs at:**

POST http://localhost:8080/api/v1/users/register

###📬 **Example API Responses**

✅ **Successful Registration**

{
  "id": 1,
  "name": "John Doe",
  "email": "john@example.com",
  "role": "USER"
}


❌ **Failed Registration (Compromised Password)**

{
  "error": "Password security issue",
  "message": "Password has been exposed in data breaches"
}

