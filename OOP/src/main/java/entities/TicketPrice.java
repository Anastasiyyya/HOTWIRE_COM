package entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Data
@AllArgsConstructor
@Builder
public class TicketPrice {

    private Currency currency;
    private double sum;

    public String makeUpSum(){
        return String.format("%c %f", currency.getSymbol(), sum);
    }
}
