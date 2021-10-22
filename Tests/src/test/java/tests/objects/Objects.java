package tests.objects;

import entities.FlightSearch;
import entities.Passenger;
import lombok.Data;
import org.apache.commons.compress.utils.Lists;

import java.util.Arrays;
import java.util.List;

@Data
public class Objects {

    public static final Passenger PASSENGER = Passenger.builder()
            .adultPassengersCount(1)
            .childrenPassengersCount(1)
            .build();

    public static final FlightSearch FLIGHT_SEARCH_ONE_WAY = FlightSearch.builder()
            .flightType("One-Way")
            .airportFrom("Minsk")
            .airportTo("Moscow")
            .departingDay("30")
            .departingMonth("November")
            .departingYear("2021")
            .passenger(PASSENGER)
            .airlineName("Utair Aviation")
            .seatingClass("Economy / Coach")
            .build();

    public static final FlightSearch FLIGHT_SEARCH_ROUND_TRIP = FlightSearch.builder()
            .flightType("Round-trip")
            .airportFrom("Minsk")
            .airportTo("Moscow")
            .departingDay("30")
            .departingMonth("November")
            .departingYear("2021")
            .returningDay("30")
            .returningMonth("December")
            .returningYear("2021")
            .passenger(PASSENGER)
            .build();

    public static final List<String> DIRECTION = Arrays.asList("MSQ - VKO","MSQ - DME","MSQ - SVO");
}
