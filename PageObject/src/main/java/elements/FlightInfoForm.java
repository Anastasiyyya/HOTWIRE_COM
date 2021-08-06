package elements;

public class FlightInfoForm extends Dropdown{
    public static final String FAREFINDER_OPTIONS_XPATH = "//*[@class='farefinder-options']//*[text()='%s']";
    public static final String FROM_TO_FIELD_XPATH = "//*[contains(text(),'%s')]/ancestor::*[@class='location-typeahead']//input";
    public static final String FIND_A_FLIGHT_BUTTON_XPATH = "//*[contains(text(),'Find a flight')]";
    public static final String TYPE_TRIP_BUTTON_XPATH = "//*[contains(text(),'%s')]";
}
