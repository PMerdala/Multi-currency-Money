package pl.merdala.multicurrencymoney;

import java.math.BigDecimal;
import java.util.Objects;

public class Franc extends Money {

    public Franc(BigDecimal amount) {
        super(amount,"CHF");
    }

    public Franc(int amount){
        this(BigDecimal.valueOf(amount));
    }

    public Franc(Money money){
        super(money);
    }

    public Money times(int multiple){
        return new Franc(super.times(multiple));
    }

}
