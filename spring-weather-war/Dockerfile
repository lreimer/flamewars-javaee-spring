FROM gcr.io/distroless/java:8

WORKDIR /

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "spring-weather-war-1.0.0.war"]

COPY target/spring-weather-war-1.0.0.war /