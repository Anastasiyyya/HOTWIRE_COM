package classes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Data
@AllArgsConstructor
@Builder
public class Currency {
    private String currencyName;
    private char symbol;
    private String code;

    Currency currency;
    public String makeUpCurrency(Currency currency) {
        return String.format("%s %s %c", currency.getCode(), currency.getCurrencyName(), currency.getSymbol());
    }
}
