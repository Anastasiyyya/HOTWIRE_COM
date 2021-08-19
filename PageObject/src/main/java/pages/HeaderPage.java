package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Data;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

@Data
public class HeaderPage extends BasePage{

    protected SelenideElement signInButton = $(".sign-in");
    protected SelenideElement signUpButton = $(".sign-up");
    protected SelenideElement flightsButton = $x("//*[@class='nav nav-pills']//*[text()='Flights']");
    protected SelenideElement accountButton = $("#dropdown-account-options");

    public SelenideElement getAccountButton() {
        return accountButton;
    }

    public void clickFlightButton() {
        flightsButton.click();
    }

    public BasePage waitForAccountButtonVisible() {
        accountButton.shouldBe(Condition.visible, Duration.ofSeconds(30));
        return this;
    }
}
