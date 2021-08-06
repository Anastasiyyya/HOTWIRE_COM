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
        basePage.openPage()
                .chooseOption("Flights")
                .chooseDirection("Fly from","Minsk, Belarus (MSQ)")
                .chooseDirection("Fly to","Moscow, Russia (MOW)");
        Thread.sleep(5000);
        datePicker
                .chooseDepartingDate("2021","August", "15")
                .clickChooseDateButton(1)
                .chooseReturningDate("2021","December", "10");
        passengersInput
                .choosePassengersCount(2, "adults"); //max count - 5
        basePage.clickFindAFlightButton();
        Assert.assertTrue($("#flightModuleList").isDisplayed());
    }

    /**
     *
     * @throws InterruptedException
     */
    @Test(description = "Find a one-way flight")
    public void findAOneWayFlightTest() throws InterruptedException {
        basePage.openPage()
                .chooseOption("Flights")
                .chooseDirection("Fly from","Minsk, Belarus (MSQ)")
                .chooseDirection("Fly to","Moscow, Russia (MOW)")
                .chooseFlightType("One-way");
        Thread.sleep(5000);
        datePicker
                .chooseDepartingDate("2021","August", "15");
        passengersInput
                .choosePassengersCount(2, "adults");
        basePage.clickFindAFlightButton();
        Assert.assertTrue($("#flightModuleList").isDisplayed());
    }
}
