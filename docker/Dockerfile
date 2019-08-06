#Import java base image (using maven to build project)
FROM maven:3.6.1-jdk-11-slim

#Create new maven project
RUN mvn -B archetype:generate \
  -DarchetypeGroupId=org.apache.maven.archetypes \
  -DgroupId=app \
  -DartifactId=java-sdk-docker-app

#Change to maven project directory
WORKDIR /java-sdk-docker-app

#Copy pom.xml file into project to set build dependencies.
COPY pom.xml .

#Builds maven project, installing the sdk.
RUN mvn compile
