package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Data
@NoArgsConstructor
@Builder
public class Checkbox {

    private SelenideElement checkbox;

    public Checkbox(SelenideElement checkbox) {
        this.checkbox = checkbox;
    }

    public static final String CHECKBOX_FILTER_XPATH = "//*[@id='sort-filter-drawer']//*[contains(text(),'%s (')]/ancestor::*[@class='check filter-option']//input";

    private boolean isCheckBoxSelected(){
        return checkbox.isSelected();
    }

    public void turnOnCheckbox(){
        if(!isCheckBoxSelected()){
            this.checkbox.click();
        }
    }

    public void findCheckboxAndSelect(String checkboxName){
        $(By.xpath(checkboxName)).click();
    }

    public void selectCheckboxFromFilter(String label){
        $x(String.format(CHECKBOX_FILTER_XPATH,label)).shouldBe(Condition.visible);
        $x(String.format(CHECKBOX_FILTER_XPATH,label)).click();
    }
}
