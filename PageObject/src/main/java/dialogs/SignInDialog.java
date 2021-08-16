package dialogs;

import com.codeborne.selenide.SelenideElement;
import pages.BasePage;
import pages.HeaderPage;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SignInDialog extends Dialog {

    protected SelenideElement email = $("#email");
    protected SelenideElement password = $("#password");
    protected HeaderPage headerPage;

    /**
     * This method opens signIn dialog by URL.
     *
     * @return the SignIn dialog
     */
    public SignInDialog openPage() {
        open(BASE_PAGE_URL);
        return this;
    }

    public BasePage login(String email, String password) {
        headerPage.getSignInButton().click();
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        signButton.click();
        return new BasePage();
    }
}
