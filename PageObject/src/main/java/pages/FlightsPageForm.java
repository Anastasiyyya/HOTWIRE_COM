package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import elements.*;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class FlightsPageForm extends InfoForm {

    public FlightsPageForm() {
        super.leavingFromField  = $("[aria-label='Leaving from']");
        super.goingToField = $("[aria-label='Going to']");
        super.findAFlightButton = $("[data-testid='submit-button']");
        super.datepicker = new FlightsDatePicker();
        super.passengersInput = new FlightsPagePassengerInput();
    }

    @Override
    public InfoForm chooseDirectionFrom(String countryName) {
        waitForPageLoaded();
        dropdown.selectInputDropdownOptionFromFlightsPage(leavingFromField,countryName);
        Selenide.Wait().withTimeout(Duration.ofSeconds(10));
        return this;
    }

    @Override
    public InfoForm chooseDirectionTo(String countryName) {
        waitForPageLoaded();
        dropdown.selectInputDropdownOptionFromFlightsPage(goingToField,countryName);
        findAFlightButton.shouldBe(Condition.visible);
        return this;
    }
}
