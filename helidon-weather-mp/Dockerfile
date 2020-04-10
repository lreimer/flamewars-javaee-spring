FROM openjdk:8 as builder

WORKDIR /helidon

COPY .mvn/ ./.mvn/
COPY mvnw ./
COPY pom.xml ./

RUN ./mvnw package

COPY src/ src/
RUN ./mvnw package -DskipTests

FROM gcr.io/distroless/java:8

WORKDIR /helidon

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "helidon-weather-mp.jar"]

COPY --from=builder /helidon/target/libs ./libs
COPY --from=builder /helidon/target/helidon-weather-mp.jar ./