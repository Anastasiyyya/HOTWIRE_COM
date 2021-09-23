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
import static com.codeborne.selenide.Selenide.$$;
import static constants.IPagesConstants.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dropdown {

    private String dropdownName;
    private String dropdownMenuPath;
    private int numberInList;

    public Dropdown(String dropdownName, String dropdownMenuPath) {
        this.dropdownName = dropdownName;
        this.dropdownMenuPath = dropdownMenuPath;
    }

    public void selectInputDropdownOptionFromBasePage(String direction, String countryName) {
        new Input(direction).writeTextInDropdownField(countryName);
        Selenide.Wait().withTimeout(Duration.ofSeconds(10));
        $$(DROPDOWN_MENU_BASE_PAGE_CSS).get(0).click();
    }

    public void selectInputDropdownOptionFromFlightsPage(SelenideElement direction, String countryName) {
        direction.sendKeys(countryName);
        $(DROPDOWN_MENU_FLIGHTS_PAGE_CSS).shouldBe(Condition.visible);
        $$(DROPDOWN_MENU_OPTIONS_FLIGHTS_PAGE_CSS).get(0).click();
    }

    public void selectDropdownOption() {
        $(By.xpath(dropdownName)).click();
        $$(By.xpath(dropdownMenuPath)).get(numberInList).click();
    }

    public void findDropdownOptionAndSelect() {
        $(By.xpath(dropdownName)).click();
        $(By.xpath(dropdownMenuPath)).click();
    }
}
