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
$ docker run -it --rm -p 8080:8080 helidon-weather-mp:1.0.0
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
