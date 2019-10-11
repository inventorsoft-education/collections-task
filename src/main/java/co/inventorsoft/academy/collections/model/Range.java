package co.inventorsoft.academy.collections.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.function.Function;
import java.util.stream.IntStream;

public class Range<T> implements Set<T> {

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

    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    public Iterator<T> iterator() {
        return map.keySet().iterator();
    }

    public Object[] toArray() {
        return new Object[0];
    }

    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    public boolean add(T t) {
        return this.map.put(t, PRESENT) == null;
    }

    public boolean remove(Object o) {
        return this.map.remove(o) == PRESENT;
    }

    public boolean containsAll(Collection<?> c) {
        return false;
    }

    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    public boolean retainAll(Collection<?> c) {
        return false;
    }

    public boolean removeAll(Collection<?> c) {
        Objects.requireNonNull(c);
        boolean var2 = false;
        Iterator var3;
        if (this.size() > c.size()) {
            for(var3 = c.iterator(); var3.hasNext(); var2 |= this.remove(var3.next())) {
            }
        } else {
            var3 = this.iterator();

            while(var3.hasNext()) {
                if (c.contains(var3.next())) {
                    var3.remove();
                    var2 = true;
                }
            }
        }

        return var2;
    }

    public void clear() {

    }
    public static <E> Range<E> of(E first, E second) {
        if (first instanceof Integer) {
            return rangeInt((Integer) first, (Integer) second);
        }
        return rangeFloat((Float) first, (Float) second);
    }

    public static <E> Range<E> of(Character first, Character second, Function function) {
        Range range = new Range();
        range.add(first);
        Character temp = first;
        while (!temp.equals(second)) {
            temp = (Character) function.apply(temp);
            range.add(temp);
        }
        return range;
    }

    private static Range rangeInt(Integer first, Integer second) {
        if (first.equals(second)) {
            return new Range();
        }
        Range<Integer> range = new Range<>();
        IntStream.rangeClosed(first, second).forEach(range::add);
        return range;
    }

    private static Range rangeFloat(Float first, Float second) {

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

    private static Float roundFloat(Float number) {
        BigDecimal bigDecimal = new BigDecimal(number).setScale(1, RoundingMode.HALF_UP);
        return bigDecimal.floatValue();
    }
}
