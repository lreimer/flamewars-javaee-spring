package cloud.nativ.flamewars.provider;

import cloud.nativ.flamewars.WeatherProvider;
import org.springframework.stereotype.Component;

@Component("Rosenheim")
public class RosenheimWeatherProvider implements WeatherProvider {
    @Override
    public String getWeather() {
        return "Sunshine";
    }
}
