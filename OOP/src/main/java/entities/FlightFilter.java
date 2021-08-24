package entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import java.util.List;

@Log4j2
@Data
@AllArgsConstructor
@Builder
public class FlightFilter {

    private List<Passenger> passengers;
    private FlightSearch flightSearch;

    public void addPassengerToList(Passenger passenger) {
        passengers.add(passenger);
        log.info("Passenger" + passenger + "have been added to list");
    }

    public void printListOfPassengers() {
        for (Passenger p: passengers) {
            System.out.println(p);
        }
    }
}
