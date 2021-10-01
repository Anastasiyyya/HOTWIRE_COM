package tests;

import io.qameta.allure.Link;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.objects.Objects;
import java.util.List;

public class FilterTests extends BaseTest {

    /**
     * AS-5 according to the test-cases specification
     * This test check that flights sorted by price when dropdown option was selected
     */
    @Link(value = "AS-5 Test-case Link", url = "https://docs.google.com/document/d/1nCM4rGxKGTkTgmzOHvTp39juojYjvtuo7xIoABjV2fo/edit#heading=h.tplb3iatmpft")
    @Test(testName = "AS-5 Filter flights by price test")
    public void filterFlightsByPrice() {

        String sortByHighestPrice = "Price (Highest)";

        findFlightSteps
                .findRoundTripFlightFromBasePage(Objects.FLIGHT_SEARCH_ROUND_TRIP)
                .clickDoneButtonOnPassengersWindow()
                .goToFlightSearchPage();

        List<Double> priceListBeforeSorting = findFlightSteps.getPriceListFromSearchingPage();
        findFlightSteps.chooseSortDropdownOptions(sortByHighestPrice);
        List<Double> priceListAfterSorting = findFlightSteps.getPriceListFromSearchingPage();

        Assert.assertTrue(findFlightSteps.isPriceListsTheSame(priceListBeforeSorting, priceListAfterSorting));
        Assert.assertTrue(findFlightSteps.isPriceListSortedByHighest(priceListAfterSorting));
    }

    /**
     * AS-6 according to the test-cases specification
     * This test check that flights sorted by airport when special checkbox option was selected
     */
    @Link(value = "AS-6 Test-case Link", url = "https://docs.google.com/document/d/1nCM4rGxKGTkTgmzOHvTp39juojYjvtuo7xIoABjV2fo/edit#heading=h.8gk61c2tp4mc")
    @Test(testName = "AS-6 Filter flights by airport test")
    public void filterFlightsByAirport() {

        String Nonstop = "Nonstop";
        String Airport = "SVO";

        findFlightSteps
                .findRoundTripFlightFromBasePage(Objects.FLIGHT_SEARCH_ROUND_TRIP)
                .clickDoneButtonOnPassengersWindow()
                .goToFlightSearchPage()
                .selectFilter(Nonstop)
                .selectFilter(Airport);

        Assert.assertTrue(findFlightSteps.isFlightsSortedByAirportsCorrectly(Airport));
    }

    /**
     * AS-7 according to the test-cases specification
     * This test check that flights sorted by airline when checkbox special select
     */
    @Link(value = "AS-7 Test-case Link",url = "https://docs.google.com/document/d/1nCM4rGxKGTkTgmzOHvTp39juojYjvtuo7xIoABjV2fo/edit#heading=h.6mdb8zjbej8l")
    @Test(testName = "AS-7 Filter flights by airline test")
    public void filterFlightsByAirline() {

        String Airline = "Belavia";

        findFlightSteps
                .findRoundTripFlightFromBasePage(Objects.FLIGHT_SEARCH_ROUND_TRIP)
                .clickDoneButtonOnPassengersWindow()
                .goToFlightSearchPage()
                .selectFilter(Airline);

        Assert.assertTrue(findFlightSteps.isAirlineCorrect(Airline));
    }
}
