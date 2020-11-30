package pl.merdala.multicurrencymoney;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairTest {

    @Test
    void testEquals() {
        assertEquals(new Pair<String>("A","B"),new Pair<String>("A","B"));
    }

    @Test
    void testNotEquals() {
        assertNotEquals(new Pair<String>("A","B"),new Pair<String>("B","A"));
    }

    @Test
    void testNotEqualsDifferentType() {
        assertNotEquals(new Pair<Integer>(1,2),new Pair<String>("B","A"));
    }

    @Test
    void testToString() {
        assertEquals("Pair<A,B>",new Pair<String>("A","B").toString());
    }

    @Test
    void testHashCode() {
        assertEquals(new Pair<String>("A","B").hashCode(),new Pair<String>("A","B").hashCode());
    }

    @Test
    void testHashCodeNotEquals() {
        assertNotEquals(new Pair<String>("A","B").hashCode(),new Pair<String>("B","A").hashCode());
    }
}