package entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Data
@AllArgsConstructor
@Builder
public class Airport {

    private String airportCode;
    private String airportName;
    private Location location;

    public String getLocation() {
        return String.format("%s %s %s", location.getCountry(), location.getRegion(), location.getCity());
    }

    public String makeUpAirport() {
        return airportCode + " " + airportName;
    }
}
