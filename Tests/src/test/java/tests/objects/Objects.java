package tests.objects;

import entities.FlightSearch;
import entities.Location;
import entities.Passenger;
import lombok.Data;

@Data
public class Objects {

    public static final Passenger childPassenger = Passenger.builder()
            .childrenPassengersCount(1)
            .build();

    public static final Passenger adultPassenger = Passenger.builder()
            .adultPassengersCount(2)
            .build();

    public static final FlightSearch flightSearchOneWay = FlightSearch.builder()
            .flightType("One-Way")
            .airportFrom(Location.builder()
                    .city("Minsk")
                    .build())
            .airportTo(Location.builder()
                    .city("Moscow")
                    .build())
            .departingDay("30")
            .departingMonth("November")
            .departingYear("2021")
            .passenger(childPassenger)
            .build();

    public static final FlightSearch flightSearchRoundTrip = FlightSearch.builder()
            .flightType("Round-Trip")
            .airportFrom(Location.builder()
                    .city("Minsk")
                    .build())
            .airportTo(Location.builder()
                    .city("Moscow")
                    .build())
            .departingDay("30")
            .departingMonth("November")
            .departingYear("2021")
            .returningDay("30")
            .returningMonth("December")
            .returningYear("2021")
            .passenger(adultPassenger)
            .build();

    public static final  Location location = Location.builder()
            .city("Minsk")
            .build();
}
