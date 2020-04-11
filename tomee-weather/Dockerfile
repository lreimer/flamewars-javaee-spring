FROM openjdk:8 as builder

WORKDIR /tomee

COPY .mvn/ ./.mvn/
COPY mvnw ./
COPY pom.xml ./

RUN ./mvnw dependency:resolve dependency:resolve-plugins

COPY src/ src/
RUN ./mvnw package -DskipTests

# FROM gcr.io/distroless/java:8
FROM openjdk:8

WORKDIR /tomee

EXPOSE 8080 8005 8009 9090

ENTRYPOINT ["java","-XX:+UseContainerSupport", "-XX:MaxRAMPercentage=75.0", "-XX:ThreadStackSize=256", "-XX:MaxMetaspaceSize=128m", "-XX:+UseG1GC", "-XX:MaxGCPauseMillis=250", "-XX:+UseStringDeduplication", "-Dcom.sun.management.jmxremote", "-Dcom.sun.management.jmxremote.port=9090", "-Djava.rmi.server.hostname=localhost", "-Dcom.sun.management.jmxremote.rmi.port=9090", "-Dcom.sun.management.jmxremote.ssl=false", "-Dcom.sun.management.jmxremote.authenticate=false", "-jar", "/tomee/tomee-weather-exec.jar"]

COPY --from=builder /tomee/target/tomee-weather-exec.jar ./

# FROM tomee:8-jre-8.0.1-microprofile
# COPY --from=builder /tomee/target/apache-tomee/webapps/ROOT.war /usr/local/tomee/webapps/
