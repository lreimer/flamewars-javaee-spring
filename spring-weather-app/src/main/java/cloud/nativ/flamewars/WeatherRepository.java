package cloud.nativ.flamewars;

import org.springframework.stereotype.Component;

@Component
public class WeatherRepository {

    public Weather findWeatherByCity(String city) {
        return new Weather(city, "Sunshine");
    }
}