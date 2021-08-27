package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import constants.IConstantsURL;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.time.DateUtils;
import org.openqa.selenium.Cookie;

import java.time.Duration;
import java.util.Date;
import static com.codeborne.selenide.Selenide.open;

@Data
@AllArgsConstructor
@Builder
public class BasePage implements IConstantsURL {

    public BasePageForm basePageForm;
    public FlightsSearchPage flightsSearchPage;

    public BasePage() {
        this.basePageForm = new BasePageForm();
        this.flightsSearchPage = new FlightsSearchPage();
    }

    public BasePage openPage() {
        open(BASE_PAGE_URL);
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

    public BasePage waitForPageLoaded() {
        Selenide.Wait().withTimeout(Duration.ofSeconds(10));
        return this;
    }
}

