package elements;

import com.codeborne.selenide.SelenideElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import static com.codeborne.selenide.Selenide.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DropdownMenu {

    private SelenideElement myTripsButton = $x("//*[contains(text(),'My trips')]");
    private SelenideElement myAccountButton = $x("//*[contains(text(),'My account')]");
    private SelenideElement myPreferencesButton = $x("//*[contains(text(),'Preferences')]");
    private SelenideElement currencyButton = $x("//*[@id='currency']");
    private SelenideElement currencyCode = $x("//*[@id='currency']//span");

    private final static String CURRENCY_CONTAINER = "//*[contains(text(),'%s')]";

    public void changeCurrency(String currency) {
        currencyButton.click();
        $(String.format(CURRENCY_CONTAINER, currency)).click();
    }

    public String getCurrencyCode() {
        return currencyCode.getText();
    }
}

