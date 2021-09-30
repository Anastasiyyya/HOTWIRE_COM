package tests;

import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.objects.Objects;

public class PricesTests extends BaseTest {

    /**
     * AS-8 according to the test-cases specification
     * https://docs.google.com/document/d/1nCM4rGxKGTkTgmzOHvTp39juojYjvtuo7xIoABjV2fo/edit?usp=sharing
     * This test checks if the total price of selected flight (for Round-trip)
     * in the 'Flight Search' pages and Total price in the Trip Detail page are the same
     */
    @Test(description = "Check total price")
    public void checkTotalPrice() {

        findFlightSteps
                .findRoundTripFlightFromBasePage(Objects.FLIGHT_SEARCH_ROUND_TRIP)
                .clickDoneButtonOnPassengersWindow()
                .goToFlightSearchPage();

        Double totalPriceFromSearchDepartingFlightPage = findFlightSteps.getSearchedFlightPrice();
        findFlightSteps.chooseDepartingFlight();

        Double totalPriceFromSearchReturningFlightPage = findFlightSteps.getAdditionallyPrice();
        findFlightSteps.chooseReturningFlight();

        findFlightSteps.goToTripDetailPage();

        Assert.assertTrue(findFlightSteps.isPriceOnTripDetailCorrectForRoundTrip(totalPriceFromSearchDepartingFlightPage,totalPriceFromSearchReturningFlightPage));
    }

    /**
     * AS-10 according to the test-cases specification
     * https://docs.google.com/document/d/1nCM4rGxKGTkTgmzOHvTp39juojYjvtuo7xIoABjV2fo/edit?usp=sharing
     * This test checks that when Trip total price was changed in the section
     * 'Select your fare' then Trip total price will change in the section  Trip Summary
     */
    @Test(description = "Check total price")
    public void changeFlightPrice() {

        String FlightType = "Economy Classic";

        findFlightSteps
                .fillOneWayTripFlightWithData(Objects.FLIGHT_SEARCH_ONE_WAY)
                .clickDoneButtonOnPassengersWindow()
                .goToFlightSearchPage();

        findFlightSteps
                .chooseDepartingFlight()
                .closeWindowAndGoToTripDetailPage()
                .changeFlightPrice(FlightType);
        Selenide.sleep(10000);
        Assert.assertTrue(findFlightSteps.isTotalPriceChangedAfterChangingFlightType(FlightType));

    }
}
