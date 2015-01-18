package moneycalculator.model;

import java.util.ArrayList;
import java.util.Iterator;

public class ExchangeRateSet extends ArrayList<ExchangeRate> {

    private static ExchangeRateSet instance;

    private ExchangeRateSet() {
        super();
    }

    public static ExchangeRateSet getInstance() {
        if (instance == null) {
            instance = new ExchangeRateSet();
        }
        return instance;
    }

    public Number getRateFromSet(Currency currencyFrom, Currency currencyTo) {
        for (Iterator<ExchangeRate> it = this.iterator(); it.hasNext();) {
            ExchangeRate exchangeRate = it.next();
            if (exchangeRate.getFrom().equals(currencyFrom) && exchangeRate.getTo().equals(currencyTo)) {
                return exchangeRate.getRate();
            }
        }
        return new Number(0);
    }

}
