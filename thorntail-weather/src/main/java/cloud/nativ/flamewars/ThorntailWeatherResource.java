package cloud.nativ.flamewars;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.constraints.NotBlank;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/weather")
@ApplicationScoped
public class ThorntailWeatherResource {

    @Inject
    private ThorntailWeatherRepository repository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ThorntailWeather getWeather(@QueryParam("city") @NotBlank String city) {
        return repository.getWeatherForCity(city);
    }

}
