package pl.merdala.multicurrencymoney;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DollarTest {
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
    void testDollarMultiplicationUnmutable() {
        Money five = Money.dollar(5);
        five.times(2);
        assertEquals(Money.dollar(5), five);
    }

    @Test
    void testEquality() {
        assertEquals(Money.dollar(5), Money.dollar(5));
        assertEquals(Money.dollar(5).hashCode(), Money.dollar(5).hashCode());
    }

    @Test
    void testNotEqualityDollarAndFranc() {
        assertNotEquals(Money.dollar(5), Money.franc(5));
        assertNotEquals(Money.dollar(5).hashCode(), new Franc(5).hashCode());
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
        assertEquals("5 USD", Money.dollar(5).toString());
    }

    @Test
    void testCurrency() {
        assertEquals("USD", Money.dollar(5).currency);
    }
}
