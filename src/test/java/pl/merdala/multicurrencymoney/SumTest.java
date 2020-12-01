package pl.merdala.multicurrencymoney;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class SumTest {

    @Test
    void reduce() {
        Wallet wallet = Wallet.create()
                .addRate("CHF", "USD", BigDecimal.valueOf(2));
        Expression dollar = Money.dollar(10);
        Expression franc = Money.franc(5);
        Expression sum = Sum.create(dollar,franc);
        Money money = sum.reduce(wallet,"USD");
        assertEquals(Money.dollar(20),money);

    }

    @Test
    void plus() {
        Wallet wallet = Wallet.create()
                .addRate("CHF", "USD", BigDecimal.valueOf(2));
        Expression dollar = Money.dollar(10);
        Expression franc = Money.franc(5);
        Expression sum = Sum.create(dollar,franc);
        sum = sum.plus(dollar);
        Money money = sum.reduce(wallet,"USD");
        assertEquals(Money.dollar(30),money);
    }

    @Test
    void times() {
        Wallet wallet = Wallet.create()
                .addRate("CHF", "USD", BigDecimal.valueOf(2));
        Expression dollar = Money.dollar(10);
        Expression franc = Money.franc(5);
        Expression sum = Sum.create(dollar,franc);
        sum = sum.times(-2);
        Money money = sum.reduce(wallet,"USD");
        assertEquals(Money.dollar(-40),money);

    }
}