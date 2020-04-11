package cloud.nativ.flamewars;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
public class HelidonWeatherRepository {

    private Map<String, HelidonWeather> weather = new HashMap<>();

    @PostConstruct
    void initialize() {
        weather.put("Rosenheim", new HelidonWeather("Rosenheim", "Sunshine"));
        weather.put("London", new HelidonWeather("London", "Rainy"));
    }

    public HelidonWeather getWeatherForCity(String city) {
        try {
            TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextLong(500));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return weather.getOrDefault(city, new HelidonWeather(city, "Unknown"));
    }

}
