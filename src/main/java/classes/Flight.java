package classes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;

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

    public String getAirline() {
        return String.format("%s %s", Arrays.toString(airline.getLogo()), airline.getAirlineName());
    }

    public String getTicketPrice() {
        return ticketPrice.getSum();
    }

    public String getAirportFrom() {
        return  airportFrom.makeUpAirport();
    }

    public String getAirportTo() {
        return  airportTo.makeUpAirport();
    }
}
