package cloud.nativ.flamewars;

import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

@RestController
public class SpringWeatherController {

    @Autowired
    private SpringWeatherRepository repository;

    @GetMapping("/api/weather")
    @Timed
    public SpringWeather weather(@RequestParam(name = "city") @NotBlank String city) {
        return repository.getWeatherForCity(city);
    }

}
