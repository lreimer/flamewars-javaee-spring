package cloud.nativ.flamewars;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "weather")
public class OpenWeatherMapConfiguration {

    private String appId;
    private String uri;

    public String getAppId() {
        return appId;
    }

    public String getUri() {
        return uri;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
