package entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Flight {

    private String airportFrom;
    private String airportTo;
    private String flightType;
    private String flightPrice;
}
