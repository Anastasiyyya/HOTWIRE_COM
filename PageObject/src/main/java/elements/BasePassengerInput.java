package elements;

import static com.codeborne.selenide.Selenide.$;

public class BasePassengerInput extends PassengersInput {

    public BasePassengerInput() {
        super.passengersCountButton = $(".guest-picker");
        super.increaseAdultsButton = $(".guest-fields__form-group--adults .quantity-selector__btn--increase");
        super.decreaseAdultsButton = $(".guest-fields__form-group--adults .quantity-selector__btn--decrease");
        super.increaseChildrenButton = $(".guest-fields__form-group--children .quantity-selector__btn--increase");
        super.decreaseChildrenButton = $(".guest-fields__form-group--children .quantity-selector__btn--decrease");
        super.doneButton = $(".text-right button");
        super.existAdultsCount = $(".guest-fields__form-group--adults input");
        super.existChildrenCount = $(".guest-fields__form-group--children input");
    }
}
