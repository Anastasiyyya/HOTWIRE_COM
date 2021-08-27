package steps;

import entities.Flight;
import entities.FlightSearch;
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
                .chooseDirectionFrom(flightSearch.getAirportFrom().makeUpLocation())
                .chooseDirectionTo(flightSearch.getAirportTo().makeUpLocation());
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
                .chooseDirectionFrom(flightSearch.getAirportFrom().makeUpLocation())
                .chooseDirectionTo(flightSearch.getAirportTo().makeUpLocation());
        basePage.getBasePageForm().getDatepicker()
                .chooseOneWayTripDate(flightSearch.getDepartingYear(), flightSearch.getDepartingMonth(), flightSearch.getDepartingDay());
        basePage.getBasePageForm().getPassengersInput()
                .choosePassengersCount(flightSearch.getPassenger().getAdultPassengersCount(), flightSearch.getPassenger().getAdultPassenger())
                .waitUntilChooseButtonVisible()
                .choosePassengersCount(flightSearch.getPassenger().getChildrenPassengersCount(), flightSearch.getPassenger().getChildPassenger());
        basePage.basePageForm.clickFindAFlightButton()
                .waitFlightsLoaded();
        return makeUpFlightsList();
    }
}
