package elements;

import com.codeborne.selenide.SelenideElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Data
@Builder
public class FlightsDatePicker extends DatePicker {

    public FlightsDatePicker() {
        super.doneButton  = $x("//*[@data-stid='apply-date-picker']");
        super.button = $("#d1-btn");
        super.nextButton = $x("//*[@data-stid='date-picker-paging'][2]");
        super.backButton = $x("//*[@data-stid='date-picker-paging'][1]");
    }

    public void clickDoneButton() {
        doneButton.click();
    }
}
