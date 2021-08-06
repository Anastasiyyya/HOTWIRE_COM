package elements;

import com.codeborne.selenide.Condition;

import java.time.Duration;
import java.util.Objects;

import static com.codeborne.selenide.Selenide.$;

public class PassengersInput {

    public static final String CHOOSE_PASSENGERS_COUNT_BUTTON_CSS = ".guest-picker";
    public static final String INCREASE_PASSENGERS_COUNT_BUTTON_CSS = ".guest-fields__form-group--%s .quantity-selector__btn--increase"; //children or adults
    public static final String DECREASE_PASSENGERS_COUNT_BUTTON_CSS = ".guest-fields__form-group--%s .quantity-selector__btn--decrease"; //children or adults
    public static final String DONE_BUTTON = ".text-right button";
    public static final String EXIST_PASSENGERS_COUNT_CSS = ".guest-fields__form-group--%s input"; //children or adults

    public PassengersInput choosePassengersCount(int passengersCount, String passengerType) {
        waitUntilChooseButtonVisible();
        $(CHOOSE_PASSENGERS_COUNT_BUTTON_CSS).click();
        int count;
        do {
            count = checkExistChildrenCount(passengerType);
            if(count < passengersCount){
                $(String.format(INCREASE_PASSENGERS_COUNT_BUTTON_CSS,passengerType)).click();
            } else {
                $(DONE_BUTTON).click();
                break;
            }
        } while (true);
        return this;
    }

    public PassengersInput waitUntilChooseButtonVisible() {
        $(CHOOSE_PASSENGERS_COUNT_BUTTON_CSS).shouldBe(Condition.visible, Duration.ofSeconds(20));
        return this;
    }

    public int checkExistChildrenCount(String passengerType){
        return Integer.parseInt(Objects.requireNonNull($(String.format(EXIST_PASSENGERS_COUNT_CSS, passengerType)).getAttribute("value")));
    }
}
