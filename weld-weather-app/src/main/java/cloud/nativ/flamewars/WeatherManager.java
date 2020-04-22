package cloud.nativ.flamewars;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@ApplicationScoped
//@Dependent
@Named("weatherManager")
public class WeatherManager {

    @Inject
    private WeatherRepository repository;

    public Weather getWeather(String city) {
        return repository.findWeatherByCity(city);
    }
}
