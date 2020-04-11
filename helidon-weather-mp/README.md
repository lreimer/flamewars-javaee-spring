# Helidon Weather MP Example

This example implements a simple weather REST service using Helidon MP.

- https://helidon.io/#/
- https://helidon.io/docs/latest/#/guides/03_quickstart-mp
- https://start.microprofile.io

## Build and run with JDK8+

```bash
$ mvn package
$ java -jar target/helidon-weather-mp.jar
```

## Build and run with Docker

```bash
$ docker build -t helidon-weather-mp:1.0.0 .
$ docker run -it --rm --cpus 2 --memory 512m -p 8080:8080 -p 9090:9090 helidon-weather-mp:1.0.0
```

## Exercise the application

```bash
$ curl -X GET http://localhost:8080/api/weather                                                                           ─╯
{"weather":"Sunshine"}

$ curl -X GET http://localhost:8080/api/weather\?city\=Rosenheim                                                          ─╯
{"city":"Rosenheim","weather":"Sunshine"}

$ curl -X GET http://localhost:8080/metrics
$ curl -X GET http://localhost:8080/health
```

## Load Testing 

Assuming you have started InfluxDB and Grafana using Docker Compose from the root of this repository, you can now start
the K6 load test for the weather service.

```bash
$ k6 run -u 50 -d 60s src/test/k6/helidon-weather.js -o influxdb=http://localhost:8086/k6

$ k6 run -u 100 -d 120s src/test/k6/helidon-weather.js -o influxdb=http://localhost:8086/k6
$ k6 run -u 0 -s 10s:100 -s 100s -s 10s:0 src/test/k6/helidon-weather.js -o influxdb=http://localhost:8086/k6
```
