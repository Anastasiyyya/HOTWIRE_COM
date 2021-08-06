package elements;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.BasePage;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class DatePicker extends BasePage{
    public static final String CHOOSE_DATE_BUTTON_XPATH = "//*[@class='picker__overlay picker__overlay--selectable']";
    public static final String DATE_XPATH = "//*[@aria-label='%s %s, %s']";
    public static final String NEXT_MONTH_BUTTON_XPATH = "//*[contains(text(),'Next month')]/parent::button";

    public DatePicker chooseDepartingDate(String year, String month, String day) {
        clickChooseDateButton(0);
        SelenideElement departingDate = $(By.xpath(String.format(DATE_XPATH, month,day,year)));
        while(true) {
            if (departingDate.exists()) {
                $(By.xpath(String.format(DATE_XPATH, month,day,year))).click();
                //flightInfoForm.chooseTripOption("Flights");
                break;
            } else {
                $(By.xpath(NEXT_MONTH_BUTTON_XPATH)).click();
            }
        }
        return this;
    }

    public DatePicker chooseReturningDate(String year, String month, String day) {
        clickChooseDateButton(1);
        SelenideElement returningDate = $(By.xpath(String.format(DATE_XPATH, month,day,year)));
        while(true) {
            if (returningDate.exists()) {
                returningDate.click();
                break;
            }else {
                $(By.xpath(NEXT_MONTH_BUTTON_XPATH)).click();
            }
        }
        return this;
    }

    public DatePicker clickChooseDateButton(int order){
        $$(By.xpath(CHOOSE_DATE_BUTTON_XPATH)).get(order).click();
        return new DatePicker();
    }

    public DatePicker waitForPageLoaded(){
        Selenide.Wait().withTimeout(Duration.ofSeconds(20));
        return new DatePicker();
    }
}
