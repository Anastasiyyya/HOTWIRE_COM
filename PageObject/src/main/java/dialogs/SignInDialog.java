package dialogs;

import pages.BasePage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SignInDialog extends Dialog {
    public static final String EMAIL_INPUT_CSS = "#email";
    public static final String PASSWORD_INPUT_CSS = "#password";
    public static final String SIGN_IN_BUTTON_CSS = ".sign-in";
    public static final String SIGN_UP_BUTTON_CSS = ".sign-up";
    //public static final String LOGIN_BUTTON_XPATH = "//*[@class='form-row']//span";

    public static String getEmailInputCss() {
        return EMAIL_INPUT_CSS;

    }

    public static String getPasswordInputCss() {
        return PASSWORD_INPUT_CSS;
    }

    public static String getSignInInputCss() {
        return SIGN_IN_BUTTON_CSS;
    }

    /**
     * This method opens signIn dialog by URL.
     *
     * @return the SignIn dialog
     */
    public SignInDialog openPage() {
        open(BASE_URL);
        return this;
    }

    public BasePage login(String email, String password) {
        $(SIGN_IN_BUTTON_CSS).click();
        $(EMAIL_INPUT_CSS).sendKeys(email);
        $(PASSWORD_INPUT_CSS).sendKeys(password);
        $(SIGN_BUTTON_CSS).click();
        return new BasePage();
    }
}
