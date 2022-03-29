package co.inventorsoft.academy.collections.model;

import static org.junit.jupiter.api.Assertions.*;

class RangeTest {

    @org.junit.jupiter.api.Test
    void size() {
        Range<Integer> integerRange = Range.of(1, 10);
        assertEquals(10, integerRange.size());
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        Range<Integer> integerRange = Range.of(1, 10);
        assertFalse(integerRange.isEmpty());

        Range<Integer> emptyRange = Range.of(1, 1);
        assertTrue(emptyRange.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void contains() {
        Range<Integer> integerRange = Range.of(1, 10);
        assertTrue(integerRange.contains(5));
    }

    @org.junit.jupiter.api.Test
    void iterator() {
    }

    @org.junit.jupiter.api.Test
    void toArray() {
    }

    @org.junit.jupiter.api.Test
    void testToArray() {
    }

    @org.junit.jupiter.api.Test
    void add() {
    }

    @org.junit.jupiter.api.Test
    void remove() {
    }

    @org.junit.jupiter.api.Test
    void containsAll() {
    }

    @org.junit.jupiter.api.Test
    void addAll() {
    }

    @org.junit.jupiter.api.Test
    void retainAll() {
    }

    @org.junit.jupiter.api.Test
    void removeAll() {
    }

    @org.junit.jupiter.api.Test
    void clear() {
    }

    @org.junit.jupiter.api.Test
    void of() {
    }

    @org.junit.jupiter.api.Test
    void testOf() {
    }

    @org.junit.jupiter.api.Test
    void testOf1() {
    }

    @org.junit.jupiter.api.Test
    void testOf2() {
    }

    @org.junit.jupiter.api.Test
    void testOf3() {
    }

    @org.junit.jupiter.api.Test
    void testOf4() {
    }
}