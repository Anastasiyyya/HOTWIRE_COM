package pages;

import com.codeborne.selenide.SelenideElement;
import elements.BasePageDatePicker;
import elements.BasePassengerInput;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import static com.codeborne.selenide.Selenide.$x;

@Data
@Builder
@AllArgsConstructor
public class BasePageForm extends InfoForm {

     private SelenideElement fareFinderFlights;

     public BasePageForm() {
        this.fareFinderFlights = $x("//*[@class='farefinder-options']//*[text()='Flights']");
        super.leavingFromField = $x("//*[contains(text(),'Fly from')]/ancestor::*[@class='location-typeahead']//input");
        super.goingToField = $x("//*[contains(text(),'Fly to')]/ancestor::*[@class='location-typeahead']//input");
        super.findAFlightButton = $x("//*[contains(text(),'Find a flight')]");
        super.roundTripButton = $x("//*[contains(text(),'Round-trip')]");
        super.oneWayTripButton =  $x("//*[contains(text(),'One-way')]");
        super.datepicker = new BasePageDatePicker();
        super.passengersInput = new BasePassengerInput();
    }

    public BasePageForm chooseOptionFlights() {
        fareFinderFlights.click();
        return this;
    }

    @Override
    public BasePageForm chooseDirectionFrom(String countryName) {
        waitForPageLoaded();
        dropdown.selectInputDropdownOption("Fly from",countryName);
        return this;
    }

    @Override
    public BasePageForm chooseDirectionTo(String countryName) {
        waitForPageLoaded();
        dropdown.selectInputDropdownOption("Fly to",countryName);
        return this;
    }
}
