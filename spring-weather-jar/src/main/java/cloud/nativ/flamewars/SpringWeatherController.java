package cloud.nativ.flamewars;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringWeatherController {

    @GetMapping("/api/weather")
    public SpringWeather weather(@RequestParam(name = "city") String city) {
        return new SpringWeather(city, "Sunshine");
    }

}
