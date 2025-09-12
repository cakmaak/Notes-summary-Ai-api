# 📝 Note Summary AI API – Backend Candidate Assignment

Bu proje, **Spring Boot + JWT Authentication** kullanarak basit bir REST API sağlar.  
Kullanıcılar not ekleyebilir, notları AI ile özetletebilir ve durumunu takip edebilir.  
Deployment Railway üzerinde yapılmıştır.

This project provides a simple REST API using **Spring Boot + JWT Authentication**.  
Users can add notes, summarize them with AI, and track the status.  
The project is deployed on Railway.

---

## 🌐 Canlı Swagger UI | Live Swagger UI

🔗 [Production Swagger UI](https://remarkable-truth-production.up.railway.app/swagger-ui.html)

---

## 🚀 Kurulum ve Çalıştırma (Türkçe)

### Gereksinimler
- Java 17+
- Maven
- PostgreSQL
- Git

### Adımlar
1. Repoyu klonlayın:
   ```bash
   git clone https://github.com/cakmaak/Note-summary-Ai-api.git
   cd Note-summary-Ai-api
PostgreSQL bilgilerinizi application.properties veya .env dosyasına ekleyin:

properties
Kodu kopyala
spring.datasource.url=jdbc:postgresql://localhost:5432/notedb
spring.datasource.username=postgres
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
Projeyi build edin ve çalıştırın:

bash
Kodu kopyala
mvn clean install
mvn spring-boot:run
Swagger UI üzerinden API’yi test edin:

bash
Kodu kopyala
http://localhost:8080/swagger-ui.html
Production linki:

arduino
Kodu kopyala
https://remarkable-truth-production.up.railway.app/swagger-ui.html
🚀 Setup & Run (English)
Requirements
Java 17+

Maven

PostgreSQL

Git

Steps
Clone the repository:

bash
Kodu kopyala
git clone https://github.com/cakmaak/Note-summary-Ai-api.git
cd Note-summary-Ai-api
Configure PostgreSQL in application.properties or .env:

properties
Kodu kopyala
spring.datasource.url=jdbc:postgresql://localhost:5432/notedb
spring.datasource.username=postgres
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
Build & run the project:

bash
Kodu kopyala
mvn clean install
mvn spring-boot:run
Test the API via Swagger UI:

bash
Kodu kopyala
http://localhost:8080/swagger-ui.html
Production link:

arduino
Kodu kopyala
https://remarkable-truth-production.up.railway.app/swagger-ui.html
🔑 Authentication (JWT)
POST /ainoteapi/signup → Yeni kullanıcı oluşturur / Create a new user

POST /ainoteapi/login → JWT token döner / Returns JWT token

Korumalı endpointler için Authorization: Bearer <token> header’ı gerekir.

📝 Core Features
Users – ADMIN ve AGENT rollerine sahip.

Notes – Not ekleme, durum takibi (queued|processing|done|failed), AI özetleme.

Asenkron “AI summarize” job (stub veya rule-based).

Swagger üzerinden tüm endpointler test edilebilir.

Users – with roles ADMIN and AGENT.

Notes – create notes, track status (queued|processing|done|failed), summarize with AI.

Async “AI summarize” job (stub or rule-based).

All endpoints testable via Swagger UI.

🌍 Deployment
Railway üzerinde otomatik olarak deploy edilmiştir.

Production URL:

arduino
Kodu kopyala
https://remarkable-truth-production.up.railway.app
Production Swagger:

arduino
Kodu kopyala
https://remarkable-truth-production.up.railway.app/swagger-ui.html
Automatically deployed on Railway.

Production URL:

arduino
Kodu kopyala
https://remarkable-truth-production.up.railway.app
Swagger UI:

arduino
Kodu kopyala
https://remarkable-truth-production.up.railway.app/swagger-ui.html
🛠 Kullanılan Teknolojiler | Technologies Used
Java 17

Spring Boot

Spring Security (JWT)

PostgreSQL

Swagger (springdoc-openapi)

Railway (Deployment)

