package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.*;
import static constants.IPagesConstants.*;

@Data
@Getter
@NoArgsConstructor
public class TripDetailPage {

    private final SelenideElement returningDate = $x("//*[@class = 'flex-card flex-tile details OD0']//*[@class='departureDate type-500']");
    private final SelenideElement departingDate = $x("//*[@class = 'flex-card flex-tile details OD1']//*[@class='departureDate type-500']");
    private final ElementsCollection leavingFrom = $$x("//*[@class='flex-card flex-tile details OD0']//*[@class='odPair']/div[2]");
    private final ElementsCollection goingTo = $$x("//*[@class='flex-card flex-tile details OD0']//*[@class='odPair']/div[4]");
    private ElementsCollection flights = $$(".flightSummaryContainer .flex-card");
    private final SelenideElement continueBookingButton = $("#bookButton");
    private final SelenideElement reviewYourFlight = $("#fisHeader > h1");
    private final ElementsCollection totalPrice = $$(".packagePriceList .packagePriceTotal");
    private final ElementsCollection directionText = $$x("//*[@class='flex-area-primary']//*[@class='odPair']//div");
    private final SelenideElement showDepartingDetailsButton = $("#flightDetailsToggle-0 > button");
    private final SelenideElement showReturningDetailsButton = $("#flightDetailsToggle-1 > button");
    private final SelenideElement changeFlightsButton = $("[data-track=\"FLT.RD.ChangeFlight\"]");
    private final SelenideElement currencyPrice = $(".currentPrice");
    private final ElementsCollection airline = $$(".airlineName");


    public String getHeaderText() {
        return reviewYourFlight.getText();
    }

    public boolean isButtonContinueBookingDisplayed() {
        waitUntilContinueBookingButtonDisplayed();
        return continueBookingButton.isDisplayed();
    }

    public void waitUntilContinueBookingButtonDisplayed() {
        continueBookingButton.shouldBe(Condition.visible, Duration.ofSeconds(20));
    }

    public TripDetailPage clickShowDepartingDetails(){
        $(showDepartingDetailsButton).click();
        return this;
    }

    public void clickShowReturningDetails(){
        $(showReturningDetailsButton).click();
    }

    public double returnTotalPrice() {
        String total = totalPrice.get(1).getText();
        String totalWithoutDollar = total.replace("$", "");
        return Double.parseDouble(totalWithoutDollar);
    }

    public FlightsSearchPage clickChangeFlights() {
        $(changeFlightsButton).click();
        return new FlightsSearchPage();
    }

    public FlightsSearchPage changeFlightByPrice(String flightName) {
        $x(String.format(CHANGE_FLIGHT_TYPE_BY_PRICE_TRIP_DETAIL_XPATH, flightName)).click();
        return new FlightsSearchPage();
    }

    public Double checkFlightPriceWithType(String flightTypeName) {
        String priceWithDollar = $x(String.format(FLIGHT_TYPE_PRICE_FIRST_PART,flightTypeName)).getText();
        String priceWithoutDollar = priceWithDollar.replace("$","");
        return Double.parseDouble(priceWithoutDollar);
    }
}
