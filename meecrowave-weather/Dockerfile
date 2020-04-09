FROM openjdk:8 as builder

WORKDIR /meecrowave

COPY .mvn/ ./.mvn/
COPY mvnw ./
COPY pom.xml ./

RUN ./mvnw package

COPY src/ src/
RUN ./mvnw package meecrowave:bundle

FROM gcr.io/distroless/java:8

WORKDIR /meecrowave

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "meecrowave-weather-1.0.0-fat.jar"]

COPY --from=builder /meecrowave/target/meecrowave-weather-1.0.0-fat.jar ./