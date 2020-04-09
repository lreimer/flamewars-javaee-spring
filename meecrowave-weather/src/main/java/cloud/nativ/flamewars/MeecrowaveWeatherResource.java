package cloud.nativ.flamewars;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/weather")
@ApplicationScoped
public class MeecrowaveWeatherResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public MeecrowaveWeather getWeather(@QueryParam("city") String city) {
        return new MeecrowaveWeather(city, "Sunshine");
    }

}
