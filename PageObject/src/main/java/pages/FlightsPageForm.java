package pages;

import com.codeborne.selenide.Condition;
import elements.*;
import lombok.extern.log4j.Log4j2;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class FlightsPageForm extends InfoForm {

    private final String leavingFieldWithValue = "[aria-label='Leaving from']";

    public FlightsPageForm() {
        super.datepicker = new FlightsDatePicker();
        super.passengersInput = new FlightsPagePassengerInput();
        super.leavingFromField  = $("[aria-label='Leaving from']");
        super.goingToField = $("[aria-label='Going to']");
        super.findAFlightButton = $("[data-testid='submit-button']");
    }

    @Override
    public InfoForm chooseDirectionFrom(String countryName) {
        log.info(String.format("Enter direction from: '%s' in Login field.", countryName));
        dropdown.selectInputDropdownOptionFromFlightsPage(leavingFromField,countryName);
        return this;
    }

    @Override
    public InfoForm chooseDirectionTo(String countryName) {
        log.info(String.format("Enter direction to: '%s' in Login field.", countryName));
        dropdown.selectInputDropdownOptionFlyTo(goingToField,countryName);
        findAFlightButton.shouldBe(Condition.visible);
        return this;
    }
}
