package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import constants.IConstantsURL;
import elements.Dropdown;
import elements.FlightInfoForm;
import org.apache.commons.lang3.time.DateUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;

import java.time.Duration;
import java.util.Date;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BasePage extends FlightInfoForm implements IConstantsURL {
    public static final String ACCOUNT_BUTTON_CSS = "#dropdown-account-options";

    public BasePage openPage() {
        open(BASE_URL);
        WebDriverRunner.getWebDriver().manage().deleteCookieNamed("ak_bmsc");
        WebDriverRunner.getWebDriver().manage().addCookie(new Cookie("ak_bmsc",
                "5949BB4D1CE164DBFF9FA3CE76ECB53C~000000000000000000000000000000~YAAQX/" +
                        "1zPmwO7PB6AQAAGMnMCgzyo4OhFNpAH7LQrwG7EcgwjNEGjvPmn04RrImfbgmSN25chB6" +
                        "KKLX2C1aA9zPbwa3SlXLeKkdob4eVLY89HznNU+1T6Z9074XclZiiMnyosqb1iFD0VT" +
                        "x2X1wdV8o9+5kr/ubVWojXdDU52goQJPLXGq3nzS9VLP2cc+bFbhwa2kL9cbLFd6w0V" +
                        "f4IsonRm9z+YrGslWFyqyVbjGpfbC0JsYKI2VXVRII5wC3LCenCeCj8XAIrMPKIlC6tX22" +
                        "VOeKWiYBQRqs27DUHf6Y5sAwSc9oEHMvClJVeC43qlB2LkJD9Wz9sRr9TCJKbunUn2Z44N" +
                        "ZwaJrDKWgVfXRlW3B1pzy3TalZH97jqCafIKLtJqV7cfkWnqhqS60Jc1yHnW+abZHxJlgQ" +
                        "nNM5VF6r8ctfml5cytg6FuU5uS1CDb+16AyGxbFdY8Z7RJAAjLPfbBjMMz0G7MCLetfNs3v" +
                        "R5oQRwNdcJT0RyaqVBP8TS",
                ".hotwire.com", "/", DateUtils.addHours(new Date(), 2)));
        return this;
    }

    public BasePage waitForAccountButtonVisible() {
        $(ACCOUNT_BUTTON_CSS).shouldBe(Condition.visible, Duration.ofSeconds(30));
        return this;
    }

    public String getAccountButtonText() {
        return $(ACCOUNT_BUTTON_CSS).getText();
    }

    public void selectOption(String option) {

    }

    public BasePage chooseOption(String option) {
        $(By.xpath(String.format(FAREFINDER_OPTIONS_XPATH,option))).click();
        return this;
    }

    public BasePage chooseDirection(String direction, String countryName) {
        waitForAPageLoaded();
        new Dropdown().selectInputDropdownOption(direction,countryName);
        return this;
    }

    public BasePage waitForAPageLoaded() {
        Configuration.timeout = 10000;
        return this;
    }

    public FlightsSearchPage clickFindAFlightButton() {
        $(By.xpath(FIND_A_FLIGHT_BUTTON_XPATH)).click();
        return new FlightsSearchPage();
    }

    public FlightsSearchPage chooseFlightType(String type) {
        $(By.xpath(String.format(TYPE_TRIP_BUTTON_XPATH,type))).click();
        return new FlightsSearchPage();
    }

}

