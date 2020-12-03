package pl.merdala.multicurrencymoney;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairTest {

    @Test
    void testEquals() {
        assertEquals(new Pair<>("A","B"),new Pair<>("A","B"));
    }

    @Test
    void testNotEquals() {
        assertNotEquals(new Pair<>("A","B"),new Pair<>("B","A"));
    }

    @Test
    void testNotEqualsDifferentType() {
        assertNotEquals(new Pair<>(1,2),new Pair<>("B","A"));
    }

    @Test
    void testToString() {
        assertEquals("Pair<A,B>",new Pair<>("A","B").toString());
    }

    @Test
    void testHashCode() {
        assertEquals(new Pair<>("A","B").hashCode(),new Pair<>("A","B").hashCode());
    }

    @Test
    void testHashCodeNotEquals() {
        assertNotEquals(new Pair<>("A","B").hashCode(),new Pair<>("B","A").hashCode());
    }
}