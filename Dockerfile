# Use OpenJDK 21 as base image
FROM openjdk:21-jdk-slim

# Set working directory
WORKDIR /app

# Copy the jar file from target directory
COPY target/*.jar app.jar

# Expose port 9090
EXPOSE 9090

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]