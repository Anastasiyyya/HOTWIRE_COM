package elements;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Buttons {
    public void clickButton(String button) {
        $(By.xpath(String.format(button))).click();
    }
}
