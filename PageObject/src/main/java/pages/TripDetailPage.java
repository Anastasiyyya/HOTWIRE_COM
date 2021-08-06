package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TripDetailPage {

    public static final String REVIEW_YOUR_FLIGHT_HEADER_CSS = "#fisHeader > h1";
    public static final String CONTINUE_BOOKING_BUTTON_CSS = "#bookButton";
    public static final String TOTAL_PRICE_CSS = ".packagePriceList .packagePriceTotal";
    public static final String DIRECTION_TEXT_XPATH = "//*[@class='flex-area-primary']//*[@class='odPair']//div";

    public String getHeaderText() {
        return $(REVIEW_YOUR_FLIGHT_HEADER_CSS).getText();
    }

    public String getDirectionTextXpathText() {
        return $$(By.xpath(DIRECTION_TEXT_XPATH)).get(1).getText();
    }

    public boolean isButtonContinueBookingDisplayed() {
        waitUntilContinueBookingButtonDisplayed();
        return $(CONTINUE_BOOKING_BUTTON_CSS).isDisplayed();
    }

    public TripDetailPage waitUntilContinueBookingButtonDisplayed() {
        $(CONTINUE_BOOKING_BUTTON_CSS).shouldBe(Condition.visible, Duration.ofSeconds(20));
        return this;
    }

    public double returnTotalPrice() {
        Pattern p = Pattern.compile("[^0-9]*([0-9]+(\\.[0-9]*)?)");
        String addPrice = $$(TOTAL_PRICE_CSS).get(1).getText();
        Matcher m = p.matcher(addPrice);
        m.matches();
        String s = m.group(1);
        return Double.parseDouble(s);
    }
}
