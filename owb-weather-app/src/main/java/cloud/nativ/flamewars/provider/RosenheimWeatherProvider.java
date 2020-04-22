package cloud.nativ.flamewars.provider;

import cloud.nativ.flamewars.WeatherProvider;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Named("Rosenheim")
public class RosenheimWeatherProvider implements WeatherProvider {
    @Override
    public String getWeather() {
        return "Sunshine";
    }
}
