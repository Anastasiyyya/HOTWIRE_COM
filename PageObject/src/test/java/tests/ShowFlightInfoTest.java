package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FlightsSearchPage;
import static com.codeborne.selenide.Selenide.switchTo;
import static pages.FlightsSearchPage.NONSTOP_FLIGHT_CHECKBOX_XPATH;

public class ShowFlightInfoTest extends BaseTest {
    /**
     * This test checks if the TripDetailPage opened and the button 'ContinueBooking' displayed
     * @throws InterruptedException
     */
    @Test(description = "Shows flight's info")
    public void findAFlightTest() throws InterruptedException {

        basePage.openPage()
                .chooseOption("Flights")
                .chooseDirection("Fly from","Minsk, Belarus (MSQ)")
                .chooseDirection("Fly to","Moscow, Russia (MOW)");
        Thread.sleep(5000);
        datePicker
                .clickChooseDateButton(1)
                .chooseDepartingDate("2021","September", "8")
                .chooseReturningDate("2021","October", "20");
        flightsSearchPage
                .clickFindAFlightButton()
                .clickButton(FlightsSearchPage.SHOW_OPTIONS_BUTTON_XPATH)
                .chooseAdultsCount(2)
                .chooseChildrenCount(2)
                .chooseChildAge(1,15)
                .chooseChildAge(2, 16)
                .chooseAirline(2)
                .chooseSeatingClass(1)
                .selectCheckbox(NONSTOP_FLIGHT_CHECKBOX_XPATH)
                .selectTripType("ONE_WAY")
                .chooseDepartingFlight(1)
                .chooseReturningFlight(1);
                switchTo().window(1);
        Assert.assertEquals(tripDetailPage.getHeaderText(),"Review your trip");
        Assert.assertTrue(tripDetailPage.isButtonContinueBookingDisplayed());
    }
}
