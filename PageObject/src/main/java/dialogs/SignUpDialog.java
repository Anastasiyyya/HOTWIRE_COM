package dialogs;

import com.codeborne.selenide.SelenideElement;
import lombok.NoArgsConstructor;
import static com.codeborne.selenide.Selenide.$;

@NoArgsConstructor
public class SignUpDialog extends SignInDialog {

    protected SelenideElement firstName =  $("#firstName");
    protected SelenideElement lastName =  $("#lastName");

    public SignUpDialog createAnAccount(String email, String password, String firstName, String lastName) {
        headerPage.getSignUpButton().click();
        super.email.sendKeys(email);
        super.password.sendKeys(password);
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        signButton.click();
        return this;
    }
}
