package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.$;

public class FindFlightSearchTest extends BaseTest {

    /**
     * This test checks if is it possible to find a flight showing the list of flights
     */
    @Test(description = "Find a round-trip flight")
    public void findARoundTripFlightTest() throws InterruptedException {
        basePage.openPage();
        basePageForm
                .chooseOptionFlights();
        basePageForm
                .chooseDirectionFrom("Minsk, Belarus (MSQ)")
                .chooseDirectionTo("Moscow, Russia (MOW)");
        Thread.sleep(5000);
        basePageDatePicker
                .chooseDate("2021","August", "15",
                        "2021","December", "10");
        basePassengerInput
                .choosePassengersCount(2, "adults");
        basePageForm.clickFindAFlightButton();
        Assert.assertTrue($("#flightModuleList").isDisplayed());
    }

    @Test(description = "Find a one-way flight")
    public void findAOneWayFlightTest() throws InterruptedException {
        basePage.openPage();
        basePageForm
                .chooseOptionFlights()
                .chooseDirectionFrom("Minsk, Belarus (MSQ)")
                .chooseDirectionTo("Moscow, Russia (MOW)")
                .chooseFlightType("One-way");
        Thread.sleep(5000);
        basePageDatePicker
                .chooseOneWayTripDate("2021","August", "15");
        basePassengerInput
                .choosePassengersCount(2, "adults");
        basePageForm.clickFindAFlightButton();
        Assert.assertTrue($("#flightModuleList").isDisplayed());
    }
}
