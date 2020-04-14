FROM openjdk:8 as builder

WORKDIR /quarkus

COPY .mvn/ ./.mvn/
COPY mvnw ./
COPY pom.xml ./

RUN ./mvnw dependency:resolve dependency:resolve-plugins

COPY src/ src/
RUN ./mvnw clean package -DskipTests

FROM gcr.io/distroless/java:8

RUN ["java", "-Xshare:dump"]

COPY --from=amd64/busybox:1.31.1 /bin/busybox /busybox/busybox
RUN ["/busybox/busybox", "--install", "/bin"]

WORKDIR /quarkus

EXPOSE 8080 9090

ENTRYPOINT ["java", "-server", "-Xshare:auto", "-XX:+UseContainerSupport", "-XX:MaxRAMPercentage=75.0", "-XX:ThreadStackSize=256", "-XX:MaxMetaspaceSize=128m", "-XX:+UseG1GC", "-XX:MaxGCPauseMillis=250", "-XX:+UseStringDeduplication", "-Djava.security.egd=file:/dev/./urandom", "-Djava.util.logging.manager=org.jboss.logmanager.LogManager", "-Djava.net.preferIPv4Stack=true", "-Dcom.sun.management.jmxremote", "-Dcom.sun.management.jmxremote.port=9090", "-Djava.rmi.server.hostname=localhost", "-Dcom.sun.management.jmxremote.rmi.port=9090", "-Dcom.sun.management.jmxremote.ssl=false", "-Dcom.sun.management.jmxremote.authenticate=false", "-jar", "quarkus-weather-runner.jar"]

COPY --from=builder /quarkus/target/quarkus-weather-runner.jar ./
COPY --from=builder /quarkus/target/lib/ ./lib/
