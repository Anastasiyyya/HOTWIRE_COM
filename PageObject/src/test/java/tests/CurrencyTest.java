package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CurrencyTest extends BaseTest{

    /**
     * This test checks if currency has been changed
     */
    @Test(description = "Checks")
    public void changeCurrency(){
        basePage.openPage();
        headerPage.changeCurrency();
        Assert.assertEquals(headerPage.changeCurrencyCode(),"CAD");
    }
}
