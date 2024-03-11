FROM maven:3.9.6 AS build
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src src

RUN mvn package -DskipTests

FROM openjdk:21
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]
