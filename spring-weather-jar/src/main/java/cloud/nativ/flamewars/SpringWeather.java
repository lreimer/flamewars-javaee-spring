package cloud.nativ.flamewars;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "current_weather")
public class SpringWeather {

    SpringWeather() {
    }

    public SpringWeather(final String city, final String weather) {
        this.city = city;
        this.weather = weather;
    }

    @Id
    @Column(name = "city", unique = true, nullable = false)
    private String city;

    @Column(name = "weather", nullable = false)
    private String weather;

    @Column(name = "next_update", columnDefinition = "TIMESTAMP")
    @JsonIgnore
    private LocalDateTime nextUpdate;

    public String getCity() {
        return city;
    }

    public String getWeather() {
        return weather;
    }

    public LocalDateTime getNextUpdate() {
        return nextUpdate;
    }

    public SpringWeather touch(int offset) {
        this.nextUpdate = LocalDateTime.now().plusMinutes(offset);
        return this;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }
}
