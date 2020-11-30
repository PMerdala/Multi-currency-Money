package pl.merdala.multicurrencymoney;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MoneyTest {
    @Test
    void testDollarMultiplication2() {
        Money five = Money.dollar(5);
        Money ten = five.times(2);
        assertEquals(Money.dollar(10), ten);
    }

    @Test
    void testDollarMultiplication3() {
        Money five = Money.dollar(5);
        Money ten = five.times(3);
        assertEquals(Money.dollar(15), ten);
    }

    @Test
    void testFrancMultiplication3() {
        Money five = Money.franc(5);
        Money ten = five.times(3);
        assertEquals(Money.franc(15), ten);
    }
    @Test
    void testFrancMultiplication2() {
        Money five = Money.franc(5);
        Money ten = five.times(2);
        assertEquals(Money.franc(10), ten);
    }

    @Test
    void testFrancMultiplication2NotEqualDollar() {
        Money five = Money.franc(5);
        Money ten = five.times(2);
        assertNotEquals(Money.dollar(10), ten);
    }

    @Test
    void testDollarMultiplicationUnmutable() {
        Money five = Money.dollar(5);
        five.times(2);
        assertEquals(Money.dollar(5), five);
    }

    @Test
    void testFrancMultiplicationUnmutable() {
        Money five = Money.franc(5);
        five.times(2);
        assertEquals(Money.franc(5), five);
    }

    @Test
    void testEquality() {
        assertEquals(Money.dollar(5), Money.dollar(5));
    }

    @Test
    void testEqualityDifferentConstructor() {
        assertEquals(Money.dollar(5), Money.money(BigDecimal.valueOf(5.0),"USD"));
    }

    @Test
    void testEqualityRound() {
        Money money = Money.money(BigDecimal.valueOf(4.9945),"USD");
        assertEquals(Money.money(BigDecimal.valueOf(4.99),"USD"), money );
    }
    @Test
    void testEqualityRound2() {
        Money money = Money.money(BigDecimal.valueOf(4.935),"USD");
        assertEquals(Money.money(BigDecimal.valueOf(4.94),"USD"), money );
    }
    @Test
    void testEqualityRound3() {
        Money money = Money.money(BigDecimal.valueOf(4.945),"USD");
        assertEquals(Money.money(BigDecimal.valueOf(4.94),"USD"), money );
    }

    @Test
    void testEqualityDifferentConstructorIntCurrency() {
        assertEquals(Money.dollar(5), Money.money(5,"USD"));
    }

    @Test
    void testEqualityHashCode() {
        assertEquals(Money.dollar(5).hashCode(), Money.dollar(5).hashCode());
    }

    @Test
    void testEqualityHashCodeDifferentConstructor() {
        assertEquals(Money.dollar(5).hashCode(), Money.money(BigDecimal.valueOf(5.0),"USD").hashCode());
    }

    @Test
    void testNotEqualityDollarAndFranc() {
        assertNotEquals(Money.dollar(5), Money.franc(5));
    }

    @Test
    void testNotEqualityHashCodeDollarAndFranc() {
        assertNotEquals(Money.dollar(5).hashCode(), Money.franc(5).hashCode());
    }

    @Test
    void testEqualityForNull() {
        assertNotEquals(Money.dollar(5), null);
    }

    @Test
    void testNotEquality() {
        assertNotEquals(Money.dollar(5), Money.dollar(6));
        assertNotEquals(Money.dollar(5).hashCode(), Money.dollar(6).hashCode());
    }

    @Test
    void testToString() {
        assertEquals("5.00 USD", Money.dollar(5).toString());
        assertEquals("5.00 CHF", Money.franc(5).toString());
    }

    @Test
    void testCurrency() {
        assertEquals("USD", Money.dollar(5).currency());
        assertEquals("CHF", Money.franc(5).currency());
    }

    @Test
    void testAdditionTheSameCurrency() {
        Money dollar1 = Money.dollar(5);
        Money dollar2 = Money.dollar(6);
        Expression sum = dollar1.plus(dollar2);
        Wallet wallet = Wallet.create();
        Money reduced = wallet.reduce(sum,"USD");
        assertEquals(Money.dollar(11),reduced);
    }
    @Test
    void testAdditionDifferentCurrency() {
        Money dollar = Money.dollar(5);
        Money franc = Money.franc(6);
        Expression sum = franc.plus(dollar);
        Wallet wallet = Wallet.create()
                .addRate("USD","CHF",BigDecimal.valueOf(2));
        Money reduced = wallet.reduce(sum,"CHF");
        assertEquals(Money.franc(16),reduced);
    }

    @Test
    void testMoneyReduce() {
        Money dollar = Money.dollar(5);
        Wallet wallet = Wallet.create();
        Money reduce = dollar.reduce(wallet,dollar.currency());
        assertEquals(dollar,reduce);

    }
    @Test
    void testMoneyReduceFrancReduceDollar() {
        Money dollar = Money.dollar(5);
        Wallet wallet = Wallet.create()
                .addRate("USD","CHF",BigDecimal.valueOf(2));
        Money reduce = dollar.reduce(wallet,"CHF");
        assertEquals(Money.money(10,"CHF"),reduce);

    }
}
