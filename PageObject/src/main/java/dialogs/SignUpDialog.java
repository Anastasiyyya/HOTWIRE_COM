package dialogs;

import com.codeborne.selenide.WebDriverRunner;
import org.apache.commons.lang3.time.DateUtils;
import org.openqa.selenium.Cookie;
import java.util.Date;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SignUpDialog extends SignInDialog {

    public SignUpDialog() {
        super();
    }

    public static final String FIRST_NAME_CSS = "#firstName";
    public static final String LAST_NAME_CSS = "#lastName";

    public SignUpDialog openPage() {
        open(BASE_URL);
        WebDriverRunner.getWebDriver().manage().deleteCookieNamed("ak_bmsc");
        WebDriverRunner.getWebDriver().manage().addCookie(new Cookie("ak_bmsc",
                "5949BB4D1CE164DBFF9FA3CE76ECB53C~000000000000000000000000000000~YAAQX/" +
                        "1zPmwO7PB6AQAAGMnMCgzyo4OhFNpAH7LQrwG7EcgwjNEGjvPmn04RrImfbgmSN25chB6KKLX2C1aA9zPbwa" +
                        "3SlXLeKkdob4eVLY89HznNU+1T6Z9074XclZiiMnyosqb1iFD0VTx2X1wdV8o9+5kr/ubVWojXdDU52goQJPLXGq" +
                        "3nzS9VLP2cc+bFbhwa2kL9cbLFd6w0Vf4IsonRm9z+YrGslWFyqyVbjGpfbC0JsYKI2VXVRII5wC3LCenCeCj8XAI" +
                        "rMPKIlC6tX22VOeKWiYBQRqs27DUHf6Y5sAwSc9oEHMvClJVeC43qlB2LkJD9Wz9sRr9TCJKbunUn2Z44NZwaJrDKWg" +
                        "VfXRlW3B1pzy3TalZH97jqCafIKLtJqV7cfkWnqhqS60Jc1yHnW+abZHxJlgQnNM5VF6r8ctfml5cytg6FuU5uS1" +
                        "CDb+16AyGxbFdY8Z7RJAAjLPfbBjMMz0G7MCLetfNs3vR5oQRwNdcJT0RyaqVBP8TS",
                ".hotwire.com", "/", DateUtils.addHours(new Date(), 2)));
        return this;
    }

    public SignUpDialog createAnAccount(String email, String password, String firstName, String lastName) {
        $(SIGN_UP_BUTTON_CSS).click();
        $(EMAIL_INPUT_CSS).sendKeys(email);
        $(PASSWORD_INPUT_CSS).sendKeys(password);
        $(FIRST_NAME_CSS).sendKeys(firstName);
        $(LAST_NAME_CSS).sendKeys(lastName);
        $(SIGN_BUTTON_CSS).click();
        return this;
    }
}
