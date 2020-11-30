package pl.merdala.multicurrencymoney;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {
    protected final BigDecimal amount;
    protected final String currency;

    public Money(BigDecimal amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Money(Money money){
        this(money.amount,money.currency);
    }

    public Money(int amount,String currency){
        this(BigDecimal.valueOf(amount), currency);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        Money money = (Money) o;
        return Objects.equals(amount, money.amount) && Objects.equals(currency, money.currency);
    }

    @Override
    public String toString() {
        return "" + amount + " " + currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(toString());
    }

    public Money times(int multiple) {
        return new Money(amount.multiply(BigDecimal.valueOf(multiple)), currency);
    }

    public static  Dollar dollar(int amount){
        return new Dollar(amount);
    }

    public static Franc franc(int amount){
        return new Franc(amount);
    }

}
