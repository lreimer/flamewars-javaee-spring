# Spring Weather (JAR) Example

This example implements a simple weather REST service using Spring Boot (JAR).

- https://spring.io
- https://start.spring.io

## Build and run with JDK8+

```bash
$ mvn package
$ java -jar target/spring-weather-jar-1.0.0.jar
```

## Build and run with Docker

```bash
$ docker build -t spring-weather-jar:1.0.0 .
$ docker run -it --rm -p 8080:8080 spring-weather-jar:1.0.0
```

## Exercise the application

```bash
$ curl -X GET http://localhost:8080/api/weather\?city\=Rosenheim                                                          ─╯
{"city":"Rosenheim","weather":"Sunshine"}

$ curl -X GET http://localhost:8080/

$ curl -X GET http://localhost:8080/metrics
$ curl -X GET http://localhost:8080/health
```
