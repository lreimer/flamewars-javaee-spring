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

EXPOSE 8080 8005 8009

ENTRYPOINT ["java", "-jar", "/tomee/tomee-weather-exec.jar"]

COPY --from=builder /tomee/target/tomee-weather-exec.jar ./

# FROM tomee:8-jre-8.0.1-microprofile
# COPY --from=builder /tomee/target/apache-tomee/webapps/ROOT.war /usr/local/tomee/webapps/
