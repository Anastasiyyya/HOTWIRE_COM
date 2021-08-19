package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import elements.DatePicker;
import elements.Dropdown;
import elements.PassengersInput;
import entities.Flight;
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

    public InfoForm() {
        this.dropdown = new Dropdown();
    }

    public BasePage waitForPageLoaded() {
        Configuration.timeout = 10000;
        return new BasePage();
    }

    public BasePage chooseFlightType(String flightType){
        if(flightType.equals("Round-trip")){
            roundTripButton.click();
        } else {
            oneWayTripButton.click();
        }
        return new BasePage();
    }

    public BasePage selectRoundTrip() {
        roundTripButton.click();
        return new BasePage();
    }

    public BasePage selectOneWayTrip() {
        oneWayTripButton.click();
        return new BasePage();
    }
    public BasePageForm chooseDirection(String direction, String countryName) {
        waitForPageLoaded();
        dropdown.selectInputDropdownOption(direction,countryName);
        return new BasePageForm();
    }

    public BasePage clickFindAFlightButton() {
        findAFlightButton.click();
        return new BasePage();
    }
}
