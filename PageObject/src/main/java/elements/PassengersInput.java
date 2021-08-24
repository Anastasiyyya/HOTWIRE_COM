package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import java.util.Objects;

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
            count = checkExistPassengersCount(passengerType);
            if(count < passengersCount){
                if(passengerType.equals("adults")){
                    increaseAdultsButton.click();
                } else {
                    increaseChildrenButton.click();
                }
            } else {
               doneButton.click();
                break;
            }
        } while (true);
        return this;
    }

    public PassengersInput waitUntilChooseButtonVisible() {
        passengersCountButton.shouldBe(Condition.visible, Duration.ofSeconds(20));
        return this;
    }

    public int checkExistPassengersCount(String passengerType){
        if(passengerType.equals("adults")) {
            return Integer.parseInt(Objects.requireNonNull(existAdultsCount.getAttribute("value")));
        }
        return Integer.parseInt(Objects.requireNonNull(existChildrenCount.getAttribute("value")));
    }
}
