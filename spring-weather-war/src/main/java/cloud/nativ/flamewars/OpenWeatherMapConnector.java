package cloud.nativ.flamewars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

@Component
public class OpenWeatherMapConnector {
    @Autowired
    private OpenWeatherMapConfiguration configuration;
    @Autowired
    private OpenWeatherMap openWeatherMap;

    public String getWeather(String city) {
        Map<String, Object> response = openWeatherMap.getWeather(city, configuration.getAppId());
        return getWeather(response);
    }

    private String getWeather(Map<String, Object> response) {
        // super wacky JSON parsing follows, feign does not seem to support JsonObject
        String weather = Objects.toString(response.get("weather"), "Unknown");
        String[] parts = weather.split(" ");
        if (parts.length == 1) {
            return parts[0];
        } else {
            String main = parts[1].split("=")[1];
            return main.substring(0, main.length() - 1);
        }
    }
}
