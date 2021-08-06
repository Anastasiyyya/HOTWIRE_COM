package pages;


import elements.DropdownMenu;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HeaderPage extends DropdownMenu {
    public void changeCurrency() {
        $(By.xpath(CURRENCY_BUTTON)).click();
        $$(By.xpath(CURRENCY_CONTEINER)).get(4).click();
    }

    public String changeCurrencyCode() {
        return $(By.xpath(CURRENCY_CODE)).getText();
    }
}
