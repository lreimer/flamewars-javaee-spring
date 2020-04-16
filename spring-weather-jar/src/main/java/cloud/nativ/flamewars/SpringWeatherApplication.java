package cloud.nativ.flamewars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringWeatherApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWeatherApplication.class, args);
    }

}
