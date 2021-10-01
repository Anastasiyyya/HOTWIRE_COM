package pages;

import com.codeborne.selenide.SelenideElement;
import elements.*;
import lombok.*;

@Data
@AllArgsConstructor
public abstract class InfoForm {

    protected SelenideElement leavingFromField;
    protected SelenideElement goingToField;
    protected SelenideElement findAFlightButton;
    protected SelenideElement roundTripButton;
    protected SelenideElement oneWayTripButton;
    protected DatePicker datepicker;
    protected Dropdown dropdown;
    protected PassengersInput passengersInput;
    protected BasePageDatePicker basePageDatePicker;
    protected FlightsDatePicker flightsDatePicker;

    public InfoForm() {
        this.dropdown = new Dropdown();
    }

    public InfoForm chooseFlightType(String flightType){
        if(flightType.equals("Round-trip")){
            roundTripButton.click();
        } else {
            oneWayTripButton.click();
        }
        return this;
    }

    public abstract InfoForm chooseDirectionFrom(String countryName);

    public abstract InfoForm chooseDirectionTo(String countryName);

    public FlightsSearchPage clickFindAFlightButton() {
        findAFlightButton.click();
        return new FlightsSearchPage();
    }

    public InfoForm writeDirection(String direction, String countryName) {
        new Input(direction).writeTextInDropdownField(countryName);
        return this;
    }
}
