package pages;

import com.codeborne.selenide.Configuration;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightsPage {

    private FlightsPageForm flightsPageForm;

    public FlightsPage waitForPageLoaded() {
        Configuration.timeout = 10000;
        return this;
    }
}
