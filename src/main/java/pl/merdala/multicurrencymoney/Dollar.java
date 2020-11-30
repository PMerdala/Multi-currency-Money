package pl.merdala.multicurrencymoney;

import java.math.BigDecimal;
import java.util.Objects;

public class Dollar  extends Money{

    public Dollar(BigDecimal amount) {
        super(amount,"USD");
    }

    public Dollar(int amount) {
        this(BigDecimal.valueOf(amount));
    }

    public Dollar(Money money){
        this(money.amount);
    }

    public Money times(int multiple){
        return new Dollar(super.times(multiple));
    }
}
