package pages;

import elements.Checkbox;
import elements.Dropdown;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.openqa.selenium.By;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Data
@AllArgsConstructor
@Builder
public class FlightsSearchPage extends BasePage{

    public static final String SHOW_OPTIONS_BUTTON_XPATH = "//*[@id = 'flights-advanced-options-toggle']";

    public static final String ADULT_COUNT_DROPDOWN_XPATH = "//*[@id = 'adult-count']";
    public static final String ADULT_COUNT_DROPDOWN_MENU_XPATH = "//*[@id = 'adult-count']//option";

    public static final String CHILDREN_COUNT_DROPDOWN_XPATH = "//*[@id = 'child-count']";
    public static final String CHILDREN_COUNT_DROPDOWN_MENU_XPATH = "//*[@id = 'child-count']//option";

    public static final String CHILD_AGES_DROPDOWN_XPATH = "//*[@name = 'child-ages']";
    public static final String CHILD_AGES_DROPDOWN_MENU_XPATH = "//*[@id = 'child-age-%s']//option"; //order of child

    public static final String AIRLINE_DROPDOWN_XPATH = "//*[@id = 'preferred-airline']";
    public static final String AIRLINE_DROPDOWN_MENU_XPATH = "//*[@id = 'preferred-airline']//option";

    public static final String SEATING_CLASS_DROPDOWN_XPATH = "//*[@id = 'seating-class']";
    public static final String SEATING_CLASS_DROPDOWN_MENU_XPATH = "//*[@id = 'seating-class']//option";

    public static final String NONSTOP_FLIGHT_CHECKBOX_XPATH = "//*[@id = 'nonstop-flights']";
    public static final String REFUNDABLE_FLIGHT_CHECKBOX_XPATH = "//*[@id = 'refundable-flights']";

    public static final String TRIP_TYPE_CHECKBOXES_XPATH = "//*[@value='%s']"; //ROUND_TRIP / ONE_WAY / MULTIPLE_DESTINATION /

    public static final String FLIGHTS_LIST_SELECT_BUTTONS_XPATH = "//*[@id='flightModuleList']//*[@class = 'grid-container standard-padding ']//button";
    public static final String SELECT_FARE_BUTTONS_XPATH = "//*[@id = 'basic-economy-tray-content-%s']//button"; //put flight order

    public static final String ELEMENT_OF_LIST_XPATH = "//*[@id='flightModuleList']//*[@class = 'grid-container standard-padding ']";
    //public static final String TEXT_OF_LIST_XPATH = "//*[@id='flightModuleList']//*[@class = 'primary-sub-content']";
    public static final String RULES_BUTTON_XPATH = "//*[@data-content-ref='#basic-economy-tray-content-1']";

    public static final String DETAILS_BUTTON_XPATH = "//*[@class='custom-col-r-margin link-style']";
    public static final String TOTAL_PRICE_XPATH = "//*[@class='total-price-message']//strong";
    public static final String ADDITIONAL_PRICE_XPATH = "//*[@class = 'primary-content   custom-primary-padding']//span";

    public FlightsSearchPage clickButton(String button){
        $(By.xpath(button)).click();
        return this;
    }

    public FlightsSearchPage chooseAdultsCount(int count) {
        new Dropdown().selectDropdownOption(ADULT_COUNT_DROPDOWN_XPATH, ADULT_COUNT_DROPDOWN_MENU_XPATH, count-1);
        return this;
    }

    public FlightsSearchPage chooseChildrenCount(int count) {
        new Dropdown().selectDropdownOption(CHILDREN_COUNT_DROPDOWN_XPATH, CHILDREN_COUNT_DROPDOWN_MENU_XPATH, count);
        return this;
    }

    public FlightsSearchPage chooseChildAge(int childOrder, int childAge) {
        new Dropdown().selectDropdownOption(CHILD_AGES_DROPDOWN_XPATH, String.format(CHILD_AGES_DROPDOWN_MENU_XPATH, childOrder), childAge);
        return this;
    }

    public FlightsSearchPage chooseAirline(int count) {
        new Dropdown().selectDropdownOption(AIRLINE_DROPDOWN_XPATH, AIRLINE_DROPDOWN_MENU_XPATH, count);
        return this;
    }

    public FlightsSearchPage chooseSeatingClass(int count) {
        new Dropdown().selectDropdownOption(SEATING_CLASS_DROPDOWN_XPATH, SEATING_CLASS_DROPDOWN_MENU_XPATH, count-1);
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

        if($(By.xpath(String.format(RULES_BUTTON_XPATH,flightOrder))).isDisplayed()){
            clickSelectFlightButton(flightOrder);
            clickSelectFareButton(flightOrder);
        }else {
            clickSelectFlightButton(flightOrder);
        }
        return this;
    }

    public TripDetailPage chooseReturningFlight(int flightOrder){

        if($(By.xpath(String.format(RULES_BUTTON_XPATH,flightOrder))).isDisplayed()){
            clickSelectFlightButton(flightOrder);
            clickSelectFareButton(flightOrder);
        }else {
            clickSelectFlightButton(flightOrder);
        }
        return new TripDetailPage();
    }

    public double checkTotalPrice(int flightOrder){
        $$(By.xpath(DETAILS_BUTTON_XPATH)).get(flightOrder).click();
        String price = $(By.xpath(TOTAL_PRICE_XPATH)).getText();
        Pattern p = Pattern.compile("[^0-9]*([0-9]+(\\.[0-9]*)?)");
        Matcher m = p.matcher(price);
        m.matches();
        String s = m.group(1);
        return Double.parseDouble(s);
    }

    public double checkAdditionallyPrice(int flightOrder){
        String addPrice = $$(By.xpath(ADDITIONAL_PRICE_XPATH)).get(flightOrder).getText();
        Pattern p = Pattern.compile("[^0-9]*([0-9]+(\\.[0-9]*)?)");
        Matcher m = p.matcher(addPrice);
        m.matches();
        String s = m.group(1);
        return Double.parseDouble(s);
    }

}
