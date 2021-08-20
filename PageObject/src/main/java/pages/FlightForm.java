package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class FlightForm {

    private SelenideElement airportFrom = $x("//*[@data-test-id='flight-info']//span[2]");
    private SelenideElement airportTo = $x("//*[@data-test-id='flight-info']//span[4]");
    private SelenideElement flightType = $x("//*[@data-test-id='price-msg-route-type']");
    private SelenideElement flightPrice = $x("//*[@class='total-price-message']//strong");
}
