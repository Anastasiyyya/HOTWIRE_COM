package elements;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static constants.IPagesConstants.FROM_TO_FIELD_XPATH;

public class Input {

    private String label;

    public Input(String label) {
        this.label = label;
    }

    public void writeTextInDropdownField(String text) {
        $(By.xpath(String.format(FROM_TO_FIELD_XPATH,this.label))).append(text);
    }
}
