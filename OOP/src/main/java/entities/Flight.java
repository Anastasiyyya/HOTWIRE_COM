package entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import java.time.format.DateTimeFormatter;

@Log4j2
@Data
@AllArgsConstructor
@Builder
public class Flight {

    private Airline airline;
    private String flightType;
    private TicketPrice ticketPrice;
    private DateTimeFormatter departingDateAndTime;
    private DateTimeFormatter returningDate;
    private Airport airportFrom;
    private Airport airportTo;

    public String makeUpAirlineInformation() {
        return String.format("%s %s", airline.getLogoUrl(), airline.getAirlineName());
    }

    public String getTicketPrice() {
        return ticketPrice.makeUpSum();
    }

    public String getAirportFrom() {
        return  airportFrom.makeUpAirport();
    }

    public String getAirportTo() {
        return  airportTo.makeUpAirport();
    }
}
