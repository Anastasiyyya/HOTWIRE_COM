package steps;

import elements.BasePageDatePicker;
import elements.BasePassengerInput;
import entities.Flight;
import entities.FlightSearch;
import pages.BasePage;
import pages.BasePageForm;
import pages.FlightForm;
import java.util.ArrayList;
import java.util.List;
import static com.codeborne.selenide.Selenide.$$x;
import static constants.IPagesConstants.DETAILS_BUTTON_XPATH;

public class FindFlightSteps {

    BasePage basePage =  new BasePage();
    BasePageForm basePageForm = new BasePageForm();
    BasePageDatePicker basePageDatePicker = new BasePageDatePicker();
    BasePassengerInput basePassengerInput = new BasePassengerInput();

    List<Flight> flightList = new ArrayList<>();

    public List<Flight> findFlight(FlightSearch flightSearch) {

        basePage.openPage()
                .waitForPageLoaded();
        basePageForm
                .chooseOptionFlights()
                .chooseFlightType(flightSearch.getFlightType())
                .chooseDirectionFrom(flightSearch.getAirportFrom().makeUpLocation())
                .chooseDirectionTo(flightSearch.getAirportTo().makeUpLocation());
        basePageDatePicker
                .chooseDate(flightSearch.getDepartingYear(), flightSearch.getDepartingMonth(), flightSearch.getDepartingDay(),
                        flightSearch.getReturningYear(), flightSearch.getReturningMonth(), flightSearch.getReturningDay());
        basePassengerInput
                .choosePassengersCount(flightSearch.getPassenger().getAdultPassengersCount(), flightSearch.getPassenger().getAdultPassenger())
                .waitUntilChooseButtonVisible()
                .choosePassengersCount(flightSearch.getPassenger().getChildrenPassengersCount(), flightSearch.getPassenger().getChildPassenger());
        basePageForm.clickFindAFlightButton()
                .waitFlightsLoaded();

        return makeUpFlightsList();
    }

    public List<Flight> makeUpFlightsList() {

        FlightForm flightForm = new FlightForm();

        for(int i = 0; i < flightForm.getFlights().size(); i++){
            $$x(DETAILS_BUTTON_XPATH).get(i).click();
            flightList.add(Flight.builder()
                    .flightType(flightForm.getFlightType().get(i).getText())
                    .airportFrom(flightForm.getAirportFrom().get(i).getText())
                    .airportTo(flightForm.getAirportTo().get(i).getText())
                    .flightPrice(flightForm.getFlightPrice().get(i).getText())
                    .build());
        }
        return flightList;
    }
}
