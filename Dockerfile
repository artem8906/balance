FROM eclipse-temurin:17-jdk-jammy
COPY target/operation-0.1.jar /app.jar
CMD ["java", "-jar", "/app.jar"]
