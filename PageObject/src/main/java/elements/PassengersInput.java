package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import java.util.Objects;

import static com.codeborne.selenide.Selenide.$;
import static constants.IPagesConstants.PASSENGERS_WINDOW_CSS;

public abstract class PassengersInput {

    protected SelenideElement passengersCountButton;
    protected SelenideElement increaseAdultsButton;
    protected SelenideElement decreaseAdultsButton;
    protected SelenideElement increaseChildrenButton;
    protected SelenideElement decreaseChildrenButton;
    protected SelenideElement doneButton;
    protected SelenideElement existAdultsCount;
    protected SelenideElement existChildrenCount;

    public PassengersInput choosePassengersCount(int passengersCount, String passengerType) {
        waitUntilChooseButtonVisible();
        passengersCountButton.click();
        int count;
        do {
            Selenide.Wait().withTimeout(Duration.ofSeconds(10));
            count = receiveExistPassengersCountFromPage(passengerType);
            if (count < passengersCount){
                if (passengerType.equals("adults")){
                    increaseAdultsButton.click();
                } else {
                    increaseChildrenButton.click();
                }
            } else {
                break;
            }
        } while (true);
        waitUntilChooseButtonVisible();
        return this;
    }

    public PassengersInput waitUntilPassengersWindowClosed() {
        $(PASSENGERS_WINDOW_CSS).shouldNotBe(Condition.visible);
        return this;
    }

    public PassengersInput waitUntilChooseButtonVisible() {
        passengersCountButton.shouldBe(Condition.visible, Duration.ofSeconds(10));
        return this;
    }

    public PassengersInput clickDoneButton() {
        doneButton.click();
        return this;
    }

    public int receiveExistPassengersCountFromPage(String passengerType){
        if (passengerType.equals("adults")) {
            return Integer.parseInt(Objects.requireNonNull(existAdultsCount.getAttribute("value")));
        }
        return Integer.parseInt(Objects.requireNonNull(existChildrenCount.getAttribute("value")));
    }
}
