package elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class RadioButton {

    private SelenideElement radioButton;

    public RadioButton(String radioButtonLabel) {
        this.radioButton = $(By.xpath(String.format(RADIO_BUTTON_XPATH,radioButtonLabel)));
    }

    public static final String RADIO_BUTTON_XPATH = "//*[@id='route-type']//*[@aria-label='%s']"; //Roundtrip //One Way

    private boolean isRadioButtonSelected(){
        return radioButton.isSelected();
    }

    public void turnOnRadioButton(){
        if(!isRadioButtonSelected()){
            this.radioButton.click();
        }
    }

    public void findRadioButtonAndSelect(){
        radioButton.click();
    }
}
