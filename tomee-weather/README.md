# Apache TomEE Weather Example

This example implements a simple weather REST service using Aapche TomEE.

- https://start.microprofile.io

## Build and run with JDK8+

```bash
$ mvn package
$ java -jar target/tomee-weather-exec.jar
```

## Build and run with Docker

```bash
$ docker build -t tomee-weather:1.0.0 .
$ docker run -it --rm -p 8080:8080 tomee-weather:1.0.0
```

## Exercise the application

```bash
$ curl -X GET http://localhost:8080/api/weather\?city\=Rosenheim                                                          ─╯
{"city":"Rosenheim","weather":"Sunshine"}

$ curl -X GET http://localhost:8080/

$ curl -X GET http://localhost:8080/api/metrics
$ curl -X GET http://localhost:8080/api/health
```
