package steps;

import entities.Flight;
import java.util.List;

public class ChangeFlightsSteps extends BaseSteps{

    /**
     * This step changes flights to another
     * @param flightOrder
     * @return List<Flight>
     */
    public List<Flight> changeRoundTripFlightsToRoundTrip(int flightOrder){

        basePage.getFlightsSearchPage().getTripDetailPage()
                .clickChangeFlights()
                .chooseDepartingFlight(flightOrder)
                .chooseReturningFlight(flightOrder);
        return makeUpFlightsDetailsList();
    }

    /**
     * This step changes one-way flight to another one-way flight
     * @param flightOrder
     * @return List<Flight>
     */
    public List<Flight> changeOneWayFlightToAnotherOneWay(int flightOrder){

        basePage.getFlightsSearchPage().getTripDetailPage()
                .clickChangeFlights()
                .chooseDepartingFlight(flightOrder);
        return makeUpFlightsDetailsList();
    }
}
