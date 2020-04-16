# Spring Weather (WAR) Example

This example implements a simple weather REST service using Spring Boot (WAR).

- https://spring.io
- https://start.spring.io

## Build and run with JDK8+

```bash
$ mvn package
$ java -jar target/spring-weather-war-1.0.0.war

$ mvn spring-boot:run
```

## Build and run with Docker

```bash
$ docker build -t spring-weather-war:1.0.0 .
$ docker-compose up
$ docker stack deploy -c docker-compose.yml spring-weather-war
$ docker stack rm spring-weather-war
```

## Exercise the application

```bash
$ curl -X GET http://localhost:8080/api/weather\?city\=Rosenheim
{"city":"Rosenheim","weather":"Sunshine"}

$ curl -X GET http://localhost:8080/

$ curl -X GET http://localhost:8080/metrics
$ curl -X GET http://localhost:8080/health
```

## Load Testing 

Assuming you have started InfluxDB and Grafana using Docker Compose from the root of this repository, you can now start
the K6 load test for the weather service.

```bash
$ k6 run -u 50 -d 60s src/test/k6/spring-weather.js -o influxdb=http://localhost:8086/k6

$ k6 run -u 100 -d 120s src/test/k6/spring-weather.js -o influxdb=http://localhost:8086/k6
$ k6 run -u 0 -s 10s:100 -s 100s -s 10s:0 src/test/k6/spring-weather.js -o influxdb=http://localhost:8086/k6
```
