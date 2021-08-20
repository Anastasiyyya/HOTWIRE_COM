package elements;

import com.codeborne.selenide.SelenideElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Checkbox {

    private SelenideElement checkbox;

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
}
