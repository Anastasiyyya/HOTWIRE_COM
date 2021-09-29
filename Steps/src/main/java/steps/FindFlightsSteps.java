package steps;

import entities.Flight;
import entities.FlightSearch;
import pages.TripDetailPage;

import java.util.List;
import java.util.Objects;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.switchTo;

public class FindFlightsSteps extends BaseSteps {

    /**
     * This step finds a flight using Base page form
     * @param flightSearch
     * @return List<Flight>
     */
    public FindFlightsSteps findRoundTripFlightFromBasePage(FlightSearch flightSearch) {

        basePage.openPage();
        basePage.getBasePageForm()
                .chooseOptionFlights()
                .chooseFlightType(flightSearch.getFlightType())
                .chooseDirectionFrom(flightSearch.getAirportFrom())
                .chooseDirectionTo(flightSearch.getAirportTo());
        basePage.getBasePageForm().getDatepicker()
                .chooseRoundTripDates(flightSearch.getDepartingYear(), flightSearch.getDepartingMonth(), flightSearch.getDepartingDay(),
                        flightSearch.getReturningYear(), flightSearch.getReturningMonth(), flightSearch.getReturningDay());
        basePage.getBasePageForm().getPassengersInput()
                .choosePassengersCount(flightSearch.getPassenger().getChildrenPassengersCount(), flightSearch.getPassenger().getChildPassenger());
        return this;
    }

    public FindFlightsSteps clickDoneButtonOnPassengersWindow()  {
        basePage.getBasePageForm().getPassengersInput()
                .clickDoneButton();
        return this;
    }

    public FindFlightsSteps goToFlightSearchPage()  {
        basePage.getBasePageForm()
                .clickFindAFlightButton()
                .waitFlightsLoaded();
        return this;
    }

    public FindFlightsSteps chooseDepartingFlight() {
        basePage.getFlightsSearchPage()
                .waitFlightsLoaded()
                .chooseDepartingFlight(1)
                .waitFlightsLoaded();
        return this;
    }

    public FindFlightsSteps chooseReturningFlight() {
        basePage.getFlightsSearchPage()
                .waitFlightsLoaded()
                .chooseReturningFlight(1);
        return this;
    }

    public FindFlightsSteps waitUntilRulesButtonUnvisible(){
        basePage.getFlightsSearchPage().waitUntilRulesButtonUnvisible(1);
        return this;
    }

    public TripDetailPage goToTripDetailPage() {

        switchTo().window("Trip Detail | Hotwire");
        basePage.getFlightsSearchPage().getTripDetailPage()
                .clickShowDepartingDetails()
                .clickShowReturningDetails();
        return new TripDetailPage();
    }

    public FindFlightsSteps changeFlightToAnother()  {
        basePage.getFlightsSearchPage().getTripDetailPage()
                .clickChangeFlights();
        return this;
    }

    public boolean isDirectionCorrect(String directionFrom, String directionTo) {
        for (int i = 0; i < basePage.getFlightsSearchPage().getTripDetailPage().getFlights().size(); i++) {
            if (!basePage.getFlightsSearchPage().getTripDetailPage().getLeavingFrom().get(i).getText().split(" ")[0].equals(directionFrom)
            || !basePage.getFlightsSearchPage().getTripDetailPage().getGoingTo().get(i).getText().split(" ")[0].equals(directionTo)) {
                return false;
            }
        }
        return true;
    }

    public boolean isAirlineForTheFlightToChanged(String airlineName) {
        if (!basePage.getFlightsSearchPage().getTripDetailPage().getAirline().get(0).getText().equals(airlineName)) {
                return false;
            }
            return true;
    }

    public boolean isAirlineEqualToSelected(String selectedAirlineName) {
        System.out.println(basePage.getFlightsSearchPage().getAirlineInTheInfoForm().getText());
        if (!basePage.getFlightsSearchPage().getAirlineInTheInfoForm().getText().equals(selectedAirlineName)) {
            return false;
        }
        return true;
    }

    public boolean isDirectionEqualToSelected(String selectedDirection) {
        System.out.println(basePage.getFlightsSearchPage().getDirectionFromInTheInfoForm().getText() + " "
                + basePage.getFlightsSearchPage().getDirectionToInTheInfoForm().getText());
        if (!(basePage.getFlightsSearchPage().getDirectionFromInTheInfoForm().getText() + " "
                + basePage.getFlightsSearchPage().getDirectionToInTheInfoForm().getText()).equals(selectedDirection)) {
            return false;
        }
        return true;
    }

    public boolean isFlightTypeEqualToSelected(String selectedFlightType) {
        System.out.println(basePage.getFlightsSearchPage().getFlightTypeInTheInfoForm().getText());
        if (!basePage.getFlightsSearchPage().getFlightTypeInTheInfoForm().getText().equals(selectedFlightType)) {
            return false;
        }
        return true;
    }

    /**
     * This step finds a flight using Flight page form
     * @param flightSearch
     * @return List<Flight>
     */
    public FindFlightsSteps findRoundTripFlightFromFlightPage(FlightSearch flightSearch) {

        basePage.openPage();
        basePage.getHeaderPage().clickFlightButton();
        basePage.getFlightsPageForm().chooseDirectionFrom(flightSearch.getAirportFrom());
        basePage.getFlightsPageForm().chooseDirectionTo(flightSearch.getAirportTo());
        basePage.getFlightsPageForm().getDatepicker()
                .chooseRoundTripDates(flightSearch.getDepartingYear(), flightSearch.getDepartingMonth(), flightSearch.getDepartingDay(),
                        flightSearch.getReturningYear(), flightSearch.getReturningMonth(), flightSearch.getReturningDay());
        basePage.getFlightsPageForm().getDatepicker().getDoneButton().click();
        basePage.getFlightsPageForm().getPassengersInput()
                .choosePassengersCount(flightSearch.getPassenger().getChildrenPassengersCount(), flightSearch.getPassenger().getChildPassenger())
                .clickDoneButton()
                .waitUntilPassengersWindowClosed();
        basePage.getFlightsPageForm()
                .clickFindAFlightButton()
                .waitFlightsLoaded();
        return this;
    }

    /**
     * This step finds a one-way flight
     * @param flightSearch
     * @return List<Flight>
     */
    public FindFlightsSteps fillOneWayTripFlightWithData(FlightSearch flightSearch) {

        basePage.openPage();
        basePage.getBasePageForm()
                .chooseOptionFlights()
                .chooseFlightType(flightSearch.getFlightType())
                .chooseDirectionFrom(flightSearch.getAirportFrom())
                .chooseDirectionTo(flightSearch.getAirportTo());
        basePage.getBasePageForm().getDatepicker()
                .chooseOneWayTripDate(flightSearch.getDepartingYear(), flightSearch.getDepartingMonth(), flightSearch.getDepartingDay());
        basePage.getBasePageForm().getPassengersInput()
                .choosePassengersCount(flightSearch.getPassenger().getChildrenPassengersCount(), flightSearch.getPassenger().getChildPassenger());
        return this;
    }

    public int receiveGeneralPassengersCountFromBasePage(FlightSearch flightSearch) {
        int adultPassengerCount = basePage.getBasePageForm().getPassengersInput().receiveExistPassengersCountFromPage(flightSearch.getPassenger().getAdultPassenger());
        int childrenPassengerCount = basePage.getBasePageForm().getPassengersInput().receiveExistPassengersCountFromPage(flightSearch.getPassenger().getChildPassenger());
        int generalCountFromBasePage = adultPassengerCount + childrenPassengerCount;
        basePage.getBasePageForm().getPassengersInput()
                .clickDoneButton();
        return generalCountFromBasePage;
    }

    public String flightDirection() {
        System.out.println("*" + basePage.getFlightsSearchPage().getFlightForms().getAirportFrom().get(0).getText() + " " +
                basePage.getFlightsSearchPage().getFlightForms().getAirportTo().get(0).getText());
        return basePage.getFlightsSearchPage().getFlightForms().getAirportFrom().get(0).getText() + " " +
                    basePage.getFlightsSearchPage().getFlightForms().getAirportTo().get(0).getText();
    }

    public String flightAirline() {
        System.out.println("*" + basePage.getFlightsSearchPage().getFlightForms().getAirlineName().get(0).getText());
        return basePage.getFlightsSearchPage().getFlightForms().getAirlineName().get(0).getText();
    }

    public String flightType() {
        System.out.println("*" + basePage.getFlightsSearchPage().getFlightForms().getFlightType().get(0).getText());
        return basePage.getFlightsSearchPage().getFlightForms().getNonstop().get(0).getText();
    }

    public FindFlightsSteps selectFilter(String filter) {
        basePage.getFlightsSearchPage()
                .selectFilter(filter);
        return this;
    }

    public FindFlightsSteps selectSearchingOptions(FlightSearch flightSearch) {

        basePage.getFlightsSearchPage()
                .selectRadioButtonOneWay()
                .clickShowOptionsButton()
                .chooseAdultsCount(flightSearch.getPassenger().getAdultPassengersCount())
                .chooseChildrenCountAndAge(flightSearch.getPassenger().getChildrenPassengersCount())
                .chooseAirlineByName(flightSearch.getAirlineName())
                .chooseSeatingClassByName(flightSearch.getSeatingClass())
                .selectNonStopCheckbox()
                .clickSearchButton();
        return this;
    }

    /**
     * This gets finds flights searching results list
     */
    public FindFlightsSteps findSearchingResultsList(String location) {
        basePage.openPage();
        basePage.getBasePageForm()
                .chooseOptionFlights()
                .getOneWayTripButton().click();
        basePage.getBasePageForm()
                .writeDirection("Fly from", location);
        basePage.getBasePageForm().waitForSearchingResultsVisible();
        makeUpSearchingResultsList();
        return this;
    }

    public boolean isTheEnteredDataInTheSearchResults(String result){
        for (int i = 0; i < makeUpSearchingResultsList().size(); i++) {
            if (!makeUpSearchingResultsList().get(i).contains(result)) {
                return false;
            }
        }
        return true;
    }

    public boolean isTripTypeOneWay() {
        for (int i = 0; i < basePage.getFlightsSearchPage().getFlightForms().getFlights().size(); i++) {
            if (!basePage.getFlightsSearchPage().getFlightForms().getFlightType().get(i).getText().equals("one way")) {
                return false;
            }
        }
        return true;
    }

    public boolean isTripNonstop() {
        for (int i = 0; i < basePage.getFlightsSearchPage().getFlightForms().getFlights().size(); i++) {
            if (!basePage.getFlightsSearchPage().getFlightForms().getNonstop().get(i).getText().trim().equals("(Nonstop)")) {
                return false;
            }
        }
        return true;
    }

    public boolean isFlyFromToDirectionCorrect(List<String> list){
        for (int i = 0; i < basePage.getFlightsSearchPage().getFlightForms().getFlights().size(); i++) {
            String direction = basePage.getFlightsSearchPage().getFlightForms().getAirportFrom().get(i).getText() + " " +
                    basePage.getFlightsSearchPage().getFlightForms().getAirportTo().get(i).getText();
            if (!list.contains(direction)) {
                return false;
            }
        }
        return true;
    }

    public boolean isAirlineCorrect(String airlineName) {
        for (int i = 0; i < basePage.getFlightsSearchPage().getFlightForms().getFlights().size(); i++) {
            if (!basePage.getFlightsSearchPage().getFlightForms().getAirlineName().get(i).getText().trim().equals(airlineName)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPassengersCountCorrect(int generalCountFromBasePage) {
        boolean result;
        int generalCount = basePage.getFlightsSearchPage().checkGeneralPassengersCount();
        if (generalCount == generalCountFromBasePage) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }
}
