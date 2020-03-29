FROM openjdk:8-jdk-alpine
MAINTAINER Ankita Kumari
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} aggregator_service.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/aggregator_service.jar"]