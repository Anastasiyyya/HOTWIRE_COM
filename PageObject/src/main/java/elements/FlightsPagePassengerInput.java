package elements;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class FlightsPagePassengerInput extends PassengersInput {

    public FlightsPagePassengerInput() {
        super.passengersCountButton = $("[data-testid='travelers-field-trigger']");
        super.increaseAdultsButton = $x("//input[@id='adult-input-0']/following-sibling::button[@class='uitk-flex-item uitk-step-input-button']");
        super.decreaseAdultsButton = $("[aria-labelledby='uitk-step-decrease-adults-631-title']");
        super.increaseChildrenButton = $x("//input[@id='child-input-0']/following::button[@class='uitk-flex-item uitk-step-input-button']");
        super.decreaseChildrenButton = $("[aria-labelledby='uitk-step-decrease-children-683-title']");
        super.doneButton = $("[data-testid='guests-done-button']");
        super.existAdultsCount = $("#adult-input-0");
        super.existChildrenCount = $("#child-input-0");
    }
}
