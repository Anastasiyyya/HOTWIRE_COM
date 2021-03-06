package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import elements.BasePageDatePicker;
import elements.BasePassengerInput;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import static com.codeborne.selenide.Selenide.*;

@Data
@Builder
@AllArgsConstructor
@Log4j2
public class BasePageForm extends InfoForm {

     private SelenideElement fareFinderFlights;
     private ElementsCollection searchingResults = $$(".dropdown-menu li a");
     private SelenideElement searchingResultsMenu = $(".dropdown-menu");

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
         log.info("Option 'Flights' was selected ");
         fareFinderFlights.click();
         return this;
    }

    @Override
    public InfoForm chooseDirectionFrom(String countryName) {
         log.info(String.format("Enter direction from: '%s' in Login field.", countryName));
         dropdown.selectInputDropdownOptionFromBasePage("Fly from",countryName);
         return this;
    }

    @Override
    public InfoForm chooseDirectionTo(String countryName) {
        log.info(String.format("Enter direction to: '%s' in Login field.", countryName));
        dropdown.selectInputDropdownOptionFromBasePage("Fly to",countryName);
        return this;
    }

    public void waitForSearchingResultsVisible() {
         searchingResultsMenu.shouldBe(Condition.visible);
    }
}
