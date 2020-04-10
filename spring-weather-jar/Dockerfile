FROM openjdk:8 as builder

WORKDIR /spring

COPY .mvn/ ./.mvn/
COPY mvnw ./
COPY pom.xml ./

RUN ./mvnw dependency:resolve dependency:resolve-plugins

COPY src/ src/
RUN ./mvnw package -DskipTests

FROM gcr.io/distroless/java:8

WORKDIR /spring

EXPOSE 8080

# ENTRYPOINT ["java", "-jar", "spring-weather-jar-1.0.0.jar"]
CMD ["./spring-weather-jar-1.0.0.jar"]

COPY --from=builder /spring/target/spring-weather-jar-1.0.0.jar ./