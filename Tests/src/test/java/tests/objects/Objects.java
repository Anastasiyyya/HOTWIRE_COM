package tests.objects;

import entities.FlightSearch;
import entities.Passenger;
import lombok.Data;

@Data
public class Objects {

    public static final Passenger passenger = Passenger.builder()
            .adultPassengersCount(1)
            .childrenPassengersCount(1)
            .build();

    public static final FlightSearch flightSearchOneWay = FlightSearch.builder()
            .flightType("One-Way")
            .airportFrom("Minsk")
            .airportTo("Moscow")
            .departingDay("30")
            .departingMonth("November")
            .departingYear("2021")
            .passenger(passenger)
            .airlineName("Utair Aviation")
            .seatingClass("Economy / Coach")
            .build();

    public static final FlightSearch flightSearchRoundTrip = FlightSearch.builder()
            .flightType("Round-trip")
            .airportFrom("Minsk")
            .airportTo("Moscow")
            .departingDay("30")
            .departingMonth("November")
            .departingYear("2021")
            .returningDay("30")
            .returningMonth("December")
            .returningYear("2021")
            .passenger(passenger)
            .build();
}
