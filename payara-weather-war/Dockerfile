FROM openjdk:8 as builder

WORKDIR /payara

COPY .mvn/ ./.mvn/
COPY mvnw ./
COPY pom.xml ./

RUN ./mvnw dependency:resolve dependency:resolve-plugins

COPY src/ src/
RUN ./mvnw package -DskipTests

FROM qaware/distroless-java-payara-micro:java8-5.201

EXPOSE 8080 9090

USER payara
WORKDIR /opt/payara

ENTRYPOINT ["java", "-server", "-Xshare:auto", "-XX:+UseContainerSupport", "-XX:MaxRAMPercentage=60.0", "-XX:ThreadStackSize=256", "-XX:MaxMetaspaceSize=128m", "-XX:+UseG1GC", "-XX:MaxGCPauseMillis=250", "-XX:+UseStringDeduplication", "-Djava.security.egd=file:/dev/./urandom", "-Dcom.sun.management.jmxremote", "-Dcom.sun.management.jmxremote.port=9090", "-Djava.rmi.server.hostname=localhost", "-Dcom.sun.management.jmxremote.rmi.port=9090", "-Dcom.sun.management.jmxremote.ssl=false", "-Dcom.sun.management.jmxremote.authenticate=false", "-jar", "/opt/payara/payara-micro.jar"]
CMD ["--nocluster", "--disablephonehome", "--deploymentDir", "/opt/payara/deployments"]

# ENTRYPOINT ["java", "-server", "-Xshare:auto", "-XX:+UseContainerSupport", "-XX:MaxRAMPercentage=75.0", "-XX:ThreadStackSize=256", "-XX:MaxMetaspaceSize=128m", "-XX:+UseG1GC", "-XX:MaxGCPauseMillis=250", "-XX:+UseStringDeduplication", "-Djava.security.egd=file:/dev/./urandom", "-Dcom.sun.management.jmxremote", "-Dcom.sun.management.jmxremote.port=9090", "-Djava.rmi.server.hostname=localhost", "-Dcom.sun.management.jmxremote.rmi.port=9090", "-Dcom.sun.management.jmxremote.ssl=false", "-Dcom.sun.management.jmxremote.authenticate=false", "-jar", "/opt/payara/micro-root/launch-micro.jar"]
# CMD ["--nocluster", "--disablephonehome"]

COPY --from=builder /payara/target/payara-weather-war.war /opt/payara/deployments

# USER root
# RUN ["java", "-jar", "/opt/payara/payara-micro.jar", "--rootdir", "/opt/payara/micro-root", "--outputlauncher"]
# RUN ["java", "-jar", "/opt/payara/micro-root/launch-micro.jar", "--deploy", "/opt/payara/deployments/payara-weather-war.war:/", "--warmup", "--nocluster", "--disablephonehome"]
