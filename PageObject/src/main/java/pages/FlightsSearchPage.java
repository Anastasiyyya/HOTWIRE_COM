package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Checkbox;
import elements.Dropdown;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;;
import static com.codeborne.selenide.Selenide.*;
import static constants.IPagesConstants.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightsSearchPage {

    private SelenideElement selectThisFareButton = $x("//*[@id = 'basic-economy-tray-content-%s']//button");
    private SelenideElement selectButton = $x("//*[@id='flightModuleList']//*[@class = 'grid-container standard-padding ']//button");
    private SelenideElement showOptionsButton = $x("//*[@id = 'flights-advanced-options-toggle']");
    private SelenideElement searchButton = $("#flight-wizard-search-button");
    private SelenideElement airportFrom = $x("//*[@data-test-id='flight-info']//span[2]");
    private SelenideElement airportTo = $x("//*[@data-test-id='flight-info']//span[4]");
    private SelenideElement flightType = $x("//*[@data-test-id='price-msg-route-type']");
    private SelenideElement sortDropdown = $("#sortDropdown");
    private SelenideElement sortFilterClearButton = $(".sort-filter-clear-button");

    public FlightsSearchPage clickShowOptionsButton(){
        showOptionsButton.click();
        return this;
    }

    public FlightsSearchPage chooseAdultsCount(int count) {
        new Dropdown(ADULT_COUNT_DROPDOWN_XPATH, ADULT_COUNT_DROPDOWN_MENU_XPATH, count-1).selectDropdownOption();
        return this;
    }

    public FlightsSearchPage chooseChildrenCount(int count) {
        new Dropdown(CHILDREN_COUNT_DROPDOWN_XPATH, CHILDREN_COUNT_DROPDOWN_MENU_XPATH, count).selectDropdownOption();
        return this;
    }

    public FlightsSearchPage chooseChildAge(int childOrder, int childAge) {
        new Dropdown(CHILD_AGES_DROPDOWN_XPATH, String.format(CHILD_AGES_DROPDOWN_MENU_XPATH, childOrder), childAge).selectDropdownOption();
        return this;
    }

    public FlightsSearchPage chooseAirline(int count) {
        new Dropdown(AIRLINE_DROPDOWN_XPATH, AIRLINE_DROPDOWN_MENU_XPATH, count).selectDropdownOption();
        return this;
    }

    public FlightsSearchPage chooseSeatingClass(int count) {
        new Dropdown(SEATING_CLASS_DROPDOWN_XPATH, SEATING_CLASS_DROPDOWN_MENU_XPATH, count-1).selectDropdownOption();
        return this;
    }

    public FlightsSearchPage selectCheckbox(String checkboxName) {
        new Checkbox().findCheckboxAndSelect(checkboxName);
        return this;
    }

    public FlightsSearchPage selectTripType(String tripType) {
        new Checkbox().findCheckboxAndSelect(String.format(TRIP_TYPE_CHECKBOXES_XPATH,tripType));
        return this;
    }

    public FlightsSearchPage clickSelectFlightButton(int flightOrder){
        $$(By.xpath(FLIGHTS_LIST_SELECT_BUTTONS_XPATH)).get(flightOrder-1).click();
        return this;
    }

    public FlightsSearchPage clickSelectFareButton(int flightOrder){
        $(By.xpath(String.format(SELECT_FARE_BUTTONS_XPATH,flightOrder))).click();
        return this;
    }

    public FlightsSearchPage chooseDepartingFlight(int flightOrder){

        if($x(String.format(RULES_BUTTON_XPATH,flightOrder)).isDisplayed()){
            clickSelectFlightButton(flightOrder);
            clickSelectFareButton(flightOrder);
        } else {
            clickSelectFlightButton(flightOrder);
        }
        return this;
    }

    public TripDetailPage chooseReturningFlight(int flightOrder){

        if($x(String.format(RULES_BUTTON_XPATH,flightOrder)).isDisplayed()){
            clickSelectFlightButton(flightOrder);
            clickSelectFareButton(flightOrder);
        } else {
            clickSelectFlightButton(flightOrder);
        }
        return new TripDetailPage();
    }

    public FlightsSearchPage clickSearchButton() {
        $(searchButton).click();
        return this;
    }

    public double checkTotalPrice(int flightOrder){
        $$(By.xpath(DETAILS_BUTTON_XPATH)).get(flightOrder).click();
        String price = $(By.xpath(TOTAL_PRICE_XPATH)).getText();
        String priceWithoutDollar = price.replace("$", "");
        return Double.parseDouble(priceWithoutDollar);
    }

    public double checkAdditionallyPrice(int flightOrder){
        String addPrice = $$(By.xpath(ADDITIONAL_PRICE_XPATH)).get(flightOrder).getText();
        String addPriceWithoutDollar = addPrice.replace("$", "");
        return Double.parseDouble(addPriceWithoutDollar);
    }
}
