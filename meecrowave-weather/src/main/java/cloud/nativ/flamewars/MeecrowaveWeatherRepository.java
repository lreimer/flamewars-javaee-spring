package cloud.nativ.flamewars;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class MeecrowaveWeatherRepository {

    private Map<String, MeecrowaveWeather> weather = new HashMap<>();

    @PostConstruct
    void initialize() {
        weather.put("Rosenheim", new MeecrowaveWeather("Rosenheim", "Sunshine"));
        weather.put("London", new MeecrowaveWeather("London", "Rainy"));
    }

    public MeecrowaveWeather getWeatherForCity(String city) {
        return weather.getOrDefault(city, new MeecrowaveWeather(city, "Unknown"));
    }
}
