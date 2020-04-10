# Helidon Weather MP Example

This example implements a simple weather REST service using Apache Meecrowave.

- https://openwebbeans.apache.org/meecrowave/index.html

## Build and run with JDK8+

```bash
$ mvn package
$ java -jar target/meecrowave-weather-1.0.0-fat.jar
```

## Build and run with Docker

```bash
$ docker build -t meecrowave-weather:1.0.0 .
$ docker run -it --rm -p 8080:8080 meecrowave-weather:1.0.0
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
