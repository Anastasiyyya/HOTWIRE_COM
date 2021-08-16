package pages;

import com.codeborne.selenide.SelenideElement;
import elements.*;
import static com.codeborne.selenide.Selenide.$;

public class FlightsPageForm extends InfoForm {

    private SelenideElement leavingFromField;
    private SelenideElement flyToField;
    private SelenideElement findAFlightButton;

    public FlightsPageForm() {
        super.leavingFromField  = $("[aria-label='Leaving from']");
        super.goingToField = $("[aria-label='Going to']");
        super.findAFlightButton = $("[data-testid='submit-button']");
        super.datepicker = new FlightsDatePicker();
        super.passengersInput = new FlightsPagePassengerInput();
    }
}
