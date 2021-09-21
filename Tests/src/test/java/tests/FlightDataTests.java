package tests;

import entities.FlightSearch;
import entities.Location;
import entities.Passenger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FlightDataTests extends BaseTest {

    /**
     * AS-0 according to the test-cases specification
     * This test checks that the input field works correctly.
     * Results of searching in dropdown menu correspond to the entered data
     */
    @Test(description = "Checks that the input field works correctly")
    public void checkInputResults() {
        Location location = Location.builder()
                .city("Minsk")
                .build();
        findFlightSteps.findSearchingResultsList(location);
    }

    /**
     * AS-1 according to the test-cases specification
     * This test checks that the entered data is displayed on the 'Flight Search' page correctly.
     */
    @Test(description = "Checks that the input field works correctly")
    public void checkEnteredData(){
        Passenger childPassenger = Passenger.builder()
                .childrenPassengersCount(1)
                .build();
        FlightSearch flightSearch = FlightSearch.builder()
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
        findFlightSteps.findOneWayTripFlight(flightSearch);
        Assert.assertEquals(findFlightSteps.getChildrenCount(flightSearch)
                + findFlightSteps.getAdultsCount(flightSearch), findFlightSteps.getGeneralPassengersCount(flightSearch));
        Assert.assertTrue(findFlightSteps.assertTripType());
        Assert.assertTrue(findFlightSteps.assertFlyFromTo());
    }
}
