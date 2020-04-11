# #Flamewars. X is better than Y! Or is it?

Disputes among computer scientists are probably as old as the computer itself. Who actually invented the computer? Konrad Zuse, Thomas Flowers or was it the Swiss? And what was the best editor again? VIM or Emacs? Admittedly, a good #Flamewar and the daily technology rant in the coffee kitchen among colleagues are fun and exhilarating. The discussions always have a true core, but are often not conducted fairly: the advantages of one are compared to the disadvantages of the other without throwing their advantages into the balance.

## { def X = "Java EE"; def Y = "Spring"; }

In this edition of `#Flamewars. X is better than Y!` we are devoting ourselves to an epic dispute within the enterprise developer community, which has been fierce for almost 20 years now: Java EE vs. Spring.

## The Contenders

## Load Testing

We will use K6 to perform some simple load testing of all the contenders. First, you need to fire up InfluxDB and Grafana for metrics visualization.

```bash
# start the Influx DB and Grafana container
$ docker-compose up -d influxdb grafana

$ open http://localhost:3000
echo "Import the Grafana dashboard https://grafana.com/dashboards/2587"

$ k6 run -u 50 -d 60s helidon-weather-mp/src/test/k6/helidon-weather.js -o influxdb=http://localhost:8086/k6

$ k6 run -u 50 -d 60s meecrowave-weather/src/test/k6/meecrowave-weather.js -o influxdb=http://localhost:8086/k6

$ k6 run -u 50 -d 60s spring-weather-jar/src/test/k6/spring-weather.js -o influxdb=http://localhost:8086/k6

$ k6 run -u 50 -d 60s spring-weather-war/src/test/k6/spring-weather.js -o influxdb=http://localhost:8086/k6

$ k6 run -u 50 -d 60s tomee-weather/src/test/k6/tomee-weather.js -o influxdb=http://localhost:8086/k6
```

## Maintainer

M.-Leander Reimer (@lreimer), <mario-leander.reimer@qaware.de>

## License

This software is provided under the MIT open source license, read the `LICENSE`
file for details.
