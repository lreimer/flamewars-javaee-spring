package cloud.nativ.flamewars;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface SpringWeatherRepository extends JpaRepository<SpringWeather, String> {
    List<SpringWeather> findAllByCityAndNextUpdateAfter(String city, LocalDateTime now);
}
