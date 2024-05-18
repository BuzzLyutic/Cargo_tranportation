FROM openjdk:17-jdk-alpine

WORKDIR /usr/src/app

COPY /build/libs/Cargo_tranportation-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar", "app.jar"]