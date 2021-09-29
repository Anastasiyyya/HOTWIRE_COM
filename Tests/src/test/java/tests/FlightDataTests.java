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
        String locationTo = "Minsk";

        findFlightSteps.findSearchingResultsList(locationTo);
        Assert.assertTrue(findFlightSteps.isTheEnteredDataInTheSearchResults(locationTo));
    }

    /**
     * AS-1 according to the test-cases specification
     * https://docs.google.com/document/d/1nCM4rGxKGTkTgmzOHvTp39juojYjvtuo7xIoABjV2fo/edit?usp=sharing
     * This test checks that the entered data is displayed on the 'Flight Search' page correctly.
     */
    @Test(description = "Check that the entered data is displayed correctly")
    public void checkEnteredDataUsingBasePageForm(){
        String filter = "Nonstop";

        findFlightSteps.fillOneWayTripFlightWithData(Objects.FLIGHT_SEARCH_ONE_WAY);
        int passengersCount = findFlightSteps.receiveGeneralPassengersCountFromBasePage(Objects.FLIGHT_SEARCH_ONE_WAY);
        findFlightSteps
                .goToFlightSearchPage()
                .selectFilter(filter);
        Assert.assertTrue(findFlightSteps.isFlyFromToDirectionCorrect(Objects.DIRECTION));
        Assert.assertTrue(findFlightSteps.isPassengersCountCorrect(passengersCount));
        Assert.assertTrue(findFlightSteps.isTripTypeOneWay());
    }

    /**
     * AS-2 according to the test-cases specification
     * https://docs.google.com/document/d/1nCM4rGxKGTkTgmzOHvTp39juojYjvtuo7xIoABjV2fo/edit?usp=sharing
     * This test checks that the entered data is displayed on the 'Flight Search' page correctly.
     */
    @Test(description = "Check that the entered data is displayed correctly")
    public void checkEnteredDataUsingFlightForm() {
        String filter = "Belavia";

        findFlightSteps
                .findRoundTripFlightFromFlightPage(Objects.FLIGHT_SEARCH_ROUND_TRIP)
                .selectFilter(filter);
        String direction = findFlightSteps.flightDirection();
        String airlineName = findFlightSteps.flightAirline();
        String flightType = findFlightSteps.flightType();
        findFlightSteps.chooseDepartingFlight();

        Assert.assertTrue(findFlightSteps.isAirlineEqualToSelected(airlineName));
        Assert.assertTrue(findFlightSteps.isDirectionEqualToSelected(direction));
        Assert.assertTrue(findFlightSteps.isFlightTypeEqualToSelected(flightType));

    }

    /**
     * AS-3 according to the test-cases specification
     * https://docs.google.com/document/d/1nCM4rGxKGTkTgmzOHvTp39juojYjvtuo7xIoABjV2fo/edit?usp=sharing
     * This test checks that the entered data is displayed on the 'Flight Search'
     * page correctly (in the Search form on the top of the page).
     * Also this test checks the opportunity to find flight with correct data using Flight Search form on the Flight Search page.
     */
    @Test(description = "Check that the entered data is displayed correctly")
    public void checkEnteredDataUsingSearchingOnTheFlightSearchPage(){

        findFlightSteps
                .fillOneWayTripFlightWithData(Objects.FLIGHT_SEARCH_ONE_WAY)
                .clickDoneButtonOnPassengersWindow()
                .goToFlightSearchPage()
                .selectSearchingOptions(Objects.FLIGHT_SEARCH_ONE_WAY);

        Assert.assertTrue(findFlightSteps.isFlyFromToDirectionCorrect(Objects.DIRECTION));
        Assert.assertTrue(findFlightSteps.isTripNonstop());
        Assert.assertTrue(findFlightSteps.isAirlineCorrect(Objects.FLIGHT_SEARCH_ONE_WAY.getAirlineName()));
    }

    /**
     * AS-4 according to the test-cases specification
     * https://docs.google.com/document/d/1nCM4rGxKGTkTgmzOHvTp39juojYjvtuo7xIoABjV2fo/edit?usp=sharing
     * This test checks that the functionality 'Choose flight' works correctly
     * and checks that the data on the Trip detail page equals to entered data
     */
    @Test(description = "Check that the entered data is displayed correctly on the Trip Detail Page")
    public void checkEnteredDataUsingSearchingOnTheTripDetailPage()  {

        String directionFrom = "Minsk";
        String directionTo = "Moscow";

        findFlightSteps
                .findRoundTripFlightFromBasePage(Objects.FLIGHT_SEARCH_ROUND_TRIP)
                .clickDoneButtonOnPassengersWindow()
                .goToFlightSearchPage()
                .chooseDepartingFlight()
                .chooseReturningFlight()
                .goToTripDetailPage();
        Assert.assertTrue(findFlightSteps.isDirectionCorrect(directionFrom,directionTo));
    }

    /**
     * AS-5 according to the test-cases specification
     * https://docs.google.com/document/d/1nCM4rGxKGTkTgmzOHvTp39juojYjvtuo7xIoABjV2fo/edit?usp=sharing
     * This test checks the possibility of changing flight to another
     */
    @Test(description = "Check the possibility of changing flight to another")
    public void changeFlightToAnother()  {

        String firstAirlineName = "Belavia";
        String secondAirlineName = "Utair Aviation";

        findFlightSteps
                .findRoundTripFlightFromBasePage(Objects.FLIGHT_SEARCH_ROUND_TRIP)
                .clickDoneButtonOnPassengersWindow()
                .goToFlightSearchPage()
                .selectFilter(firstAirlineName)
                .chooseDepartingFlight()
                .chooseReturningFlight()
                .goToTripDetailPage()
                .clickChangeFlights();
        findFlightSteps
                .selectFilter(secondAirlineName)
                .chooseDepartingFlight()
                .chooseReturningFlight()
                .goToTripDetailPage();

        Assert.assertTrue(findFlightSteps.isAirlineForTheFlightToChanged(secondAirlineName));
    }
}
