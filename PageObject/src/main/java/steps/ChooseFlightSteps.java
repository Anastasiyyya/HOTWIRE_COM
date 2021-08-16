package steps;

import constants.IPagesConstants;
import pages.FlightsSearchPage;
import static com.codeborne.selenide.Selenide.switchTo;

public class ChooseFlightSteps implements IPagesConstants {

    FlightsSearchPage flightsSearchPage = new FlightsSearchPage();

    public ChooseFlightSteps choosePassengersCountStep(int adultsCount, int childrenCount){
        flightsSearchPage
                .clickButton(flightsSearchPage.getShowOptionsButton())
                .chooseAdultsCount(adultsCount)
                .chooseChildrenCount(childrenCount);
        return this;
    }

    public ChooseFlightSteps chooseChildrenAgeStep(int childOrder, int age){
        flightsSearchPage
                .chooseChildAge(childOrder,age);
        return this;
    }

    public ChooseFlightSteps chooseAdditionallyOptionsStep(){
        flightsSearchPage
                .chooseAirline(2)
                .chooseSeatingClass(1)
                .selectCheckbox(NONSTOP_FLIGHT_CHECKBOX_XPATH)
                .selectTripType("ONE_WAY");
        return this;
    }

    public ChooseFlightSteps chooseFlights() {
        flightsSearchPage
                .chooseDepartingFlight(1)
                .chooseReturningFlight(1);
        return this;
    }

    public ChooseFlightSteps switchToWindow(int order) {
        switchTo().window(order);
        return this;
    }
}
