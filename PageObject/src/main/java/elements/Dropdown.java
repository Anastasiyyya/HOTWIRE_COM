package elements;

import com.codeborne.selenide.Selenide;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static constants.IPagesConstants.DROPDOWN_MENU_CSS;

@Data
@Builder
@NoArgsConstructor
public class Dropdown {

    private String dropdownName;
    private String dropdownMenuPath;
    private int option;

    public Dropdown(String dropdownName, String dropdownMenuPath, int option) {
        this.dropdownName = dropdownName;
        this.dropdownMenuPath = dropdownMenuPath;
        this.option = option;
    }


    public void selectInputDropdownOption(String direction, String countryName) {
        new Input(direction).writeTextInDropdownField(countryName);
        Selenide.Wait().withTimeout(Duration.ofSeconds(10));
        $$(DROPDOWN_MENU_CSS).get(0).click();
    }

    public void selectDropdownOption() {
        $(By.xpath(dropdownName)).click();
        $$(By.xpath(dropdownMenuPath)).get(option).click();
    }
}
