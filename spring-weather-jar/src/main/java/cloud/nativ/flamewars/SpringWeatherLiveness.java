package cloud.nativ.flamewars;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component(value = "livenessCheck")
public class SpringWeatherLiveness implements HealthIndicator {
    @Override
    public Health health() {
        return Health.up().withDetail("live", true).build();
    }
}
