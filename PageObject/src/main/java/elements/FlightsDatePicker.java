package elements;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class FlightsDatePicker extends DatePicker {

    private SelenideElement button;
    private SelenideElement nextButton;
    private SelenideElement backButton;
    private SelenideElement doneButton;

    public FlightsDatePicker() {
        super.button = $x("//*[@id='d1-btn']");
        super.nextButton = $x("//*[@data-stid='date-picker-paging'][2]");
        super.backButton = $x("//*[@data-stid='date-picker-paging'][1]");
        this.doneButton  = $x("//*[@data-stid='apply-date-picker']");
    }

    @Override
    public FlightsDatePicker chooseDate(String year, String month, String day) {
        clickChooseDateButton();
        while(true) {
            if ($x(String.format(DATE,month,day,year)).exists()) {
                $x(String.format(DATE,month,day,year)).click();
                break;
            } else {
                nextButton.click();
            }
        }
        return this;
    }
}
