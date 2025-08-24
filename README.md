# 🔐 User Service – Compromised Password Checker

This Spring Boot microservice demonstrates how to **block user registration with leaked or compromised passwords** using  
Spring Security’s `CompromisedPasswordChecker`, integrated with **Have I Been Pwned (HIBP)**.


## 📌 Features
- ✅ Prevents registration with compromised passwords  
- ✅ Uses Spring Security’s built-in `CompromisedPasswordChecker`  
- ✅ MySQL persistence layer  
- ✅ Supports both **local DB setup** and **Dockerized DB**  


⚙️ Setup Instructions
1. Clone the Repository
bash
git clone https://github.com/your-username/user-service.git
cd user-service
2. Local MySQL Database Setup
Create a database named:

sql
CREATE DATABASE taskFlowAI;
Update your application.properties with your actual DB credentials:

text
spring.datasource.url=jdbc:mysql://localhost:3306/taskFlowAI
spring.datasource.username=<your-username>
spring.datasource.password=<your-password>
3. Running the Service
bash
mvn clean install
mvn spring-boot:run
📌 Service will start at:

text
http://localhost:8080
📡 API Endpoints
Register a User
POST http://localhost:8080/api/v1/users/register

✅ Success Response
json
{
  "id": 1,
  "name": "John Doe",
  "email": "john@example.com",
  "role": "USER"
}
❌ Failed Response (Compromised Password)
json
{
  "error": "Password security issue",
  "message": "Password has been exposed in data breaches"
}
