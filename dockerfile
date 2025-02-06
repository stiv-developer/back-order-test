# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Copy the executable JAR file into the container
COPY target/back-order-test-0.0.1-SNAPSHOT.jar app.jar

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]