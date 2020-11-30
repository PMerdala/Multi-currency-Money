package pl.merdala.multicurrencymoney;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {
    private final BigDecimal amount;
    private final String currencyCode;

    public String currency() {
        return currencyCode;
    }

    public Money(BigDecimal amount, String currencyCode) {
        this.amount = amount;
        this.currencyCode = currencyCode;
    }

    public Money(Money money){
        this(money.amount,money.currency());
    }

    public Money(int amount,String currencyCode){
        this(BigDecimal.valueOf(amount), currencyCode);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        Money money = (Money) o;
        return Objects.equals(amount, money.amount) && Objects.equals(currency(), money.currency());
    }

    @Override
    public String toString() {
        return "" + amount + " " + currency();
    }

    @Override
    public int hashCode() {
        return Objects.hash(toString());
    }

    public Money times(int multiple) {
        return new Money(amount.multiply(BigDecimal.valueOf(multiple)), currency());
    }

    public static  Money dollar(int amount){
        return new Money(amount,"USD");
    }

    public static Money franc(int amount){
        return new Money(amount,"CHF");
    }

}
