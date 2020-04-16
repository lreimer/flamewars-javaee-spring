package cloud.nativ.flamewars;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.Map;

@FeignClient(value = "openweathermap", url = "https://api.openweathermap.org")
public interface OpenWeatherMap {
    // @TimeLimiter(name = "getWeather", fallbackMethod = "defaultWeather")
    // @Retry(name = "getWeather")
    @RequestMapping(method = RequestMethod.GET, value = "/data/2.5/weather")
    Map<String, Object> getWeather(@RequestParam("q") String city, @RequestParam("APPID") String appid);

    default Map<String, Object> defaultWeather(String city, String appid) {
        return Collections.emptyMap();
    }
}
