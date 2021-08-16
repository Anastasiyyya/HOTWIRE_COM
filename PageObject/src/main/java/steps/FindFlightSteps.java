package steps;

import elements.BasePassengerInput;
import pages.BasePage;
import elements.BasePageDatePicker;
import pages.BasePageForm;

public class FindFlightSteps {

    BasePage basePage =  new BasePage();
    BasePageForm basePageForm = new BasePageForm();
    BasePageDatePicker basePageDatePicker = new BasePageDatePicker();
    BasePassengerInput basePassengerInput = new BasePassengerInput();

    public FindFlightSteps chooseFlightType(String flightType) {

        basePage.openPage()
                .waitForPageLoaded();
        basePageForm
                .selectRoundTrip();
        return this;
    }

    public FindFlightSteps chooseDirection(String option, String directionFrom, String directionTo,
                                               String originCity, String destinationCity) {
        basePage.openPage();
        basePageForm
                .chooseOptionFlights()
                .chooseDirection(directionFrom,originCity)
                .chooseDirection(directionTo,destinationCity);
        return this;
    }

    public FindFlightSteps chooseDate(String departingYear, String departingMonth, String departingDay,
                                      String returningYear,String returningMonth,String returningDay) {
        basePageDatePicker
                .chooseDate(departingYear,departingMonth, departingDay)
                .clickChooseDateButton()
                .chooseDate(returningYear,returningMonth, returningDay);
        return this;
    }

    public FindFlightSteps choosePassengersCount(int passengerCount, String passengerType) {
        basePassengerInput
                .choosePassengersCount(passengerCount, passengerType);
        return this;
    }
}
