package elements;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Checkbox {
    public void findCheckboxAndSelect(String checkboxName){
        $(By.xpath(checkboxName)).click();
    }
}
