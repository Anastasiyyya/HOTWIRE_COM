package entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Airport {

    private String airportCode;
    private String airportName;
    private Location location;

    public String makeUpLocation() {
        return String.format("%s, %s (%s)", location.getCity(), location.getCountry(), airportCode);
    }
}
