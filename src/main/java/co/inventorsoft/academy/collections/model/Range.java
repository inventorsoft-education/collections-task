package co.inventorsoft.academy.collections.model;

import javax.swing.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.AbstractSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.IntStream;

public class Range<T> extends AbstractSet<T> implements Set<T> {

    private transient HashMap<T, Object> map;

    private static final Object PRESENT = new Object();

    public Range() {
        this.map = new HashMap<>();
    }

    public int size() {
        return map.size();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public boolean contains(Object object) {
        return map.containsKey(object);
    }

    public Iterator<T> iterator() {
        return map.keySet().iterator();
    }

    public boolean add(T element) {
        return this.map.put(element, PRESENT) == null;
    }

    public boolean remove(Object object) {
        return this.map.remove(object) == PRESENT;
    }

    public static Range of(Integer first, Integer second){
        if (first.equals(second)) {
            return new Range();
        }
        Range<Integer> range = new Range<>();
        IntStream.rangeClosed(first, second).forEach(range::add);
        return range;
    }

    public static Range of(Float first, Float second){
        Float max = Math.max(roundFloat(first), roundFloat(second));
        Float min = Math.min(roundFloat(first), roundFloat(second));
        Range<Float> range = new Range<>();
        range.add(min);
        while (!min.equals(max)) {
            min += 0.1f;
            range.add(min);
        }
        return range;
    }

    public static <T> Range<T> of(Character first, Character second, Function function) {
        Range range = new Range();
        range.add(first);
        Character temp = first;
        while (!temp.equals(second)) {
            temp = (Character) function.apply(temp);
            range.add(temp);
        }
        return range;
    }

    private static Float roundFloat(Float number) {
        BigDecimal bigDecimal = new BigDecimal(number).setScale(1, RoundingMode.HALF_UP);
        return bigDecimal.floatValue();
    }
}
