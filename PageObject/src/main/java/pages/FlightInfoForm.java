package pages;

import com.codeborne.selenide.SelenideElement;
import elements.DatePicker;
import elements.Dropdown;
import elements.PassengersInput;
import lombok.Data;

@Data
public abstract class FlightInfoForm {

    protected SelenideElement fareFinderFlights;
    protected SelenideElement leavingFromField;
    protected SelenideElement goingToField;
    protected SelenideElement findAFlightButton;
    protected SelenideElement roundTripButton;
    protected SelenideElement oneWayTripButton;
    protected DatePicker date;
    protected Dropdown tripTypeButton;
    protected PassengersInput passengersButton;
}
