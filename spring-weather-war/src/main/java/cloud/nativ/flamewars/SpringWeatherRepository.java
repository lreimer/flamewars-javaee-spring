package cloud.nativ.flamewars;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Component
public class SpringWeatherRepository {

    private Map<String, SpringWeather> weather = new HashMap<>();

    @PostConstruct
    void initialize() {
        weather.put("Rosenheim", new SpringWeather("Rosenheim", "Sunshine"));
        weather.put("London", new SpringWeather("London", "Rainy"));
    }

    public SpringWeather getWeatherForCity(String city) {
        try {
            TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextLong(250));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return weather.getOrDefault(city, new SpringWeather(city, "Unknown"));
    }
}
