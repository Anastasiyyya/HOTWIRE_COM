package steps;

import entities.Airport;
import entities.Flight;
import entities.FlightSearch;
import entities.Location;
import org.apache.logging.log4j.core.util.Assert;

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
    public List<Flight> findOneWayTripFlight(FlightSearch flightSearch) {

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
        basePage.basePageForm.clickFindAFlightButton()
                .waitFlightsLoaded();
        System.out.println(makeUpFlightsList().toString());
        return makeUpFlightsList();
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
        for (int i = 0; i < makeUpSearchingResultsList().size(); i++) {
            makeUpSearchingResultsList().get(i).contains(result);
        }
        return true;
    }

    public boolean assertTripType(){
        boolean result = true;
        for (int i = 0; i < makeUpSearchingResultsList().size(); i++) {
            if (basePage.getFlightsSearchPage().getFlightForms().getFlightType().get(i).getText().equals("one way")) {
                result = true;
            }
            else result = false;
        }
        return result;
    }

    public boolean assertFlyFromTo(){
        boolean result = true;
        for (int i = 0; i < makeUpSearchingResultsList().size(); i++) {
            String direction = basePage.getFlightsSearchPage().getFlightForms().getAirportFrom().get(i).getText() + " " +
                    basePage.getFlightsSearchPage().getFlightForms().getAirportTo().get(i).getText();
            if (direction.equals("MSQ - VKO") || direction.equals("MSQ - DME") || direction.equals("MSQ - SVO")) {
                result = true;
            }
            else result = false;
        }
        return result;
    }

    public int getChildrenCount(FlightSearch flightSearch) {
        return basePage.getBasePageForm().getPassengersInput().checkExistPassengersCount(flightSearch.getPassenger().getChildPassenger());
    }

    public int getAdultsCount(FlightSearch flightSearch) {
        return basePage.getBasePageForm().getPassengersInput().checkExistPassengersCount(flightSearch.getPassenger().getAdultPassenger());
    }

    public int getGeneralPassengersCount(FlightSearch flightSearch) {
        return basePage.getFlightsSearchPage().checkGeneralPassengersCount();
    }
}
