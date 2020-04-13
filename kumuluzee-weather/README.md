# KumuluzEE Weather Example

This example implements a simple weather REST service using KumuluzEE.

- https://start.microprofile.io
- https://ee.kumuluz.com
- https://ee.kumuluz.com/generator

## Build and run with JDK8+

```bash
$ mvn package
$ java -jar target/kumuluzee-weather.jar
```

## Build and run with Docker

```bash
$ docker build -t kumuluzee-weather:1.0.0 .
$ docker run -it --rm --cpus 2 --memory 512m -p 8080:8080 -p 9090:9090 kumuluzee-weather:1.0.0
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
$ k6 run -u 50 -d 60s src/test/k6/kumuluzee-weather.js -o influxdb=http://localhost:8086/k6

$ k6 run -u 100 -d 120s src/test/k6/kumuluzee-weather.js -o influxdb=http://localhost:8086/k6
$ k6 run -u 0 -s 10s:100 -s 100s -s 10s:0 src/test/k6/kumuluzee-weather.js -o influxdb=http://localhost:8086/k6
```