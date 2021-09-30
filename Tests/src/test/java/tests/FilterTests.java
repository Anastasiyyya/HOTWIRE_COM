package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.objects.Objects;
import java.util.List;

public class FilterTests extends BaseTest {

    /**
     * AS-5 according to the test-cases specification
     * https://docs.google.com/document/d/1nCM4rGxKGTkTgmzOHvTp39juojYjvtuo7xIoABjV2fo/edit?usp=sharing
     * This test check that flights sorted by price when dropdown option was selected
     */
    @Test(description = "Check that flights sorted by price when dropdown option was selected")
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
     * https://docs.google.com/document/d/1nCM4rGxKGTkTgmzOHvTp39juojYjvtuo7xIoABjV2fo/edit?usp=sharing
     * This test check that flights sorted by airport when special checkbox option was selected
     */
    @Test(description = "Check that flights sorted by airport when special checkbox option was selected")
    public void filterFlightsByAirport() {

        String Nonstop = "Nonstop";
        String Airport = "SVO";

        findFlightSteps
                .findRoundTripFlightFromBasePage(Objects.FLIGHT_SEARCH_ROUND_TRIP)
                .clickDoneButtonOnPassengersWindow()
                .goToFlightSearchPage()
                .selectFilter(Nonstop)
                .selectFilter(Airport);
        List<String> ArrivalAirportList = findFlightSteps.getArrivalAirportsList();
        System.out.println(ArrivalAirportList.toString());
        //объединить методы
        Assert.assertTrue(findFlightSteps.isFlightsSortedByAirportsCorrectly(ArrivalAirportList));
    }

    /**
     * AS-7 according to the test-cases specification
     * https://docs.google.com/document/d/1nCM4rGxKGTkTgmzOHvTp39juojYjvtuo7xIoABjV2fo/edit?usp=sharing
     * This test check that flights sorted by airline when checkbox special select
     */
    @Test(description = "Check that flights sorted by airport when special checkbox option was selected")
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
