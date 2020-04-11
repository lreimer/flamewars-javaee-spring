package cloud.nativ.flamewars;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class SpringWeatherRepository {

    private Map<String, SpringWeather> weather = new HashMap<>();

    @PostConstruct
    void initialize() {
        weather.put("Rosenheim", new SpringWeather("Rosenheim", "Sunshine"));
        weather.put("London", new SpringWeather("London", "Rainy"));
    }

    public SpringWeather getWeatherForCity(String city) {
        return weather.getOrDefault(city, new SpringWeather(city, "Unknown"));
    }
}
