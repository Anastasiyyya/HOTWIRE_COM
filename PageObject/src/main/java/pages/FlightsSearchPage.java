package pages;

import com.codeborne.selenide.*;
import elements.Checkbox;
import elements.Dropdown;
import elements.RadioButton;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;;
import java.time.Duration;
import java.util.Locale;
import java.util.Objects;
import static com.codeborne.selenide.Selenide.*;
import static constants.IPagesConstants.*;

@Data
@AllArgsConstructor
@Log4j2
public class FlightsSearchPage {

    private SelenideElement selectThisFareButton = $x("//*[@id = 'basic-economy-tray-content-%s']//button");
    private SelenideElement selectButton = $x("//*[@id='flightModuleList']//*[@class = 'grid-container standard-padding ']//button");
    private SelenideElement showOptionsButton = $x("//*[@id = 'flights-advanced-options-toggle']");
    private ElementsCollection flightDetailButton = $$x("//*[@class=' flightDetailsToggle']/button");
    private SelenideElement searchButton = $("#flight-wizard-search-button");
    private SelenideElement flightType = $x("//*[@data-test-id='price-msg-route-type']");
    private SelenideElement sortDropdown = $("#sortDropdown");
    private SelenideElement sortFilterClearButton = $(".sort-filter-clear-button");
    private SelenideElement nonStopFlightCheckboxXpath = $x("//*[@id = 'nonstop-flights']");
    private SelenideElement generalPassengersCountXpath = $x("//*[@id='advanced-options-container']//p/span");
    private SelenideElement oneWayRadioButton = $("id='oneway-flight'");
    private SelenideElement airlineInTheInfoForm = $("#outboundFlightModule [data-test-id=\"airline-name\"]");
    private SelenideElement directionFromInTheInfoForm = $x("//*[@id='outboundFlightModule']//*[@class='secondary-content']//span[2]");
    private SelenideElement directionToInTheInfoForm = $x("//*[@id='outboundFlightModule']//*[@class='secondary-content']//span[4]");
    private SelenideElement flightTypeInTheInfoForm = $x("//*[@id='outboundFlightModule']//*[@class='number-stops']");
    private SelenideElement infoModalClose = $("#forcedChoiceNoThanks");
    private FlightForms flightForms;
    private TripDetailPage tripDetailPage;

    public FlightsSearchPage() {
        this.flightForms = new FlightForms();
        this.tripDetailPage = new TripDetailPage();
    }

    public FlightsSearchPage clickShowOptionsButton(){
        log.info("Click on 'Show options' button");
        showOptionsButton.click();
        return this;
    }

    public FlightsSearchPage clickDetailsButton(int orderInList){
        log.info(String.format("Click on the 'Details and baggage fees' button with order number %s", orderInList));
        $$x(DETAILS_BUTTON_XPATH).get(orderInList).click();
        return this;
    }


    public FlightsSearchPage clickFlightDetailAndBaggageFeesButton(int orderInList){
        log.info(String.format("Click on the 'Details and baggage fees' button with order number %s", orderInList));
        flightDetailButton.get(orderInList).click();
        return this;
    }

    public FlightsSearchPage chooseAdultsCount(int count) {
        log.info(String.format("Choose adult count: %s", count));
        new Dropdown(ADULT_COUNT_DROPDOWN_XPATH, ADULT_COUNT_DROPDOWN_MENU_XPATH, count-1).selectDropdownOption();
        return this;
    }

    public FlightsSearchPage chooseChildrenCountAndRandomAge(int count) {
        log.info(String.format("Choose children count: %s", count));
        new Dropdown(CHILDREN_COUNT_DROPDOWN_XPATH, CHILDREN_COUNT_DROPDOWN_MENU_XPATH, count).selectDropdownOption();
        for (int i = 1; i <= count; i++) {
            int childAge = generateRandomAge();
            new Dropdown(CHILD_AGES_DROPDOWN_XPATH, String.format(CHILD_AGES_DROPDOWN_MENU_XPATH, i), childAge).selectDropdownOption();
        }
        return this;
    }

    public int generateRandomAge() {
        return (int) (Math.random() * 17);
    }

    public FlightsSearchPage chooseChildAge(int childOrder, int childAge) {
        new Dropdown(CHILD_AGES_DROPDOWN_XPATH, String.format(CHILD_AGES_DROPDOWN_MENU_XPATH, childOrder), childAge).selectDropdownOption();
        return this;
    }

    public FlightsSearchPage chooseAirlineByOrderInList(int count) {
        new Dropdown(AIRLINE_DROPDOWN_XPATH, AIRLINE_DROPDOWN_MENU_XPATH, count).selectDropdownOption();
        return this;
    }

    public FlightsSearchPage chooseAirlineByName(String airline) {
        log.info(String.format("Choose airline with name: %s", airline));
        new Dropdown(AIRLINE_DROPDOWN_XPATH, String.format(AIRLINE_DROPDOWN_OPTION_XPATH,airline)).findDropdownOptionAndSelect();
        return this;
    }

    public FlightsSearchPage chooseSeatingClassByOrderInList(int count) {
        new Dropdown(SEATING_CLASS_DROPDOWN_XPATH, SEATING_CLASS_DROPDOWN_MENU_XPATH, count-1).selectDropdownOption();
        return this;
    }

    public FlightsSearchPage chooseSeatingClassByName(String seatingClassName) {
        log.info(String.format("Choose seating class: %s", seatingClassName));
        new Dropdown(SEATING_CLASS_DROPDOWN_XPATH, String.format(SEATING_CLASS_DROPDOWN_OPTION_XPATH,seatingClassName)).findDropdownOptionAndSelect();
        return this;
    }

    public FlightsSearchPage selectNonStopCheckbox() {
        new Checkbox(nonStopFlightCheckboxXpath).turnOnCheckbox();
        return this;
    }

    public FlightsSearchPage selectTripType(String tripType) {
        new Checkbox().findCheckboxAndSelect(String.format(TRIP_TYPE_CHECKBOXES_XPATH,tripType.replace("-","_").toUpperCase(Locale.ROOT)));
        return this;
    }


    public FlightsSearchPage clickSelectFlightButton(int flightOrder){
        log.info(String.format("Click 'Select' button for flight with order %s", flightOrder));
        $x(String.format(FLIGHTS_LIST_SELECT_BUTTONS_XPATH,flightOrder)).click();
        return this;
    }

    public FlightsSearchPage waitUntilMenuVisible(int flightOrder){
        Selenide.Wait().withTimeout(Duration.ofSeconds(10));
        $(String.format(MENU_CSS,flightOrder)).shouldBe(Condition.visible, Duration.ofSeconds(15));
        return this;
    }

    public FlightsSearchPage clickSelectFareButton(int flightOrder){
        log.info(String.format("Click 'Select this fare' button for flight with order %s", flightOrder));
        $(String.format(SELECT_FARE_BUTTONS_CSS,flightOrder)).click();
        return this;
    }

    public FlightsSearchPage chooseDepartingFlight(int flightOrder){
        log.info(String.format("Choose departing flight for flight with order %s", flightOrder));
        if ($(String.format(RULES_BUTTON_CSS,flightOrder)).isDisplayed()){
            clickSelectFlightButton(flightOrder);
            waitUntilMenuVisible(flightOrder);
            clickSelectFareButton(flightOrder);
        } else {
            clickSelectFlightButton(flightOrder);
        }
        return this;
    }

    public TripDetailPage chooseReturningFlight(int flightOrder){
        log.info(String.format("Choose returning flight for flight with order %s", flightOrder));
        if ($(String.format(RULES_BUTTON_CSS,flightOrder)).isDisplayed()){
            clickSelectFlightButton(flightOrder);
            waitUntilMenuVisible(flightOrder);
            Selenide.sleep(5000);
            clickSelectFareButton(flightOrder);
        } else {
            clickSelectFlightButton(flightOrder);
        }
        return new TripDetailPage();
    }

    public FlightsSearchPage clickSearchButton() {
        log.info("Click 'Search' button");
        $(searchButton).click();
        return this;
    }

    public double checkTotalPrice(int flightOrder){
        $$(By.xpath(DETAILS_BUTTON_XPATH)).get(flightOrder-1).click();
        String price = $(By.xpath(TOTAL_PRICE_XPATH)).getText();
        String priceWithoutDollar = price.replace("$", "");
        return Double.parseDouble(priceWithoutDollar);
    }

    public double checkAdditionallyPrice(int flightOrder){
        String addPrice = $$(By.xpath(ADDITIONAL_PRICE_XPATH)).get(flightOrder).getText();
        String addPriceWithoutDollar = addPrice.replace("+ $", "").replace("$","");
        return Double.parseDouble(addPriceWithoutDollar);
    }

    public FlightsSearchPage waitFlightsLoaded() {
        $("#bCol").shouldBe(Condition.visible, Duration.ofSeconds(10));
        return this;
    }

    public int checkGeneralPassengersCount(){
        return Integer.parseInt(Objects.requireNonNull(generalPassengersCountXpath.getText().split(" ")[0]));
    }

    public FlightsSearchPage selectFilter(String checkboxName) {
        log.info(String.format("Select checkbox %s", checkboxName));
        new Checkbox().selectCheckboxFromFilter(checkboxName);
        return this;
    }

    public FlightsSearchPage selectRadioButtonOneWay() {
        log.info("Select radiobutton 'One-way'");
        new RadioButton("One Way").findRadioButtonAndSelect();
        return this;
    }

    public FlightsSearchPage selectSortOption(String option) {
        log.info(String.format("Select sort option %s", option));
        sortDropdown.click();
        $x(String.format(SORT_DROPDOWN_OPTIONS_XPATH,option)).click();
        Selenide.sleep(5000);
        return this;
    }

    public FlightsSearchPage closeInfoWindow() {
        infoModalClose.click();
        return this;
    }
}
