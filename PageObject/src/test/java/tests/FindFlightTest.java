package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.$;

public class FindFlightTest extends BaseTest {

    /**
     * This test checks if is it possible to find a flight showing the list of flights
     */
    @Test(description = "Find a round-trip flight")
    public void findARoundTripFlightTest() throws InterruptedException {
        basePage.openPage();
        basePageForm
                .chooseOptionFlights();
        basePageForm
                .chooseDirection("Fly from","Minsk, Belarus (MSQ)")
                .chooseDirection("Fly to","Moscow, Russia (MOW)");
        Thread.sleep(5000);
        basePageDatePicker
                .chooseDate("2021","August", "15")
                .clickChooseDateButton()
                .chooseDate("2021","December", "10");
        passengersInput
                .choosePassengersCount(2, "adults"); //max count - 5
        basePageForm.clickFindAFlightButton();
        Assert.assertTrue($("#flightModuleList").isDisplayed());
    }

    /**
     *
     * @throws InterruptedException
     */
    @Test(description = "Find a one-way flight")
    public void findAOneWayFlightTest() throws InterruptedException {
        basePage.openPage();
        basePageForm
                .chooseOptionFlights()
                .chooseDirection("Fly from","Minsk, Belarus (MSQ)")
                .chooseDirection("Fly to","Moscow, Russia (MOW)")
                .selectOneWayTrip();
        Thread.sleep(5000);
        basePageDatePicker
                .chooseDate("2021","August", "15");
        passengersInput
                .choosePassengersCount(2, "adults");
        basePageForm.clickFindAFlightButton();
        Assert.assertTrue($("#flightModuleList").isDisplayed());
    }
}
