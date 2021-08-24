package elements;

import com.codeborne.selenide.SelenideElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import static com.codeborne.selenide.Selenide.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class DatePicker {

    protected SelenideElement button;
    protected SelenideElement nextButton;
    protected SelenideElement backButton;
    protected SelenideElement resetButton;

    public static final String DATE = "//*[@aria-label='%s %s, %s']";

    public DatePicker chooseDate(String year, String month, String day) {
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

    public DatePicker clickChooseDateButton(){
        button.click();
        return this;
    }
}
