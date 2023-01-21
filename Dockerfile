FROM openjdk:8-jdk-alpine
COPY target/microservice.jar microservice.jar
CMD ["java", "-jar", "microservice.jar"]