package elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class FlightsDatePicker extends DatePicker {

    private final SelenideElement doneButton;

    public FlightsDatePicker() {
        this.doneButton  = $x("//*[@data-stid='apply-date-picker']");
        super.button = $("#d1-btn");
        super.nextButton = $x("//*[@data-stid='date-picker-paging'][2]");
        super.backButton = $x("//*[@data-stid='date-picker-paging'][1]");
    }
}
