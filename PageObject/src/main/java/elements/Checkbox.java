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

    protected SelenideElement checkbox;

    private boolean isCheckBoxSelected(){
        return checkbox.isSelected();
    }

    public void turnOnCheckbox(SelenideElement checkbox){
        if(!isCheckBoxSelected()){
            checkbox.click();
        }
    }

    public void findCheckboxAndSelect(String checkboxName){
        $(By.xpath(checkboxName)).click();
    }
}
