package steps;

import entities.FlightSearch;
import io.qameta.allure.Step;
import pages.TripDetailPage;
import java.util.ArrayList;
import java.util.List;
import static com.codeborne.selenide.Selenide.switchTo;

public class FindFlightsSteps extends BaseSteps {

    /**
     * This step finds a flight using Base page form
     * @param flightSearch
     * @return List<Flight>
     */
    @Step("Find round trip flight from Base Page")
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

    @Step("Click on the done button in the passengers window")
    public FindFlightsSteps clickDoneButtonOnPassengersWindow()  {
        basePage.getBasePageForm().getPassengersInput()
                .clickDoneButton();
        return this;
    }

    @Step("Switch to Flight Search Page")
    public FindFlightsSteps goToFlightSearchPage()  {
        basePage.getBasePageForm()
                .clickFindAFlightButton()
                .waitFlightsLoaded();
        return this;
    }

    @Step("Choose departing flight")
    public FindFlightsSteps chooseDepartingFlight() {
        basePage.getFlightsSearchPage()
                .waitFlightsLoaded()
                .chooseDepartingFlight(1)
                .waitFlightsLoaded();
        return this;
    }

    @Step("Close existent window and switch to Trip Detail Page")
    public FindFlightsSteps closeWindowAndGoToTripDetailPage() {
        basePage.getFlightsSearchPage().closeInfoWindow();
        switchTo().window("Trip Detail | Hotwire");
        return this;
    }

    @Step("Choose returning flight")
    public FindFlightsSteps chooseReturningFlight() {
        basePage.getFlightsSearchPage()
                .waitFlightsLoaded()
                .chooseReturningFlight(1);
        return this;
    }

    @Step("Choose sort dropdown options")
    public FindFlightsSteps chooseSortDropdownOptions(String sortOption) {
        basePage.getFlightsSearchPage().selectSortOption(sortOption);
        return this;
    }

    @Step("Get price list from Searching page")
    public List<Double> getPriceListFromSearchingPage() {
        List<Double> pricesList =  new ArrayList<>();
        for (int i = 0; i < basePage.getFlightsSearchPage().getFlightForms().getFlights().size(); i++) {
            pricesList.add(basePage.getFlightsSearchPage().checkAdditionallyPrice(i));
        }
        return pricesList;
    }

    @Step("Check that price list has been correctly sorted")
    public boolean isPriceListSortedByHighest(List<Double> priceList) {
        Double price = priceList.get(0);
        for (Double aDouble : priceList) {
            if (aDouble > price) {
                return false;
            }
            price = aDouble;
        }
        return true;
    }

    @Step("Check that price lists before/after sorting are the same")
    public boolean isPriceListsTheSame(List<Double> pricesListBeforeSorting, List<Double> pricesListAfterSorting) {
        return pricesListAfterSorting.containsAll(pricesListBeforeSorting);
    }

    @Step("Switch to Trip Detail page")
    public TripDetailPage goToTripDetailPage() {

        switchTo().window("Trip Detail | Hotwire");
        basePage.getFlightsSearchPage().getTripDetailPage()
                .clickShowDepartingDetails()
                .clickShowReturningDetails();
        return new TripDetailPage();
    }

    @Step("Change flight to another")
    public FindFlightsSteps changeFlightToAnother()  {
        basePage.getFlightsSearchPage().getTripDetailPage()
                .clickChangeFlights();
        return this;
    }

    @Step("Check that direction is correct")
    public boolean isDirectionCorrect(String directionFrom, String directionTo) {
        for (int i = 0; i < basePage.getFlightsSearchPage().getTripDetailPage().getFlights().size(); i++) {
            if (!basePage.getFlightsSearchPage().getTripDetailPage().getLeavingFrom().get(i).getText().split(" ")[0].equals(directionFrom)
            || !basePage.getFlightsSearchPage().getTripDetailPage().getGoingTo().get(i).getText().split(" ")[0].equals(directionTo)) {
                return false;
            }
        }
        return true;
    }

    @Step("Check that the airline for the departing flight is correct")
    public boolean isAirlineForTheFlightToChanged(String airlineName) {
        return basePage.getFlightsSearchPage().getTripDetailPage().getAirline().get(0).getText().equals(airlineName);
    }

    @Step("Check that airline is equals to selected on the Search page")
    public boolean isAirlineEqualToSelected(String selectedAirlineName) {
        if (!basePage.getFlightsSearchPage().getAirlineInTheInfoForm().getText().equals(selectedAirlineName)) {
            return false;
        }
        return true;
    }

    @Step("Check that direction is equals to selected on the Search page")
    public boolean isDirectionEqualToSelected(String selectedDirection) {
        System.out.println(basePage.getFlightsSearchPage().getDirectionFromInTheInfoForm().getText() + " "
                + basePage.getFlightsSearchPage().getDirectionToInTheInfoForm().getText());
        return (basePage.getFlightsSearchPage().getDirectionFromInTheInfoForm().getText() + " "
                + basePage.getFlightsSearchPage().getDirectionToInTheInfoForm().getText()).equals(selectedDirection);
    }

    @Step("Check that flight type is equals to selected on the Search page")
    public boolean isFlightTypeEqualToSelected(String selectedFlightType) {
        System.out.println(basePage.getFlightsSearchPage().getFlightTypeInTheInfoForm().getText());
        return basePage.getFlightsSearchPage().getFlightTypeInTheInfoForm().getText().equals(selectedFlightType);
    }

    /**
     * This step finds a flight using Flight page form
     * @param flightSearch
     * @return List<Flight>
     */
    @Step("Find round-trip flight from Flight page ")
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
    @Step("Fill one-way trip flight with data")
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

    @Step("Get general passengers count from Base page")
    public int receiveGeneralPassengersCountFromBasePage(FlightSearch flightSearch) {
        int adultPassengerCount = basePage.getBasePageForm().getPassengersInput().receiveExistPassengersCountFromPage(flightSearch.getPassenger().getAdultPassenger());
        int childrenPassengerCount = basePage.getBasePageForm().getPassengersInput().receiveExistPassengersCountFromPage(flightSearch.getPassenger().getChildPassenger());
        int generalCountFromBasePage = adultPassengerCount + childrenPassengerCount;
        basePage.getBasePageForm().getPassengersInput()
                .clickDoneButton();
        return generalCountFromBasePage;
    }

    @Step("Get flight direction")
    public String getFlightDirection() {
        return basePage.getFlightsSearchPage().getFlightForms().getAirportFrom().get(0).getText() + " " +
                    basePage.getFlightsSearchPage().getFlightForms().getAirportTo().get(0).getText();
    }

    @Step("Get flight airline")
    public String getFlightAirline() {
        return basePage.getFlightsSearchPage().getFlightForms().getAirlineName().get(0).getText();
    }

    @Step("Get flight type")
    public String getFlightType() {
        return basePage.getFlightsSearchPage().getFlightForms().getNonstop().get(0).getText();
    }

    @Step("Check that flights has been sorted by airline correctly")
    public boolean isFlightsSortedByAirportsCorrectly(String filterAirport){
        for (int i = 0; i < basePage.getFlightsSearchPage().getFlightForms().getFlights().size(); i++) {
            String airportTo = basePage.getFlightsSearchPage().getFlightForms().getAirportTo().get(i).getText();
            if (!airportTo.equals(filterAirport)) {
                return false;
            }
        }
        return true;
    }

    @Step("Select filter")
    public FindFlightsSteps selectFilter(String filter) {
        basePage.getFlightsSearchPage()
                .selectFilter(filter);
        return this;
    }

    @Step("Select searching options")
    public FindFlightsSteps selectSearchingOptions(FlightSearch flightSearch) {

        basePage.getFlightsSearchPage()
                .selectRadioButtonOneWay()
                .clickShowOptionsButton()
                .chooseAdultsCount(flightSearch.getPassenger().getAdultPassengersCount())
                .chooseChildrenCountAndRandomAge(flightSearch.getPassenger().getChildrenPassengersCount())
                .chooseAirlineByName(flightSearch.getAirlineName())
                .chooseSeatingClassByName(flightSearch.getSeatingClass())
                .selectNonStopCheckbox()
                .clickSearchButton();
        return this;
    }

    /**
     * This gets finds flights searching results list
     */
    @Step("Find searching results list")
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

    @Step("Check that the entered data is in the search results")
    public boolean isTheEnteredDataInTheSearchResults(String result){
        for (int i = 0; i < makeUpSearchingResultsList().size(); i++) {
            if (!makeUpSearchingResultsList().get(i).contains(result)) {
                return false;
            }
        }
        return true;
    }

    @Step("Check that trip is one-way")
    public boolean isTripTypeOneWay() {
        for (int i = 0; i < basePage.getFlightsSearchPage().getFlightForms().getFlights().size(); i++) {
            if (!basePage.getFlightsSearchPage().getFlightForms().getFlightType().get(i).getText().equals("one way")) {
                return false;
            }
        }
        return true;
    }

    @Step("Check that trip is nonstop")
    public boolean isTripNonstop() {
        for (int i = 0; i < basePage.getFlightsSearchPage().getFlightForms().getFlights().size(); i++) {
            if (!basePage.getFlightsSearchPage().getFlightForms().getNonstop().get(i).getText().trim().equals("(Nonstop)")) {
                return false;
            }
        }
        return true;
    }

    @Step("Check that fly from direction is correct")
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

    @Step("Check that airline is correct")
    public boolean isAirlineCorrect(String airlineName) {
        for (int i = 0; i < basePage.getFlightsSearchPage().getFlightForms().getFlights().size(); i++) {
            if (!basePage.getFlightsSearchPage().getFlightForms().getAirlineName().get(i).getText().trim().equals(airlineName)) {
                return false;
            }
        }
        return true;
    }

    @Step("Check that passengers count is correct")
    public boolean isPassengersCountCorrect(int generalCountFromBasePage) {
        boolean result;
        int generalCount = basePage.getFlightsSearchPage().checkGeneralPassengersCount();
        result = generalCount == generalCountFromBasePage;
        return result;
    }

    @Step("Get flight price after searching")
    public Double getSearchedFlightPrice() {
        return basePage.getFlightsSearchPage().checkTotalPrice(1);
    }

    @Step("Get additionally price")
    public Double getAdditionallyPrice() {
        Double additionallyPrice = basePage.getFlightsSearchPage().checkAdditionallyPrice(1);
        if (!(basePage.getFlightsSearchPage().checkAdditionallyPrice(1) == 0)) {
            additionallyPrice = getSearchedFlightPrice();
        }
        return additionallyPrice;
    }

    @Step("Check that the price on the Trip detail page is correct for round-trip flight")
    public boolean isPriceOnTripDetailCorrectForRoundTrip(Double roundTripPrice, Double additionallyPrice) {
        double totalPrice = basePage.getFlightsSearchPage().getTripDetailPage().returnTotalPrice();
        if (basePage.getFlightsSearchPage().getTripDetailPage().getCurrencyPrice().exists()) {
            double changedPrice = Double.parseDouble(basePage.getFlightsSearchPage().getTripDetailPage().getCurrencyPrice().getText().replace("$",""));
            return totalPrice == changedPrice;
        } else {
            return totalPrice == roundTripPrice + additionallyPrice;
        }
    }

    @Step("Check that the price on the Trip detail page is correct for one-way trip")
    public boolean isPriceOnTripDetailCorrectForOneWayTrip(Double oneWaySearchedPrice) {
        double totalPrice = basePage.getFlightsSearchPage().getTripDetailPage().returnTotalPrice();
        return totalPrice == oneWaySearchedPrice;
    }

    @Step("Check that total price has been changed after changing flight type on the Trip Detail Page")
    public boolean isTotalPriceChangedAfterChangingFlightType(String flightTypeName) {
        double totalPrice = basePage.getFlightsSearchPage().getTripDetailPage().returnTotalPrice();
        double newPrice = basePage.getFlightsSearchPage().getTripDetailPage().checkFlightPriceWithType(flightTypeName);
        if (!(totalPrice == newPrice)) {
            return false;
        }
        return true;
    }

    @Step("Change flight price on the Trip Detail Page")
    public FindFlightsSteps changeFlightPrice(String flightTypeName) {
        basePage.getFlightsSearchPage().getTripDetailPage().changeFlightByPrice(flightTypeName);
        return this;
    }
}
