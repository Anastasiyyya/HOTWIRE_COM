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

    private Airline airline;
    private Flight flightType;
    private TicketPrice ticketPrice;
    private String departingYear;
    private String departingMonth;
    private String departingDay;
    private String returningYear;
    private String returningMonth;
    private String returningDay;
    private Passenger passenger;

    public FlightSearch(Flight flightType) {
        this.flightType = flightType;
    }

    public String makeUpAirlineInformation() {
        return String.format("%s %s", airline.getLogoUrl(), airline.getAirlineName());
    }

    public String makeUpTicketPrice() {
        return ticketPrice.makeUpSum();
    }

    public String makeUpAirportFrom() {
        return  airportFrom.makeUpAirport();
    }

    public String makeUpAirportTo() {
        return  airportTo.makeUpAirport();
    }
}
