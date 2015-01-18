package moneycalculator.persistance;

import moneycalculator.model.ExchangeRateSet;
import moneycalculator.model.ExchangeRate;
import moneycalculator.model.Currency;
import moneycalculator.model.Number;

public class ExchangeRateLoader {

    private static ExchangeRateLoader instance;

    private ExchangeRateLoader() {
    }

    public static ExchangeRateLoader getInstance() {
        if (instance == null) {
            instance = new ExchangeRateLoader();
        }
        return instance;
    }

    public static void load() {
        ExchangeRateSet rates = ExchangeRateSet.getInstance();

        rates.add(new ExchangeRate(new Currency("EUR"), new Currency("EUR"), new Number(1)));
        rates.add(new ExchangeRate(new Currency("EUR"), new Currency("USD"), new Number(1, 2)));
        rates.add(new ExchangeRate(new Currency("EUR"), new Currency("GBP"), new Number(2, 3)));
        rates.add(new ExchangeRate(new Currency("EUR"), new Currency("CAD"), new Number(4, 2)));
        rates.add(new ExchangeRate(new Currency("EUR"), new Currency("JPY"), new Number(2)));

        rates.add(new ExchangeRate(new Currency("USD"), new Currency("EUR"), new Number(3)));
        rates.add(new ExchangeRate(new Currency("USD"), new Currency("USD"), new Number(1, 2)));
        rates.add(new ExchangeRate(new Currency("USD"), new Currency("GBP"), new Number(4)));
        rates.add(new ExchangeRate(new Currency("USD"), new Currency("CAD"), new Number(3, 2)));
        rates.add(new ExchangeRate(new Currency("USD"), new Currency("JPY"), new Number(1)));

        rates.add(new ExchangeRate(new Currency("GBP"), new Currency("EUR"), new Number(3, 1)));
        rates.add(new ExchangeRate(new Currency("GBP"), new Currency("USD"), new Number(1, 2)));
        rates.add(new ExchangeRate(new Currency("GBP"), new Currency("GBP"), new Number(2)));
        rates.add(new ExchangeRate(new Currency("GBP"), new Currency("CAD"), new Number(2, 3)));
        rates.add(new ExchangeRate(new Currency("GBP"), new Currency("JPY"), new Number(3)));

        rates.add(new ExchangeRate(new Currency("CAD"), new Currency("EUR"), new Number(2)));
        rates.add(new ExchangeRate(new Currency("CAD"), new Currency("USD"), new Number(1, 4)));
        rates.add(new ExchangeRate(new Currency("CAD"), new Currency("GBP"), new Number(1, 2)));
        rates.add(new ExchangeRate(new Currency("CAD"), new Currency("CAD"), new Number(3, 1)));
        rates.add(new ExchangeRate(new Currency("CAD"), new Currency("JPY"), new Number(1, 2)));

        rates.add(new ExchangeRate(new Currency("JPY"), new Currency("EUR"), new Number(1, 3)));
        rates.add(new ExchangeRate(new Currency("JPY"), new Currency("USD"), new Number(4)));
        rates.add(new ExchangeRate(new Currency("JPY"), new Currency("GBP"), new Number(2, 1)));
        rates.add(new ExchangeRate(new Currency("JPY"), new Currency("CAD"), new Number(3, 2)));
        rates.add(new ExchangeRate(new Currency("JPY"), new Currency("JPY"), new Number(2, 3)));
    }

}
