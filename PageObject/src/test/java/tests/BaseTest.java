package tests;

import com.codeborne.selenide.Configuration;
import constants.IPagesConstants;
import elements.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import testConstants.ITestConstants;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest implements ITestConstants, IPagesConstants {

    BasePage basePage;
    BasePageDatePicker basePageDatePicker;
    FlightsPage flightsPage;
    FlightsSearchPage flightsSearchPage;
    HeaderPage headerPage;
    TripDetailPage tripDetailPage;
    BasePassengerInput basePassengerInput;
    BasePageForm basePageForm;
    DropdownMenu dropdownMenu;

    /**
     * This method is executed before the test methods.
     */
    @BeforeMethod
    public void setUp(){
        Configuration.browser = "chrome";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        Configuration.browserCapabilities = new DesiredCapabilities();
        Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.startMaximized = true;
        Configuration.timeout = 15000;
        Configuration.holdBrowserOpen = true;
        Configuration.headless = false;
        initPages();
    }

    /**
     * This method executed after test methods and closes browser.
     */
    @AfterMethod
    public void closeBrowser(){
        getWebDriver().quit();
    }

    /**
     * This method inits pages for our project
     */
    public void initPages(){
        basePage =  new BasePage();
        flightsPage =  new FlightsPage();
        headerPage = new HeaderPage();
        tripDetailPage =  new TripDetailPage();
        basePageDatePicker = new BasePageDatePicker();
        basePageForm = new BasePageForm();
        dropdownMenu = new DropdownMenu();
        basePassengerInput = new BasePassengerInput();
    }
}
