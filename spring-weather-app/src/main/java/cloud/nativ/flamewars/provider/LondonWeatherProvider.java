package cloud.nativ.flamewars.provider;

import cloud.nativ.flamewars.WeatherProvider;
import org.springframework.stereotype.Component;

@Component("London")
public class LondonWeatherProvider implements WeatherProvider {
    @Override
    public String getWeather() {
        return "Rainy";
    }
}
