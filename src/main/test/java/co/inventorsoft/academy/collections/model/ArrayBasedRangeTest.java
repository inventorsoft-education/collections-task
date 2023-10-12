package co.inventorsoft.academy.collections.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class ArrayBasedRangeTest {

    @Test
    public void sizeReturnsCountOfNumbersInInterval() {
        ArrayBasedRange<Integer> integerRange = ArrayBasedRange.of(1, 10);
        assertEquals(10, integerRange.size());
    }

    @Test
    public void isEmptyWorksForBothEmptyAndNonEmptyIntervals() {
        ArrayBasedRange<Integer> integerRange = ArrayBasedRange.of(1, 10);
        assertFalse(integerRange.isEmpty());

        ArrayBasedRange<Integer> emptyRange = ArrayBasedRange.of(1, 1);
        assertTrue(emptyRange.isEmpty());
    }

    @Test
    public void containsMatchesIfElementIsInTheRange() {
        ArrayBasedRange<Integer> integerRange = ArrayBasedRange.of(1, 10);
        assertTrue(integerRange.contains(5));
    }

    @Test
    public void iteratorGeneratesIntegersIn1Step() {
        ArrayBasedRange<Integer> integerRange = ArrayBasedRange.of(1, 10);
        final List<Integer> expectedElements = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        assertEquals(10, integerRange.size());
        for (Integer number : integerRange) {
            assertTrue(expectedElements.contains(number));
        }
    }

    @Test
    public void iteratorGeneratesIntegersIn01Step() {
        ArrayBasedRange<Float> doubleRange = ArrayBasedRange.of(0.1f, 0.5f);
        final List<Float> expectedElements = Arrays.asList(0.1f, 0.2f, 0.3f, 0.4f, 0.5f);
        assertEquals(5, doubleRange.size());
        for (Float number : doubleRange) {
            assertTrue(expectedElements.contains(number));
        }
    }

    @Test
    public void iteratorGeneratesCharactersForCustomType() {
        final ArrayBasedRange<Character> rangePoints = ArrayBasedRange.of('a', 'd', new Function<Character, Character>() {
            @Override
            public Character apply(Character character) {
                return (char) (character + 1);
            }
        });

        final Iterator<Character> iterator = rangePoints.iterator();
        final List<Character> expectedCharacters = Arrays.asList('a', 'b', 'c', 'd');
        for (Character character : expectedCharacters) {
            assertEquals(0, iterator.next().compareTo(character));
        }
    }
}
