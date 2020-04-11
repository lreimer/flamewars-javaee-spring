package cloud.nativ.flamewars;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Collections;
import java.util.Set;

@ApplicationPath("/api")
public class KumuluzeeWeatherApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        return Collections.singleton(KumuluzeeWeatherResource.class);
    }
}
