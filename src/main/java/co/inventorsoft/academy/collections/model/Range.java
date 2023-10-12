//developed by V.Havryliuk
package co.inventorsoft.academy.collections.model;

import java.util.function.Function;
import java.util.*;

//a range collection based on array list
public class Range<T> implements Set<T> {
    private ArrayList<T> list;

    private Range() {
        list = new ArrayList<>();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public boolean contains(Object o) {
        return list.contains(o);
    }

    public Iterator<T> iterator() {
        return list.iterator();
    }

    public Object[] toArray() {
        return list.toArray();
    }

    public <T1> T1[] toArray(T1[] a) {
        return list.toArray(a);
    }

    public boolean add(T t) {
        return list.add(t);
    }

    public boolean remove(Object o) {
        return list.remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        return list.containsAll(c);
    }

    public boolean addAll(Collection<? extends T> c) {
        return list.addAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        return list.retainAll(c);
    }

    public boolean removeAll(Collection<?> c) {
        return list.removeAll(c);
    }

    public void clear() {
        list.clear();
    }

    public static <T extends Comparable<T>> Range<T> of(T from, T to, Function<T, T> function) {
        Range<T> range = new Range<>();
        if (from.equals(to)) {
            return range;
        }

        range.add(from);
        while (!from.equals(to)) {
            from = function.apply(from);
            range.add(from);
        }
        return range;
    }

    public static Range<Double> of(Double from, Double to) {
        if (from > to) {
            return of(from, to, value -> value - 0.1);
        }

        return of(from, to, value -> value + 0.1);
    }

    public static Range<Float> of(Float from, Float to) {
        if (from > to) {
            return of(from, to, value -> value - 0.1f);
        }

        return of(from, to, value -> value + 0.1f);
    }

    public static Range<Integer> of(Integer from, Integer to) {
        if (from > to) {
            return of(from, to, value -> value - 1);
        }

        return of(from, to, value -> value + 1);
    }

    public static Range<Byte> of(Byte from, Byte to) {
        if (from > to) {
            return of(from, to, value -> (byte) (value + 1));
        }

        return of(from, to, value -> (byte) (value + 1));
    }

    public static Range<Short> of(Short from, Short to) {
        if (from > to) {
            return of(from, to, value -> (short) (value + 1));
        }

        return of(from, to, value -> (short) (value + 1));
    }

}
