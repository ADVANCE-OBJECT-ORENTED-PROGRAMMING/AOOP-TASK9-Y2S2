# Use Java 17 base image
FROM openjdk:17

# Copy all project files into the container
COPY . /app
WORKDIR /app

# Compile all Java files
RUN javac *.java

# Expose the application port
EXPOSE 8080

# Run the main class
CMD ["java", "Main"]
