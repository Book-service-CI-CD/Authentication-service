FROM openjdk:21-oracle
COPY ./target/Authentication-service-0.0.1-SNAPSHOT.jar Authentication-service.jar
CMD ["java", "-jar", "Authentication-service.jar"]