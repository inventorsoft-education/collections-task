package co.inventorsoft.academy.collections.model;

import java.util.*;
import java.util.function.Function;

public class Range<T> implements Set<T> {
    private Set<T> set = new TreeSet<>();

    public int size() {
        return set.size();
    }

    public boolean isEmpty() {
        return set.isEmpty();
    }

    public boolean contains(Object o) {
        return set.contains(o);
    }

    public Iterator<T> iterator() {
        Iterator<T> iterator = set.iterator();
        return iterator;
    }

    public Object[] toArray() {
        return set.toArray();
    }

    public <T1> T1[] toArray(T1[] a) {
        return set.toArray(a);
    }

    public boolean add(T t) {
        return set.add(t);
    }

    public boolean remove(Object o) {
        return set.remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        return set.containsAll(c);
    }

    public boolean addAll(Collection<? extends T> c) {
        return set.addAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        return set.retainAll(c);
    }

    public boolean removeAll(Collection<?> c) {
        return set.removeAll(c);
    }

    public void clear() {
        set.clear();
    }


    public static <T extends Comparable> Range<T> of(T first, T last, Function<T, T> increment) {
        Range<T> range = new Range<>();
        if (first.compareTo(last) == 0) {
            return range;
        }

        T next = first;
        while (next.compareTo(last) <= 0) {
            range.add(next);
            next = increment.apply(next);
        }
        return range;
    }


    public static Range<Float> of(Float from, Float to) {
        return of(from, to, aFloat -> aFloat + 0.1f);
    }


    public static Range<Integer> of(Integer from, Integer to) {
        return of(from, to, aInteger -> aInteger + 1);
    }

    public static Range<Double> of(Double from, Double to) {
        return of(from, to, aDouble -> aDouble + 0.1d);
    }


    public static Range<Short> of(Short from, Short to) {
        return of(from, to, aShort -> (short)(aShort + 1));
    }

    public static Range<Byte> of(Byte from, Byte to) {
        return of(from, to, aByte -> (byte)(aByte + 1));
    }

}
