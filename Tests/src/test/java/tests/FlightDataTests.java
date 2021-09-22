package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.objects.Objects;

public class FlightDataTests extends BaseTest {

    /**
     * AS-0 according to the test-cases specification
     * https://docs.google.com/document/d/1nCM4rGxKGTkTgmzOHvTp39juojYjvtuo7xIoABjV2fo/edit?usp=sharing
     * This test checks that the input field works correctly.
     * Results of searching in dropdown menu correspond to the entered data
     */
    @Test(description = "Checks that the input field works correctly")
    public void checkInputResults() {
        findFlightSteps.findSearchingResultsList(Objects.location);
    }

    /**
     * AS-1 according to the test-cases specification
     * https://docs.google.com/document/d/1nCM4rGxKGTkTgmzOHvTp39juojYjvtuo7xIoABjV2fo/edit?usp=sharing
     * This test checks that the entered data is displayed on the 'Flight Search' page correctly.
     */
    @Test(description = "Checks that the input field works correctly")
    public void checkEnteredData(){
        findFlightSteps.findOneWayTripFlight(Objects.flightSearch);
        Assert.assertTrue(findFlightSteps.assertTripType());
        Assert.assertTrue(findFlightSteps.assertFlyFromTo());
    }
}
