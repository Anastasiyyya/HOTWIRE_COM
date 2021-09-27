package pages;

import com.codeborne.selenide.Condition;
import elements.*;
import static com.codeborne.selenide.Selenide.$;
import static constants.IPagesConstants.*;

public class FlightsPageForm extends InfoForm {

    public FlightsPageForm() {
        super.datepicker = new FlightsDatePicker();
        super.passengersInput = new FlightsPagePassengerInput();
        super.leavingFromField  = $("[aria-label='Leaving from']");
        super.goingToField = $("[aria-label='Going to']");
        super.findAFlightButton = $("[data-testid='submit-button']");
    }

    @Override
    public InfoForm chooseDirectionFrom(String countryName) {
        waitForPageLoaded();
        dropdown.selectInputDropdownOptionFromFlightsPage(leavingFromField,countryName);
        return this;
    }

    @Override
    public InfoForm chooseDirectionTo(String countryName) {
        dropdown.selectInputDropdownOptionFromFlightsPage(goingToField,countryName);
        return this;
    }
}
