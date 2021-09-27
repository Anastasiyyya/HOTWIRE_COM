package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import elements.*;
import lombok.*;

import java.time.Duration;

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

    public InfoForm() {
        this.dropdown = new Dropdown();
    }

    public InfoForm waitForPageLoaded() {
        Selenide.Wait().withTimeout(Duration.ofSeconds(10));
        return this;
    }

    public InfoForm chooseFlightType(String flightType){
        if(flightType.equals("Round-trip")){
            roundTripButton.click();
        } else {
            oneWayTripButton.click();
        }
        return this;
    }

    public InfoForm chooseDirectionFrom(String countryName) {
        waitForPageLoaded();
        dropdown.selectInputDropdownOption("Fly from",countryName);
        return this;
    }

    public InfoForm chooseDirectionTo(String countryName) {
        waitForPageLoaded();
        dropdown.selectInputDropdownOption("Fly to",countryName);
        return this;
    }

    public FlightsSearchPage clickFindAFlightButton() {
        findAFlightButton.click();
        return new FlightsSearchPage();
    }

    public InfoForm writeDirection(String direction, String countryName) {
        new Input(direction).writeTextInDropdownField(countryName);
        return this;
    }
}
