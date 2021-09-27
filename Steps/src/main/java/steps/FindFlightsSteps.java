package steps;

import entities.Flight;
import entities.FlightSearch;
import entities.Location;

import java.util.List;

public class FindFlightsSteps extends BaseSteps {

    /**
     * This step finds a flight
     * @param flightSearch
     * @return List<Flight>
     */
    public List<Flight> findRoundTripFlight(FlightSearch flightSearch) {

        basePage.openPage()
                .waitForPageLoaded();
        basePage.getBasePageForm()
                .chooseOptionFlights()
                .chooseFlightType(flightSearch.getFlightType())
                .chooseDirectionFrom(flightSearch.getAirportFrom().getCity())
                .chooseDirectionTo(flightSearch.getAirportTo().getCity());
        basePage.getBasePageForm().getDatepicker()
                .chooseRoundTripDates(flightSearch.getDepartingYear(), flightSearch.getDepartingMonth(), flightSearch.getDepartingDay(),
                        flightSearch.getReturningYear(), flightSearch.getReturningMonth(), flightSearch.getReturningDay());
        basePage.getBasePageForm().getPassengersInput()
                .choosePassengersCount(flightSearch.getPassenger().getAdultPassengersCount(), flightSearch.getPassenger().getAdultPassenger())
                .waitUntilChooseButtonVisible()
                .choosePassengersCount(flightSearch.getPassenger().getChildrenPassengersCount(), flightSearch.getPassenger().getChildPassenger());
        basePage.basePageForm.clickFindAFlightButton()
                .waitFlightsLoaded();

        return makeUpFlightsList();
    }

    /**
     * This step finds a one-way flight
     * @param flightSearch
     * @return List<Flight>
     */
    public FindFlightsSteps fillOneWayTripFlightWithData(FlightSearch flightSearch) {

        basePage.openPage()
                .waitForPageLoaded();
        basePage.getBasePageForm()
                .chooseOptionFlights()
                .chooseFlightType(flightSearch.getFlightType())
                .chooseDirectionFrom(flightSearch.getAirportFrom().getCity())
                .chooseDirectionTo(flightSearch.getAirportTo().getCity());
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

    public FindFlightsSteps goToFlightSearchPageAndSelectFilter() {
        basePage.getBasePageForm()
                .clickFindAFlightButton()
                .waitFlightsLoaded();
        basePage.getFlightsSearchPage().selectFilter("Nonstop");
        return this;
    }

    /**
     * This gets finds flights searching results list
     */
    public FindFlightsSteps findSearchingResultsList(String location) {
        basePage.openPage()
                .waitForPageLoaded();
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

    public boolean isFlyFromToDirectionCorrect(){
        for (int i = 0; i < basePage.getFlightsSearchPage().getFlightForms().getFlights().size(); i++) {
            String direction = basePage.getFlightsSearchPage().getFlightForms().getAirportFrom().get(i).getText() + " " +
                    basePage.getFlightsSearchPage().getFlightForms().getAirportTo().get(i).getText();
            if (!(direction.equals("MSQ - VKO") || direction.equals("MSQ - DME") || direction.equals("MSQ - SVO"))) {
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
