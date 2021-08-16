package steps;

import pages.TripDetailPage;

public class ViewFlightDetailsSteps {

    TripDetailPage tripDetailPage = new TripDetailPage();

    public ViewFlightDetailsSteps showFlightDetailsStep(){
        tripDetailPage.clickShowDepartingDetails();
        tripDetailPage.clickShowReturningDetails();
        return this;
    }
}
