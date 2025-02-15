FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .

RUN ./mvnw package

FROM openjdk:17-jdk-slim

EXPOSE 8080

COPY --from=build /target/sb_treasurehunter_mvc-1.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]