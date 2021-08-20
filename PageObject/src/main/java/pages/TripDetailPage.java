package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static com.codeborne.selenide.Selenide.*;

public class TripDetailPage {

    private final SelenideElement returningDate = $x("//*[@class = 'flex-card flex-tile details OD0']//*[@class='departureDate type-500']");
    private final SelenideElement departingDate = $x("//*[@class = 'flex-card flex-tile details OD1']//*[@class='departureDate type-500']");
    private final SelenideElement leavingFrom = $x("//*[@class='flex-card flex-tile details OD0']//*[@class='odPair']/div[2]");
    private final SelenideElement goingTo = $x("//*[@class='flex-card flex-tile details OD0']//*[@class='odPair']/div[4]");
    private final SelenideElement continueBookingButton = $("#bookButton");
    private final SelenideElement reviewYourFlight = $("#fisHeader > h1");
    private final ElementsCollection totalPrice = $$(".packagePriceList .packagePriceTotal");
    private final ElementsCollection directionText = $$x("//*[@class='flex-area-primary']//*[@class='odPair']//div");
    private final SelenideElement showDepartingDetailsButton = $("#flightDetailsToggle-1 > button");
    private final SelenideElement showReturningDetailsButton = $("#flightDetailsToggle-1 > button");
    private final SelenideElement changeFlightsButton = $("[data-track=\"FLT.RD.ChangeFlight\"]");


    public String getHeaderText() {
        return reviewYourFlight.getText();
    }

    public String getDirectionText() {
        return directionText.get(1).getText();
    }

    public boolean isButtonContinueBookingDisplayed() {
        waitUntilContinueBookingButtonDisplayed();
        return continueBookingButton.isDisplayed();
    }

    public TripDetailPage waitUntilContinueBookingButtonDisplayed() {
        continueBookingButton.shouldBe(Condition.visible, Duration.ofSeconds(20));
        return this;
    }

    public TripDetailPage clickShowDepartingDetails(){
        $(showDepartingDetailsButton).click();
        return this;
    }

    public TripDetailPage clickShowReturningDetails(){
        $(showReturningDetailsButton).click();
        return this;
    }

    public double returnTotalPrice() {
        Pattern p = Pattern.compile("[^0-9]*([0-9]+(\\.[0-9]*)?)");
        String addPrice = totalPrice.get(1).getText();
        Matcher m = p.matcher(addPrice);
        m.matches();
        String s = m.group(1);
        return Double.parseDouble(s);
    }

    public FlightsSearchPage clickChangeFlights() {
        $(changeFlightsButton).click();
        return new FlightsSearchPage();
    }
}
