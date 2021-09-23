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

    public static final FlightSearch flightSearch = FlightSearch.builder()
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

    public static final  Location location = Location.builder()
            .city("Minsk")
            .build();
}