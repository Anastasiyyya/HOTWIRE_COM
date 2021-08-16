package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.switchTo;

public class ShowFlightInfoTest extends BaseTest {
    /**
     * This test checks if the TripDetailPage opened and the button 'ContinueBooking' displayed
     * @throws InterruptedException
     */
    @Test(description = "Shows flight's info")
    public void findAFlightTest() throws InterruptedException {

        basePage.openPage();
        basePageForm
                .chooseOptionFlights()
                .chooseDirection("Fly from","Minsk, Belarus (MSQ)")
                .chooseDirection("Fly to","Moscow, Russia (MOW)");
        Thread.sleep(5000);
        basePageDatePicker
                .clickChooseDateButton()
                .chooseDate("2021","September", "8")
                .chooseDate("2021","October", "20");
        basePageForm.clickFindAFlightButton();
        flightsSearchPage
                .clickButton(flightsSearchPage.getShowOptionsButton())
                .chooseAdultsCount(2)
                .chooseChildrenCount(2)
                .chooseChildAge(1,15)
                .chooseChildAge(2, 16)
                .chooseAirline(2)
                .chooseSeatingClass(1)
                .selectCheckbox(NONSTOP_FLIGHT_CHECKBOX_XPATH)
                .selectTripType("ONE_WAY")
                .clickSearchButton()
                .chooseDepartingFlight(1)
                .chooseReturningFlight(1);
                switchTo().window(1);
        Assert.assertEquals(tripDetailPage.getHeaderText(),"Review your trip");
        Assert.assertTrue(tripDetailPage.isButtonContinueBookingDisplayed());
    }
}
