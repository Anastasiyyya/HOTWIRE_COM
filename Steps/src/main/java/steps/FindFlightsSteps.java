package steps;

import entities.Airport;
import entities.Flight;
import entities.FlightSearch;
import entities.Location;
import org.apache.logging.log4j.core.util.Assert;
import pages.FlightsSearchPage;

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
    public FlightsSearchPage findOneWayTripFlight(FlightSearch flightSearch) {

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
        basePage.getBasePageForm().getPassengersInput()
                .waitUntilChooseButtonVisible()
                .clickPassengerCountButton();
        int adultPassengerCount = basePage.getBasePageForm().getPassengersInput().checkExistPassengersCount(flightSearch.getPassenger().getAdultPassenger());
        int childrenPassengerCount = basePage.getBasePageForm().getPassengersInput().checkExistPassengersCount(flightSearch.getPassenger().getChildPassenger());
        basePage.basePageForm.clickFindAFlightButton()
                .waitFlightsLoaded();
        assertPassengers(adultPassengerCount, childrenPassengerCount);
        basePage.getFlightsSearchPage().selectFilter("Nonstop");
        return new FlightsSearchPage();
    }

    /**
     * This gets finds flights searching results list
     */
    public List<String> findSearchingResultsList(Location location) {

        basePage.openPage()
                .waitForPageLoaded();
        basePage.getBasePageForm()
                .chooseOptionFlights()
                .getOneWayTripButton().click();
        basePage.getBasePageForm()
                .writeDirection("Fly from", location.getCity())
                .waitForPageLoaded();
        assertionForSearchingResults(location.getCity());
        return makeUpSearchingResultsList();
    }

    public boolean assertionForSearchingResults(String result){
        boolean compare = true;
        for (int i = 0; i < makeUpSearchingResultsList().size(); i++) {
            if (!makeUpSearchingResultsList().get(i).contains(result)) {
                compare = false;
                break;
            }
        }
        return compare;
    }

    public boolean assertTripType() {
        boolean result = true;
        for (int i = 0; i < basePage.getFlightsSearchPage().getFlightForms().getFlights().size(); i++) {
            if (!basePage.getFlightsSearchPage().getFlightForms().getFlightType().get(i).getText().equals("one way")) {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean assertFlyFromTo(){
        boolean result = true;
        for (int i = 0; i < basePage.getFlightsSearchPage().getFlightForms().getFlights().size(); i++) {
            String direction = basePage.getFlightsSearchPage().getFlightForms().getAirportFrom().get(i).getText() + " " +
                    basePage.getFlightsSearchPage().getFlightForms().getAirportTo().get(i).getText();
            if (!(direction.equals("MSQ - VKO") || direction.equals("MSQ - DME") || direction.equals("MSQ - SVO"))) {
                result = false;
                break;
            }
        }
        return result;
    }


    public boolean assertPassengers(int adultsCount, int childrenCount) {
        boolean result;
        int generalCount = basePage.getFlightsSearchPage().checkGeneralPassengersCount();
        if (generalCount == adultsCount + childrenCount) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }
}
