package dialogs;

import com.codeborne.selenide.SelenideElement;
import constants.IConstantsURL;
import pages.BasePage;
import static com.codeborne.selenide.Selenide.$;

public class Dialog extends BasePage implements IConstantsURL {

    protected SelenideElement signButton = $(".identity-form .btn-primary");
}
