package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.*;

@Data
@Log4j2
public class HeaderPage {

    protected SelenideElement signInButton = $(".sign-in");
    protected SelenideElement signUpButton = $(".sign-up");
    protected SelenideElement flightsButton = $x("//*[@class='nav nav-pills']//*[text()='Flights']");
    protected SelenideElement accountButton = $("#dropdown-account-options");

    public void clickFlightButton() {
        log.info("Click on the 'Flights' button in the Header");
        flightsButton.click();
    }

    public HeaderPage waitForAccountButtonVisible() {
        accountButton.shouldBe(Condition.visible, Duration.ofSeconds(30));
        return this;
    }
}
