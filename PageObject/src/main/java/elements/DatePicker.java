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
    protected SelenideElement doneButton;

    public static final String DATE_BASE_PAGE = "//*[@aria-label='%s %s, %s']";

    public DatePicker chooseRoundTripDates(String departingYear, String departingMonth, String departingDay,
                                           String returningYear, String returningMonth, String returningDay) {
        clickChooseDateButton();
        while(true) {
            if ($x(String.format(DATE_BASE_PAGE,departingMonth,departingDay,departingYear)).exists()) {
                $x(String.format(DATE_BASE_PAGE,departingMonth,departingDay,departingYear)).click();
                break;
            } else if ($x(String.format(DATE_BASE_PAGE,departingMonth.substring(0,3),departingDay,departingYear)).exists()) {
                $x(String.format(DATE_BASE_PAGE,departingMonth.substring(0,3),departingDay,departingYear)).click();
                break;
            } else {
                nextButton.click();
            }
        }
        while(true) {
            if ($x(String.format(DATE_BASE_PAGE,returningMonth,returningDay,returningYear)).exists()) {
                $x(String.format(DATE_BASE_PAGE,returningMonth,returningDay,returningYear)).click();
                break;
            } else if ($x(String.format(DATE_BASE_PAGE,returningMonth.substring(0,3),returningDay,returningYear)).exists()) {
                $x(String.format(DATE_BASE_PAGE,returningMonth.substring(0,3),returningDay,returningYear)).click();
                break;
            } else {
                nextButton.click();
            }
        }
        return this;
    }

    public DatePicker chooseOneWayTripDate(String departingYear, String departingMonth, String departingDay) {
        clickChooseDateButton();
        while(true) {
            if ($x(String.format(DATE_BASE_PAGE,departingMonth,departingDay,departingYear)).exists()) {
                $x(String.format(DATE_BASE_PAGE,departingMonth,departingDay,departingYear)).click();
                break;
            } else {
                nextButton.click();
            }
        }
        return this;
    }

    public DatePicker chooseOneWayTripDateForFlightSearchPage(String departingYear, String departingMonth, String departingDay) {
        clickChooseDateButton();
        while(true) {
            if ($x(String.format(DATE_BASE_PAGE,departingMonth,departingDay,departingYear)).exists()) {
                $x(String.format(DATE_BASE_PAGE,departingMonth,departingDay,departingYear)).click();
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
