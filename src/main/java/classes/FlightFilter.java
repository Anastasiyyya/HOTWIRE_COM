package classes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.util.Arrays;

@Log4j2
@Data
@AllArgsConstructor
@Builder
public class FlightFilter {

    private Passenger[] passengers;
    private Flight flight;
    private boolean baggageWeight;

    public void addPassengerToList(Passenger passenger) {
        passengers = Arrays.copyOf(passengers, passengers.length + 1);
        passengers[passengers.length - 1] = passenger;
        log.info("Passenger was added to list");
    }

    public void printListOfPassengers() {
        for (Passenger p: passengers) {
            System.out.println(p);
        }
    }
}