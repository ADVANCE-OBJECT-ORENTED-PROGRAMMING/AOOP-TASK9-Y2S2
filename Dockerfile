# Base image with Java 17
FROM openjdk:17

# Copy source folder into container
COPY src /app
WORKDIR /app

# Compile all Java files
RUN javac *.java

# Expose application port
EXPOSE 8080

# Run the main class
CMD ["java", "Main"]

