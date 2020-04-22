package cloud.nativ.flamewars.provider;

import cloud.nativ.flamewars.WeatherProvider;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component("Rosenheim")
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class RosenheimWeatherProvider implements WeatherProvider {
    @Override
    public String getWeather() {
        return "Sunshine";
    }
}
