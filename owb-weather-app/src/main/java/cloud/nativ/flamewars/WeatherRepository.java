package cloud.nativ.flamewars;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class WeatherRepository {

    public Weather findWeatherByCity(String city) {
        return new Weather(city, "Sunshine");
    }
}