package elements;

import com.codeborne.selenide.SelenideElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Checkbox {

    private String label;
    private SelenideElement checkbox;

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

    public void selectCheckboxFromFilter(){
        $x(String.format(CHECKBOX_FILTER_XPATH,label)).click();
    }
}
