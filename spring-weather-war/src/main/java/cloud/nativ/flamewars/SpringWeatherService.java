package cloud.nativ.flamewars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class SpringWeatherService {

    @Autowired
    private SpringWeatherRepository repository;

    @Value("${next.update.offset:1}")
    private int nextUpdateOffset;

    @Autowired
    private OpenWeatherMapConnector connector;

    public SpringWeather getWeatherForCity(String city) {
        List<SpringWeather> currentWeather = repository.findAllByCityAndNextUpdateAfter(city, LocalDateTime.now());
        if (currentWeather.isEmpty()) {
            String weather = connector.getWeather(city);
            SpringWeather current = new SpringWeather(city, weather);
            return repository.save(current.touch(nextUpdateOffset));
        } else {
            return currentWeather.get(0);
        }
    }
}
