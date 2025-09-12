Note Summary AI API

Bu proje, kullanıcıların notlarını kaydedip özetlemesine yardımcı olan bir Spring Boot + JWT Authentication tabanlı backend API’sidir.
Swagger UI üzerinden tüm endpointler test edilebilir.

🚀 Live Swagger UI

🔗 Swagger UI (Production - Railway)

📦 Kurulum ve Çalıştırma (Türkçe)
Gereksinimler

Java 17+

Maven

PostgreSQL

Git

Çalıştırma Adımları

Repoyu klonlayın:

git clone https://github.com/cakmaak/Note-summary-Ai-api.git
cd Note-summary-Ai-api


application.properties dosyasında PostgreSQL bilgilerinizi girin:

spring.datasource.url=jdbc:postgresql://localhost:5432/notedb
spring.datasource.username=postgres
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update


Projeyi build edin ve çalıştırın:

mvn clean install
mvn spring-boot:run


Swagger UI’a erişin:

http://localhost:8080/swagger-ui.html

📦 Setup & Run (English)
Requirements

Java 17+

Maven

PostgreSQL

Git

Steps

Clone the repository:

git clone https://github.com/cakmaak/Note-summary-Ai-api.git
cd Note-summary-Ai-api


Configure your PostgreSQL connection in application.properties:

spring.datasource.url=jdbc:postgresql://localhost:5432/notedb
spring.datasource.username=postgres
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update


Build & run the project:

mvn clean install
mvn spring-boot:run


Access Swagger UI:

http://localhost:8080/swagger-ui.html

🔑 Authentication (JWT)

POST /ainoteapi/signup → Yeni kullanıcı oluşturur

POST /ainoteapi/login → JWT token döner

Tüm korunan endpointlere erişmek için Authorization: Bearer <token> header’ı eklenmelidir.

🌍 Deployment

Railway üzerinde otomatik olarak deploy edilir.

Production URL:

https://remarkable-truth-production.up.railway.app


Production Swagger:

https://remarkable-truth-production.up.railway.app/swagger-ui.html

📚 Kullanılan Teknolojiler | Technologies Used

Java 17

Spring Boot

Spring Security (JWT)

PostgreSQL

Swagger (springdoc-openapi)

Railway (Deployment)
