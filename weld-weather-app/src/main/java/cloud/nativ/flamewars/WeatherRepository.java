package cloud.nativ.flamewars;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.literal.NamedLiteral;
import javax.inject.Inject;

@ApplicationScoped
public class WeatherRepository {

    @Inject
    private Instance<WeatherProvider> providers;

    public Weather findWeatherByCity(String city) {
        WeatherProvider provider = providers.select(NamedLiteral.of(city)).get();
        return new Weather(city, provider.getWeather());
    }
}