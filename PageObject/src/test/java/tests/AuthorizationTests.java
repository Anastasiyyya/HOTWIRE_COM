package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class AuthorizationTests extends BaseTest {

    /**
     * This test checks if exists the ability to login the site.
     */
    @Test(description = "Authorization on the site")
    public void loginTest() {
        signInDialog
                .openPage()
                .login(LOGIN, PASSWORD)
                .waitForAccountButtonVisible();
        Assert.assertEquals(basePage.getAccountButtonText(), "Hi, Anastasiya");
    }


    /**
     * This test checks if exists the ability to register on the site.
     */
    @Test(description = "Register on the site")
    public void createAccountTest() throws InterruptedException {
        int randomNumber = (int) (Math.random() * 100);
        signUpDialog
                .openPage();
        Thread.sleep(30000);
        signUpDialog
                .createAnAccount(String.format("firstname_lastname%s@mail.ru",randomNumber),"qwerty123","firstName","lastName");
        Assert.assertNotEquals(basePage.getAccountButtonText(), "Hi, firstName");
        Assert.assertTrue($("#rc-imageselect").isDisplayed());
    }
}
