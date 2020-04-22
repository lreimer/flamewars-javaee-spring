package cloud.nativ.flamewars.provider;

import cloud.nativ.flamewars.WeatherProvider;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component("London")
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class LondonWeatherProvider implements WeatherProvider {
    @Override
    public String getWeather() {
        return "Rainy";
    }
}
