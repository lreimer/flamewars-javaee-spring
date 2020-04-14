package cloud.nativ.flamewars;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

// @Stateless
@ApplicationScoped
public class KumuluzeeWeatherRepository {

    private Map<String, KumuluzeeWeather> weather = new HashMap<>();

    @Inject
    @ConfigProperty(name = "sleep.bound", defaultValue = "250")
    private int sleepBound;

    @PostConstruct
    void initialize() {
        weather.put("Rosenheim", new KumuluzeeWeather("Rosenheim", "Sunshine"));
        weather.put("London", new KumuluzeeWeather("London", "Rainy"));
    }

    public KumuluzeeWeather getWeatherForCity(String city) {
        try {
            TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextLong(sleepBound));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return weather.getOrDefault(city, new KumuluzeeWeather(city, "Unknown"));
    }
}
