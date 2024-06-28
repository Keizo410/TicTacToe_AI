# Use a slim Java base image
FROM openjdk:17-slim

# Set the working directory
WORKDIR /app

# Copy the project files
COPY . .

# Compile the Java source code
RUN javac src/*.java

# Define the main class
ENTRYPOINT ["java", "-cp", "src", "Minimax_Algorithm_Test"]