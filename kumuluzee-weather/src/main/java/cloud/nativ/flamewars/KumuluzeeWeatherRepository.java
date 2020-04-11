package cloud.nativ.flamewars;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

// @Stateless
@ApplicationScoped
public class KumuluzeeWeatherRepository {

    private Map<String, KumuluzeeWeather> weather = new HashMap<>();

    @PostConstruct
    void initialize() {
        weather.put("Rosenheim", new KumuluzeeWeather("Rosenheim", "Sunshine"));
        weather.put("London", new KumuluzeeWeather("London", "Rainy"));
    }

    public KumuluzeeWeather getWeatherForCity(String city) {
        try {
            TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextLong(250));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return weather.getOrDefault(city, new KumuluzeeWeather(city, "Unknown"));
    }
}
