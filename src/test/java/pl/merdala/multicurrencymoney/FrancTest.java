package pl.merdala.multicurrencymoney;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class FrancTest {
    @Test
    void testFrancMultiplication2() {
        Money five = Money.franc(5);
        Money ten = five.times(2);
        assertEquals(Money.franc(10), ten);
    }

    @Test
    void testFrancMultiplication3() {
        Money five = Money.franc(5);
        Money ten = five.times(3);
        assertEquals(Money.franc(15), ten);
    }

    @Test
    void testFrancMultiplicationUnmutable() {
        Money five = Money.franc(5);
        five.times(2);
        assertEquals(Money.franc(5), five);
    }

    @Test
    void testEquality() {
        assertEquals(Money.franc(5), Money.franc(5));
        assertEquals(Money.franc(5).hashCode(), Money.franc(5).hashCode());
    }

    @Test
    void testEqualityForNull() {
        assertNotEquals(Money.franc(5), null);
    }

    @Test
    void testNotEquality() {
        assertNotEquals(Money.franc(5), Money.franc(6));
        assertNotEquals(Money.franc(5).hashCode(), Money.franc(6).hashCode());
    }

    @Test
    void testToString() {
        assertEquals("5 CHF", Money.franc(5).toString());
    }

    @Test
    void testCurrency() {
        assertEquals("CHF", Money.franc(5).currency);
    }
}
