FROM gcr.io/distroless/java:8

WORKDIR /helidon

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "helidon-weather-mp.jar"]

COPY target/libs ./libs
COPY target/helidon-weather-mp.jar ./