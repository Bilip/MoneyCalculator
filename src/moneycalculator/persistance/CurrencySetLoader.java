package moneycalculator.persistance;

import moneycalculator.model.Currency;
import moneycalculator.model.CurrencySet;

public class CurrencySetLoader {

    private static CurrencySetLoader instance;

    private CurrencySetLoader() {
    }

    public static CurrencySetLoader getInstance() {
        if (instance == null) {
            instance = new CurrencySetLoader();
        }
        return instance;
    }

    public static void load() {
        CurrencySet set = CurrencySet.getInstance();

        set.add(new Currency("Euro", "EUR", "€"));
        set.add(new Currency("Dólar americano", "USD", "$"));
        set.add(new Currency("Libra esterlina", "GBP", "£"));
        set.add(new Currency("Dólar canadiense", "CAD", "$"));
        set.add(new Currency("Yen japonés", "JPY", "¥"));
    }

}
