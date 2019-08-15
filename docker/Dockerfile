# Import java base image (using maven to build project)
FROM maven:3.6.1-jdk-11-slim

# Copy project files
COPY pom.xml /app/pom.xml
COPY src /app/src
WORKDIR /app

# Build project
RUN mvn compiler:compile -f "/app/pom.xml"

# Be sure to change the main class name if you use your own files!
RUN mvn -e exec:java -Dexec.mainClass="com.ibm.DockerTest"