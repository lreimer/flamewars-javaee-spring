package cloud.nativ.flamewars;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class WeatherRepository implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public Weather findWeatherByCity(String city) {
        WeatherProvider provider = applicationContext.getBean(city, WeatherProvider.class);
        return new Weather(city, provider.getWeather());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}