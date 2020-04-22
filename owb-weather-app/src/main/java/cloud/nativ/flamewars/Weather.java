package cloud.nativ.flamewars;

import java.util.StringJoiner;

public class Weather {

    public Weather(final String city, final String weather) {
        this.city = city;
        this.weather = weather;
    }

    private String city;
    private String weather;

    public String getCity() {
        return city;
    }

    public String getWeather() {
        return weather;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Weather.class.getSimpleName() + "[", "]")
                .add("city='" + city + "'")
                .add("weather='" + weather + "'")
                .toString();
    }
}
