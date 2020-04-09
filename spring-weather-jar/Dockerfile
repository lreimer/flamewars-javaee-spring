FROM gcr.io/distroless/java:8

WORKDIR /

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "spring-weather-jar-1.0.0.jar"]

COPY target/spring-weather-jar-1.0.0.jar /