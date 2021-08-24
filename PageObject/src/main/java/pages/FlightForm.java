package pages;

import com.codeborne.selenide.ElementsCollection;
import lombok.Data;
import static com.codeborne.selenide.Selenide.*;

@Data
public class FlightForm {

    private ElementsCollection flights = $$x("//*[@data-test-id='offer-listing']");
    private ElementsCollection airportFrom = $$x("//*[@data-test-id='flight-info']//span[2]");
    private ElementsCollection airportTo = $$x("//*[@data-test-id='flight-info']//span[4]");
    private ElementsCollection flightType = $$x("//*[@data-test-id='price-msg-route-type']");
    private ElementsCollection flightPrice = $$x("//*[@class='total-price-message']//strong");
}
