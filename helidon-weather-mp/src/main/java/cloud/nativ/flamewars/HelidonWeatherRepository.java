package cloud.nativ.flamewars;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class HelidonWeatherRepository {

    private Map<String, HelidonWeather> weather = new HashMap<>();

    @PostConstruct
    void initialize() {
        weather.put("Rosenheim", new HelidonWeather("Rosenheim", "Sunshine"));
        weather.put("London", new HelidonWeather("London", "Rainy"));
    }

    public HelidonWeather getWeatherForCity(String city) {
        return weather.getOrDefault(city, new HelidonWeather(city, "Unknown"));
    }

}
