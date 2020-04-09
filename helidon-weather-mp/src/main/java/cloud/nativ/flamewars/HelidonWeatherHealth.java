package cloud.nativ.flamewars;

import org.eclipse.microprofile.health.Health;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;

import javax.enterprise.context.ApplicationScoped;

@Health
@ApplicationScoped
public class HelidonWeatherHealth implements HealthCheck {
    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.named("weatherCheck").up().build();
    }
}
