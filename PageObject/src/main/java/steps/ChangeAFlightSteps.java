package steps;


import pages.TripDetailPage;

public class ChangeAFlightSteps {

    TripDetailPage tripDetailPage = new TripDetailPage();
    ChooseFlightSteps chooseFlightSteps = new ChooseFlightSteps();

    public TripDetailPage changeFlightStep(){
        tripDetailPage.clickChangeFlights();
        return new TripDetailPage();
    }

    public ChangeAFlightSteps chooseNewFlights(int adultCount, int childrenCount, int childOrder, int age) {
        chooseFlightSteps.choosePassengersCountStep(adultCount,childrenCount);
        chooseFlightSteps.chooseChildrenAgeStep(childOrder, age);
        chooseFlightSteps.chooseAdditionallyOptionsStep();
        return this;
    }
}
