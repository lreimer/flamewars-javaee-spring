package cloud.nativ.flamewars;

import org.apache.commons.lang3.time.StopWatch;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class WeatherApp {

    private static final Logger LOGGER = Logger.getLogger(Weather.class.getName());

    public static void main(String[] args) {
        WeatherApp app = new WeatherApp();
        app.start();

        // who needs for loops, right?!
        IntStream.range(0, 3).forEach(i -> {
            Weather rosenheim = app.getWeather("Rosenheim");
            LOGGER.info(rosenheim.toString());
        });

        // oops, I did it again. ;)
        IntStream.range(0, 3).forEach(i -> {
            Weather london = app.getWeather("London");
            LOGGER.info(london.toString());
        });

        app.stop();
    }

    Weather getWeather(String city) {
        StopWatch watch = StopWatch.createStarted();
        WeatherManager manager = container.select(WeatherManager.class).get();
        LOGGER.log(Level.INFO, "Lookup took {0} ns.", watch.getTime(TimeUnit.NANOSECONDS));
        return manager.getWeather(city);
    }

    private SeContainer container;

    void start() {
        StopWatch watch = StopWatch.createStarted();
        container = SeContainerInitializer.newInstance().disableDiscovery().addPackages(true, WeatherApp.class).initialize();
        LOGGER.log(Level.INFO, "Start took {0} ms.", watch.getTime(TimeUnit.MILLISECONDS));
    }

    void stop() {
        container.close();
    }
}
