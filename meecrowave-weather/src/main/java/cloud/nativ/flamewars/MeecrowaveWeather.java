package cloud.nativ.flamewars;

public class MeecrowaveWeather {

    public MeecrowaveWeather(final String city, final String weather) {
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
}
