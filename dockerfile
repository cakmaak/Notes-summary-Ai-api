FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Lokalde build ettiğin jar dosyasını container'a kopyala
COPY target/ainoteapi-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
