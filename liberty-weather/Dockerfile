FROM openjdk:8 as builder

WORKDIR /liberty

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

WORKDIR /liberty

EXPOSE 8080 9090

ENV WLP_JAR_EXTRACT_ROOT=/liberty

ENTRYPOINT ["java", "-server", "-Xshare:auto", "-XX:+UseContainerSupport", "-XX:ThreadStackSize=256", "-XX:MaxMetaspaceSize=128m", "-XX:+UseG1GC", "-XX:MaxGCPauseMillis=250", "-XX:+UseStringDeduplication", "-jar", "liberty-weather.jar"]

COPY --from=builder /liberty/target/liberty-weather.jar ./
