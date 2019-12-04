FROM openjdk:11-jre-slim

MAINTAINER Marcus Vieira <marcusvinicius.viera88@gmail.com>

RUN mkdir /app
COPY ./target/phone-checker-0.0.1-SNAPSHOT.jar /app
COPY ./sample.db /app
WORKDIR /app
EXPOSE 8080
CMD ["java", "-jar", "phone-checker-0.0.1-SNAPSHOT.jar"]