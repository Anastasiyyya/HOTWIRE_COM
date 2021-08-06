package elements;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static elements.FlightInfoForm.FROM_TO_FIELD_XPATH;

public class Input {
    /**
     * Write text.
     *
     * @param text the text
     */
    public void writeTextInDropdownField(String label, String text) {
        $(By.xpath(String.format(FROM_TO_FIELD_XPATH,label))).sendKeys(text);
    }
}
