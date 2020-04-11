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

EXPOSE 8080 9090

ENTRYPOINT ["java","-XX:+UseContainerSupport", "-XX:MaxRAMPercentage=75.0", "-XX:ThreadStackSize=256", "-XX:MaxMetaspaceSize=128m", "-XX:+UseG1GC", "-XX:MaxGCPauseMillis=250", "-XX:+UseStringDeduplication", "-Dcom.sun.management.jmxremote", "-Dcom.sun.management.jmxremote.port=9090", "-Djava.rmi.server.hostname=localhost", "-Dcom.sun.management.jmxremote.rmi.port=9090", "-Dcom.sun.management.jmxremote.ssl=false", "-Dcom.sun.management.jmxremote.authenticate=false", "-jar", "spring-weather-jar-1.0.0.jar"]
# CMD ["./spring-weather-jar-1.0.0.jar"]

COPY --from=builder /spring/target/spring-weather-jar-1.0.0.jar ./