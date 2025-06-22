# Fase de build
FROM maven:3.9.5-eclipse-temurin-17 AS build
WORKDIR /build
COPY . .
RUN mvn package -DskipTests

# Fase de execução
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /build/target/*-runner.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
