package elements;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Dropdown {
    public static final String DROPDOWN_MENU_CSS = ".dropdown-menu";

    public void selectInputDropdownOption(String direction, String countryName) {
        new Input().writeTextInDropdownField(direction,countryName);
        Selenide.Wait().withTimeout(Duration.ofSeconds(10));
        $$(DROPDOWN_MENU_CSS).get(0).click();
    }

    public void selectDropdownOption(String dropdownName, String dropdownMenuPath, int option) {
        $(By.xpath(dropdownName)).click();
        $$(By.xpath(dropdownMenuPath)).get(option).click();
    }
}
