package pages;

import com.codeborne.selenide.ElementsCollection;
import lombok.Data;
import static com.codeborne.selenide.Selenide.*;

@Data
public class FlightForms {

    //elements for flightSearchPage
    private ElementsCollection flights = $$x("//*[@data-test-id='offer-listing']");
    private ElementsCollection airportFrom = $$x("//*[@data-test-id='flight-info']//span[2]");
    private ElementsCollection airportTo = $$x("//*[@data-test-id='flight-info']//span[4]");
    private ElementsCollection flightType = $$x("//*[@data-test-id='price-msg-route-type']");
    private ElementsCollection flightPrice = $$x("//*[@class='total-price-message']//strong");

    //elements for trip detail page
    private ElementsCollection flightsDetail = $$(".flex-content");
    private ElementsCollection airportFromOnDetailPage = $$x("//*[@class='nobullet']//*[@class='odPair']/div[2]");
    private ElementsCollection airportToOnDetailPage = $$x("//*[@class='nobullet']//*[@class='odPair']/div[4]");
    private ElementsCollection airlineName = $$("[data-test-id='airline-name']");
    private ElementsCollection airlineLogoUrl = $$(".image img");
    private ElementsCollection seatingClass = $$(".cabinClass");
}
