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

# ENTRYPOINT ["java", "-jar", "spring-weather-war-1.0.0.war"]
CMD ["./spring-weather-war-1.0.0.war"]

COPY --from=builder /spring/target/spring-weather-war-1.0.0.war ./