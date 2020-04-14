package cloud.nativ.flamewars;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
public class HelidonWeatherRepository {

    private Map<String, HelidonWeather> weather = new HashMap<>();

    @Inject
    @ConfigProperty(name = "sleep.bound", defaultValue = "250")
    private int sleepBound;

    @PostConstruct
    void initialize() {
        weather.put("Rosenheim", new HelidonWeather("Rosenheim", "Sunshine"));
        weather.put("London", new HelidonWeather("London", "Rainy"));
    }

    public HelidonWeather getWeatherForCity(String city) {
        try {
            TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextLong(sleepBound));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return weather.getOrDefault(city, new HelidonWeather(city, "Unknown"));
    }

}
