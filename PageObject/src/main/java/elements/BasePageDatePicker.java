package elements;

import com.codeborne.selenide.SelenideElement;
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

    @Override
    public BasePageDatePicker clickChooseDateButton(){
        super.button.click();
        return this;
    }

    @Override
    public BasePageDatePicker chooseDate(String year, String month, String day) {
        clickChooseDateButton();
        while(true) {
            if ($x(String.format(DATE,month,day,year)).exists()) {
                $x(String.format(DATE,month,day,year)).click();
                break;
            } else {
                super.nextButton.click();
            }
        }
        return this;
    }
}
