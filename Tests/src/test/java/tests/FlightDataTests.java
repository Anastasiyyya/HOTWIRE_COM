package tests;

import io.qameta.allure.Link;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.objects.Objects;
import tests.utils.Retry;

public class FlightDataTests extends BaseTest {

    /**
     * AS-0 according to the test-cases specification
     * This test checks that the input field works correctly.
     * Results of searching in dropdown menu correspond to the entered data
     */
    @Link(value = "AS-0 Test-case Link", url = "https://docs.google.com/document/d/1nCM4rGxKGTkTgmzOHvTp39juojYjvtuo7xIoABjV2fo/edit#heading=h.f91xbko3ooqx")
    @Test(testName = "AS-0 Check that the input field works correctly", retryAnalyzer = Retry.class)
    public void checkInputField() {
        String locationTo = "Minsk";

        findFlightSteps.findSearchingResultsList(locationTo);
        Assert.assertTrue(findFlightSteps.isTheEnteredDataInTheSearchResults(locationTo));
    }

    /**
     * AS-1 according to the test-cases specification
     * This test checks that the entered data is displayed on the 'Flight Search' page correctly.
     */
    @Link(value = "AS-1 Test-case Link",url = "https://docs.google.com/document/d/1nCM4rGxKGTkTgmzOHvTp39juojYjvtuo7xIoABjV2fo/edit#heading=h.3qa2pcckavoe")
    @Test(testName = "AS-1 Check that the entered data is displayed correctly", retryAnalyzer = Retry.class)
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
     * This test checks that the entered data is displayed on the 'Flight Search' page correctly.
     */
    @Link(value = "AS-2 Test-case Link", url = "https://docs.google.com/document/d/1nCM4rGxKGTkTgmzOHvTp39juojYjvtuo7xIoABjV2fo/edit#heading=h.xpjjba4vy4mb")
    @Test(testName = "AS-2 Check that the entered data is displayed correctly", retryAnalyzer = Retry.class)
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
     * This test checks that the entered data is displayed on the 'Flight Search'
     * page correctly (in the Search form on the top of the page).
     * Also this test checks the opportunity to find flight with correct data using Flight Search form on the Flight Search page.
     */
    @Link(value = "AS-3 Test-case Link", url = "https://docs.google.com/document/d/1nCM4rGxKGTkTgmzOHvTp39juojYjvtuo7xIoABjV2fo/edit#heading=h.frlaxgdd9x23")
    @Test(testName = "AS-3 Check that the entered data is displayed correctly", retryAnalyzer = Retry.class)
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
     * This test checks that the functionality 'Choose flight' works correctly
     * and checks that the data on the Trip detail page equals to entered data
     */
    @Link(value = "AS-4 Test-case Link", url = "https://docs.google.com/document/d/1nCM4rGxKGTkTgmzOHvTp39juojYjvtuo7xIoABjV2fo/edit#heading=h.hbqamx5cv5rk")
    @Test(testName = "AS-4 Check that the entered data is displayed correctly on the Trip Detail Page", retryAnalyzer = Retry.class)
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
     * AS-9 according to the test-cases specification
     * This test checks the possibility of changing flight to another
     */
    @Link(value = "AS-9 Test-case Link", url = "https://docs.google.com/document/d/1nCM4rGxKGTkTgmzOHvTp39juojYjvtuo7xIoABjV2fo/edit#heading=h.hylcpt1td46y")
    @Test(testName = "AS-9 Check the possibility of changing flight to another", retryAnalyzer = Retry.class)
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
