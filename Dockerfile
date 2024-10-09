
FROM maven:3.8.7-eclipse-temurin-11 AS build

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src

RUN mvn clean package -DskipTests

FROM eclipse-temurin:11-jre-alpine

WORKDIR /app

COPY --from=build /app/target/*.jar ./app.jar

EXPOSE 8081

CMD ["java", "-jar", "app.jar"]