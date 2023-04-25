FROM maven:3.6.3-openjdk-8 as maven
WORKDIR /app
COPY . /app
RUN mvn install

FROM openjdk:8-jre-alpine
WORKDIR /app
ADD target/isands_appliance_directory-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT java -jar app.jar
