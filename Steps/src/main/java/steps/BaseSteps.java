package steps;

import entities.Airline;
import entities.Flight;
import pages.BasePage;
import java.util.ArrayList;
import java.util.List;

public class BaseSteps {

    BasePage basePage = new BasePage();

    /**
     * This method add all flights exists on the 'Flight Search' page to flight list
     * @return flightList
     */
    public List<Flight> makeUpFlightsList() {
        List<Flight> flightList = new ArrayList<>();
        for (int i = 0; i < basePage.getFlightsSearchPage().getFlightForms().getFlights().size(); i++) {
            basePage.getFlightsSearchPage().clickDetailsButton(i);
            flightList.add(Flight.builder()
                    .flightType(basePage.getFlightsSearchPage().getFlightForms().getFlightType().get(i).getText())
                    .airportFrom(basePage.getFlightsSearchPage().getFlightForms().getAirportFrom().get(i).getText())
                    .airportTo(basePage.getFlightsSearchPage().getFlightForms().getAirportTo().get(i).getText())
                    .flightPrice(basePage.getFlightsSearchPage().getFlightForms().getFlightPrice().get(i).getText())
                    .airline(basePage.getFlightsSearchPage().getFlightForms().getAirlineName().get(i).getText())
                    .build());
            }
        return flightList;
    }

    /**
     * This method add all flights exists on the 'Trip detail' page to flight list
     * @return flightList
     */
    public List<Flight> makeUpFlightsDetailsList() {
        List<Flight> flightList = new ArrayList<>();
        for (int i = 0; i < basePage.getFlightsSearchPage().getFlightForms().getFlightsDetail().size(); i++){
            basePage.getFlightsSearchPage().clickFlightDetailAndBaggageFeesButton(i);
            flightList.add(Flight.builder()
                    .airline(Airline.builder()
                            .airlineName(basePage.getFlightsSearchPage().getFlightForms().getAirlineName().get(i).getText())
                            .logoUrl(basePage.getFlightsSearchPage().getFlightForms().getAirlineLogoUrl().get(i).getAttribute("src"))
                            .seatingClass(basePage.getFlightsSearchPage().getFlightForms().getSeatingClass().get(i).getText())
                            .build().toString())
                    .airportFrom(basePage.getFlightsSearchPage().getFlightForms().getAirportFromOnDetailPage().get(i).getText())
                    .airportTo(basePage.getFlightsSearchPage().getFlightForms().getAirportToOnDetailPage().get(i).getText())
                    .build());
        }
        return flightList;
    }

    public List<String> makeUpSearchingResultsList() {
        List<String> resultsList = new ArrayList<>();
        for (int i = 0; i < basePage.getBasePageForm().getSearchingResults().size(); i++){
            resultsList.add(basePage.getBasePageForm().getSearchingResults().get(i).toString());
        }
        return resultsList;
    }

}
