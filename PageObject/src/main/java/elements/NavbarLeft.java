package elements;

import org.openqa.selenium.By;
import pages.BasePage;

import static com.codeborne.selenide.Selenide.$;

public class NavbarLeft extends BasePage {
    public static final String NAVBAR_BUTTONS_XPATH = "//*[@class='nav nav-pills']//*[text()='%s']";

    public void selectButton(String name) {
        $(By.xpath(String.format(NAVBAR_BUTTONS_XPATH, name))).click();
    }
}
