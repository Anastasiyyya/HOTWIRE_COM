package constants;

public interface IPagesConstants {

    String FROM_TO_FIELD_XPATH = "//*[contains(text(),'%s')]/ancestor::*[@class='location-typeahead']//input";

    String DROPDOWN_MENU_CSS = ".dropdown-menu li";

    String ADULT_COUNT_DROPDOWN_XPATH = "//*[@id = 'adult-count']";
    String ADULT_COUNT_DROPDOWN_MENU_XPATH = "//*[@id = 'adult-count']//option";

    String CHILDREN_COUNT_DROPDOWN_XPATH = "//*[@id = 'child-count']";
    String CHILDREN_COUNT_DROPDOWN_MENU_XPATH = "//*[@id = 'child-count']//option";

    String CHILD_AGES_DROPDOWN_XPATH = "//*[@name = 'child-ages']";
    String CHILD_AGES_DROPDOWN_MENU_XPATH = "//*[@id = 'child-age-%s']//option";

    String AIRLINE_DROPDOWN_XPATH = "//*[@id = 'preferred-airline']";
    String AIRLINE_DROPDOWN_MENU_XPATH = "//*[@id = 'preferred-airline']//option";
    String AIRLINE_DROPDOWN_OPTION_XPATH = "//*[@id = 'preferred-airline']//option[contains(text(),'%s')]";

    String SEATING_CLASS_DROPDOWN_XPATH = "//*[@id = 'seating-class']";
    String SEATING_CLASS_DROPDOWN_MENU_XPATH = "//*[@id = 'seating-class']//option";
    String SEATING_CLASS_DROPDOWN_OPTION_XPATH = "//*[@id = 'seating-class']//option[contains(text(),'%s')]";


    String REFUNDABLE_FLIGHT_CHECKBOX_XPATH = "//*[@id = 'refundable-flights']";

    String TRIP_TYPE_CHECKBOXES_XPATH = "//*[@value='%s']"; //ROUND_TRIP / ONE_WAY / MULTIPLE_DESTINATION /

    String FLIGHTS_LIST_SELECT_BUTTONS_XPATH = "//*[@id='flightModuleList']//*[@class = 'grid-container standard-padding ']//button";
    String SELECT_FARE_BUTTONS_XPATH = "//*[@id = 'basic-economy-tray-content-%s']//button"; //put flight order

    String ELEMENT_OF_LIST_XPATH = "//*[@id='flightModuleList']//*[@class = 'grid-container standard-padding ']";
    String RULES_BUTTON_XPATH = "//*[@data-content-ref='#basic-economy-tray-content-%s']";

    String DETAILS_BUTTON_XPATH = "//*[@class='custom-col-r-margin link-style']";
    String TOTAL_PRICE_XPATH = "//*[@class='total-price-message']//strong";
    String ADDITIONAL_PRICE_XPATH = "//*[@class = 'primary-content   custom-primary-padding']//span";
}
