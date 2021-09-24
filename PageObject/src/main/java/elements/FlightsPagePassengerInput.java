package elements;

import static com.codeborne.selenide.Selenide.$;

public class FlightsPagePassengerInput extends PassengersInput {

    public FlightsPagePassengerInput() {
        super.passengersCountButton = $("[data-testid='travelers-field-trigger']");
        super.increaseAdultsButton = $("[aria-labelledby='uitk-step-increase-adults-789-title']");
        super.decreaseAdultsButton = $("[aria-labelledby='uitk-step-decrease-adults-631-title']");
        super.increaseChildrenButton = $("[aria-labelledby='uitk-step-increase-children-428-title']");
        super.decreaseChildrenButton = $("[aria-labelledby='uitk-step-decrease-children-683-title']");
        super.doneButton = $("[data-testid='guests-done-button']");
        super.existAdultsCount = $("#adult-input-0");
        super.existChildrenCount = $("#child-input-0");
    }
}
