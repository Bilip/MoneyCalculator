package moneycalculator.control;

import moneycalculator.model.Currency;
import moneycalculator.model.Money;
import moneycalculator.persistance.ExchangeRateLoader;
import moneycalculator.view.CurrencyDialog;
import moneycalculator.view.MoneyDialog;
import moneycalculator.view.MoneyViewer;

public class ExchangeMoneyControl {

    private ExchangeRateLoader exchangeRateLoader;
    private CurrencyDialog currencyDialog;
    private MoneyDialog moneyDialog;
    private MoneyViewer moneyViewer;

    public ExchangeMoneyControl() {
    }

    public void execute() {
        Money money = readMoney();
        Currency currency = readCurrency();
    }

    private Money readMoney() {
        return moneyDialog.getMoney();
    }

    private Currency readCurrency() {
        return currencyDialog.getCurrency();
    }

}
