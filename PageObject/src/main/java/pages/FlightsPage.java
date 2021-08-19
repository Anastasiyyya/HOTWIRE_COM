package pages;

import com.codeborne.selenide.Configuration;

public class FlightsPage extends HeaderPage {

    private FlightsPageForm flightsPageForm;

    public FlightsPage waitForPageLoaded() {
        Configuration.timeout = 10000;
        return this;
    }
}
