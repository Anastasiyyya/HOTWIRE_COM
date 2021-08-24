package entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Data
@AllArgsConstructor
@Builder
public class FlightSearch {

    private String flightType;
    private String departingYear;
    private String departingMonth;
    private String departingDay;

    private String returningYear;
    private String returningMonth;
    private String returningDay;

    private Passenger passenger;

    private Airport airportFrom;
    private Airport airportTo;
}
