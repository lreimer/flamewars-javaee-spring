FROM openjdk:8 as builder

WORKDIR /payara

COPY .mvn/ ./.mvn/
COPY mvnw ./
COPY pom.xml ./

RUN ./mvnw dependency:resolve dependency:resolve-plugins

COPY src/ src/
RUN ./mvnw package -DskipTests

FROM gcr.io/distroless/java:8

RUN ["java", "-Xshare:dump"]

COPY --from=amd64/busybox:1.31.1 /bin/busybox /busybox/busybox
RUN ["/busybox/busybox", "--install", "/bin"]

WORKDIR /payara

EXPOSE 8080 9090

ENTRYPOINT ["java", "-server", "-Xshare:auto", "-XX:+UseContainerSupport", "-XX:MaxRAMPercentage=60.0", "-XX:ThreadStackSize=256", "-XX:MaxMetaspaceSize=128m", "-XX:+UseG1GC", "-XX:MaxGCPauseMillis=250", "-XX:+UseStringDeduplication", "-Djava.security.egd=file:/dev/./urandom", "-Dcom.sun.management.jmxremote", "-Dcom.sun.management.jmxremote.port=9090", "-Djava.rmi.server.hostname=localhost", "-Dcom.sun.management.jmxremote.rmi.port=9090", "-Dcom.sun.management.jmxremote.ssl=false", "-Dcom.sun.management.jmxremote.authenticate=false", "-jar", "payara-weather-jar-microbundle.jar"]
CMD ["--nocluster", "--disablephonehome"]

COPY --from=builder /payara/target/payara-weather-jar-microbundle.jar ./

# RUN ["java", "-jar", "payara-weather-jar-microbundle.jar", "--rootdir", "micro-root", "--warmup"]
