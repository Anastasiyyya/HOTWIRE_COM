package elements;

import com.codeborne.selenide.SelenideElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;
import pages.HeaderPage;

import static com.codeborne.selenide.Selenide.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DropdownMenu extends HeaderPage {

    private SelenideElement myTripsButton = $x("//*[contains(text(),'My trips')]");
    private SelenideElement myAccountButton = $x("//*[contains(text(),'My account')]");
    private SelenideElement myPreferencesButton = $x("//*[contains(text(),'Preferences')]");
    private SelenideElement currencyButton = $x("//*[@id='currency']");
    private SelenideElement currencyCode = $x("//*[@id='currency']//span");
    private final static String CURRENCY_CONTAINER = "#currency--container li";

    public void changeCurrency() {
        currencyButton.click();
        $$(CURRENCY_CONTAINER).get(4).click();
    }

    public String getCurrencyCode() {
        return currencyCode.getText();
    }

}

