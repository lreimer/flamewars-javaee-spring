package cloud.nativ.flamewars;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
public class MeecrowaveWeatherRepository {

    private Map<String, MeecrowaveWeather> weather = new HashMap<>();

    @PostConstruct
    void initialize() {
        weather.put("Rosenheim", new MeecrowaveWeather("Rosenheim", "Sunshine"));
        weather.put("London", new MeecrowaveWeather("London", "Rainy"));
    }

    public MeecrowaveWeather getWeatherForCity(String city) {
        try {
            TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextLong(250));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return weather.getOrDefault(city, new MeecrowaveWeather(city, "Unknown"));
    }
}
