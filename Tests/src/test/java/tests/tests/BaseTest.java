package tests.tests;

import com.codeborne.selenide.Configuration;
import constants.IPagesConstants;
import elements.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;
import steps.FindFlightsSteps;
import tests.objects.Objects;
import tests.utils.TestListener;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Listeners(TestListener.class)
public class BaseTest implements IPagesConstants {

    BasePage basePage;
    BasePageDatePicker basePageDatePicker;
    FlightsPage flightsPage;
    HeaderPage headerPage;
    TripDetailPage tripDetailPage;
    BasePassengerInput basePassengerInput;
    BasePageForm basePageForm;
    DropdownMenu dropdownMenu;
    FindFlightsSteps findFlightSteps;
    Objects objects;

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
        Configuration.pageLoadTimeout = 30000;
        initPages();
    }

    /**
     * This method executed after test methods and closes browser.
    @AfterMethod
    public void closeBrowser(){
        getWebDriver().quit();
    }*/

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
        findFlightSteps = new FindFlightsSteps();
        objects = new Objects();
    }
}
