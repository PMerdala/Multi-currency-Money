package pl.merdala.multicurrencymoney;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Money implements Expression{
    private final BigDecimal amount;
    private final String currencyCode;
    private final int round;

    public String currency() {
        return currencyCode;
    }

    private Money(BigDecimal amount, String currencyCode, int round) {
        this.round = round;
        this.amount = amount.setScale(round, RoundingMode.HALF_EVEN);
        this.currencyCode = currencyCode;
    }

    private Money(BigDecimal amount, String currencyCode) {
        this(amount, currencyCode, 2);
    }

    public Money times(int multiple) {
        return new Money(amount.multiply(BigDecimal.valueOf(multiple)), currency(), round);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Objects.equals(amount, money.amount) && isTheSameCurrency(money);
    }

    @Override
    public String toString() {
        return "" + amount + " " + currency();
    }

    public boolean isTheSameCurrency(Money money){
        return Objects.equals(currency(), money.currency());
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency(), amount);
    }

    public static Money dollar(int amount) {
        return new Money(BigDecimal.valueOf(amount), "USD");
    }

    public static Money money(int amount, String currency) {
        return new Money(BigDecimal.valueOf(amount), currency);
    }

    public static Money money(BigDecimal amount, String currency) {
        return new Money(amount, currency);
    }

    public static Money franc(int amount) {
        return new Money(BigDecimal.valueOf(amount), "CHF");
    }

    public Expression plus(Money addend) {
        if (isTheSameCurrency(addend)) {
            return new Money(amount.add(addend.amount),currency());
        }
        return new Sum(this,addend);
    }

    @Override
    public Money reduce(Wallet wallet,String toCurrency) {
        return Money.money(amount.multiply(wallet.rate(currency(),toCurrency)),toCurrency);
    }
}
