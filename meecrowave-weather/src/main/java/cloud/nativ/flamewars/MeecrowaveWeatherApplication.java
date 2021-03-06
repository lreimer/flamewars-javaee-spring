package cloud.nativ.flamewars;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Collections;
import java.util.Set;

@ApplicationScoped
@ApplicationPath("/api")
public class MeecrowaveWeatherApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        return Collections.singleton(MeecrowaveWeatherResource.class);
    }
}
