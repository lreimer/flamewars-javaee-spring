package cloud.nativ.flamewars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("weatherManager")
public class WeatherManager {

    private final WeatherRepository repository;

    @Autowired
    public WeatherManager(WeatherRepository repository) {
        this.repository = repository;
    }

    public Weather getWeather(String city) {
        return repository.findWeatherByCity(city);
    }
}
