package cloud.nativ.flamewars;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Stateless
public class TomeeWeatherRepository {

    private Map<String, TomeeWeather> weather = new HashMap<>();

    @PostConstruct
    void initialize() {
        weather.put("Rosenheim", new TomeeWeather("Rosenheim", "Sunshine"));
        weather.put("London", new TomeeWeather("London", "Rainy"));
    }

    public TomeeWeather getWeatherForCity(String city) {
        try {
            TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextLong(250));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return weather.getOrDefault(city, new TomeeWeather(city, "Unknown"));
    }
}
