package moneycalculator.model;

public class MoneyExchanger {

    private Money exchange(Money money, ExchangeRate exchangeRate) {
        Number multiplication = new Number(money.getAmount().multiply(money.getAmount(), exchangeRate.getRate()));
        return new Money(multiplication, exchangeRate.getTo());
    }

}
