package moneycalculator.control;

import moneycalculator.model.ExchangeRateSet;
import moneycalculator.model.Money;
import moneycalculator.model.Number;
import moneycalculator.view.CurrencyDialog;
import moneycalculator.view.MoneyDialog;
import moneycalculator.view.MoneyViewer;

public class CalculateCommand {

    private final MoneyDialog moneyDialog;
    private final CurrencyDialog currencyDialog;
    private final MoneyViewer moneyViewer;

    public CalculateCommand(MoneyDialog moneyDialog, CurrencyDialog currencyDialog, MoneyViewer moneyViewer) {
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
        this.moneyViewer = moneyViewer;
    }
    
    public void execute(){
        moneyViewer.show(new Money(calculateAmount(), currencyDialog.getCurrency()));
    }
    
    public Number getExchangeRate(){
        ExchangeRateSet rates = ExchangeRateSet.getInstance();
        return rates.getRateFromSet(moneyDialog.getMoney().getCurrency(), currencyDialog.getCurrency());
    }

    private moneycalculator.model.Number calculateAmount() {
        return Number.multiply(getExchangeRate(), moneyDialog.getMoney().getAmount());
    }
    
}
