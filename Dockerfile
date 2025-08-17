# Use OpenJDK 21 as base image
FROM openjdk:21-jdk-slim

# Set working directory
WORKDIR /app

# Copy the jar file from target directory
COPY target/ShopShopDay-0.1.jar /app/ShopShopDay-0.1.jar

# Expose port 9090
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "ShopShopDay-0.1.jar"]