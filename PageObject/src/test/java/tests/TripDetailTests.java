package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FlightsSearchPage;
import static com.codeborne.selenide.Selenide.switchTo;
import static pages.FlightsSearchPage.NONSTOP_FLIGHT_CHECKBOX_XPATH;

public class TripDetailTests extends BaseTest{

    /**
     *This test checks if the correct direction is displayed on the trie detail information page
     */
    @Test(description = "Check the correct direction")
    public void checkingTheCorrectDirection() throws InterruptedException {
        basePage.openPage()
                .chooseOption("Flights")
                .chooseDirection("Fly from","Minsk, Belarus (MSQ)")
                .chooseDirection("Fly to","Moscow, Russia (MOW)")
                .chooseFlightType("Round-trip");
        Thread.sleep(5000);
        datePicker
                .chooseDepartingDate("2021","August", "15")
                .chooseReturningDate("2021","December", "8");
        passengersInput
                .choosePassengersCount(2, "adults");
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
        Assert.assertEquals(tripDetailPage.getDirectionTextXpathText(),"Minsk (MSQ)");
    }

    /*    *//**
     * This test checks if the total price is right
     *//*
    @Test(description = "Checks total price")
    public void checkTotalPrice() throws InterruptedException {
        basePage.openPage()
                .chooseOption("Flights")
                .chooseDirection("Fly from","Minsk, Belarus (MSQ)")
                .chooseDirection("Fly to","Moscow, Russia (MOW)");
        datePicker
                .chooseDepartingDate("2021","September", "8")
                .clickChooseDateButton(1)
                .chooseReturningDate("2021","December", "8");
        flightsSearchPage
                .clickFindAFlightButton()
                .clickButton(FlightsSearchPage.SHOW_OPTIONS_BUTTON_XPATH)
                .chooseAdultsCount(2)
                .chooseChildrenCount(2)
                .chooseChildAge(1,15)
                .chooseChildAge(2, 16)
                .chooseAirline(2)
                .chooseSeatingClass(1)
                .selectCheckbox(NONSTOP_FLIGHT_CHECKBOX_XPATH);
        double totalPrice = flightsSearchPage.checkTotalPrice(0);
        flightsSearchPage.chooseDepartingFlight(1);
        double additionallyPrice = flightsSearchPage.checkAdditionallyPrice(0);
        flightsSearchPage.chooseReturningFlight(1);
        double price = totalPrice + additionallyPrice;
        switchTo().window(1);
        Assert.assertEquals(tripDetailPage.returnTotalPrice(), price);
    }*/
}
