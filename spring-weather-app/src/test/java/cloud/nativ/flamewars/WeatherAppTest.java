package cloud.nativ.flamewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class WeatherAppTest {
    @Test
    void appHasWeather() {
        WeatherApp classUnderTest = new WeatherApp();
        classUnderTest.start();

        assertNotNull(classUnderTest.getWeather("Rosenheim"), "app should have weather");

        classUnderTest.stop();
    }
}
