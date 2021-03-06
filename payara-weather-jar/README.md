# Payara Micro Weather Example (JAR)

This example implements a simple weather REST service using Mayara Micro.

- https://start.microprofile.io

## Build and run with JDK8+

```bash
$ mvn package
$ java -jar target/payara-weather-jar-microbundle.jar --nocluster --disablephonehome

$ mvn payara-micro:start
```

## Build and run with Docker

```bash
$ docker build -t payara-weather-jar:1.0.0 .
$ docker run -it --rm --cpus 2 --memory 512m -p 8080:8080 -p 9090:9090 payara-weather-jar:1.0.0

$ docker build -t payara-weather-jar:1.0.0-java11 -f Dockerfile_java11 .
$ docker run -it --rm --cpus 2 --memory 512m -p 8080:8080 -p 9090:9090 payara-weather-jar:1.0.0-java11
```

## Exercise the application

```bash
$ curl -X GET http://localhost:8080/api/weather\?city\=Rosenheim
{"city":"Rosenheim","weather":"Sunshine"}

$ curl -X GET http://localhost:8080/

$ curl -X GET http://localhost:8080/metrics

$ curl -X GET http://localhost:8080/health
$ curl -X GET http://localhost:8080/health/ready
$ curl -X GET http://localhost:8080/health/live
```

## Load Testing 

Assuming you have started InfluxDB and Grafana using Docker Compose from the root of this repository, you can now start
the K6 load test for the weather service.

```bash
$ k6 run -u 50 -d 60s src/test/k6/payara-weather.js -o influxdb=http://localhost:8086/k6

$ k6 run -u 100 -d 120s src/test/k6/payara-weather.js -o influxdb=http://localhost:8086/k6
$ k6 run -u 0 -s 10s:100 -s 100s -s 10s:0 src/test/k6/payara-weather.js -o influxdb=http://localhost:8086/k6
```