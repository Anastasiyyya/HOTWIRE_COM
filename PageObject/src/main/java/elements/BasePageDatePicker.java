package elements;

import lombok.Data;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Data
public class BasePageDatePicker extends DatePicker {

    public BasePageDatePicker() {
        super.button = $("[data-bdd = 'farefinder-flight-startdate-input']");
        super.nextButton = $x("//*[contains(text(),'Next month')]/parent::button");
        super.backButton = $x("//*[contains(text(),'Previous month')]/parent::button");
        super.resetButton  = $x("//*[contains(text(),'Reset')]/parent::button");
    }
}
