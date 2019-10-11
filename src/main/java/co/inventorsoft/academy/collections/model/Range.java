package co.inventorsoft.academy.collections.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.function.Function;

public class Range<T> implements Set<T> {

    private List<T> list;

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
        return (T1[]) list.toArray(a);
    }

    public boolean add(T t) {
        if (list.stream().anyMatch(element -> element.equals(t))) {
            return false;
        } else {
            return list.add(t);
        }
    }

    public boolean remove(Object o) {
        return list.remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        return list.containsAll(c);
    }

    public boolean addAll(Collection<? extends T> c) {
        boolean added = false;
        for (T e : c) {
            if (add(e)) {
                added = true;
            }
        }
        return added;
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

    static <T extends Comparable> Range<T> of(T first, T last, Function<T, T> function) {
        Range<T> range = new Range<>();
        if (first == last) {
            return range;
        } else {
            while (first.compareTo(last) < 0) {
                range.add(first);
                first = function.apply(first);
            }
            range.add(first);
            return range;
        }
    }

    static Range<Integer> of(int firstElement, int lastElement) {
        return of(firstElement, lastElement, element -> element + firstElement);
    }

    static Range<Float> of(float firstElement, float lastElement) {
        firstElement = (float) (Math.round(firstElement * 10d) / 10d);
        lastElement = (float) (Math.round(lastElement * 10d) / 10d);
        final float step = firstElement;
        return of(firstElement, lastElement, element -> (element + step));
    }

    static Range<Short> of(short firstElement, short lastElement) {
        return of(firstElement, lastElement, element -> (short) (element + firstElement));
    }

    static Range<Long> of(long firstElement, long lastElement) {
        return of(firstElement, lastElement, element -> element + firstElement);
    }

    static Range<Double> of(double firstElement, double lastElement) {
        firstElement = (Math.round(firstElement * 10d) / 10d);
        lastElement = (Math.round(lastElement * 10d) / 10d);
        final double step = firstElement;
        return of(firstElement, lastElement, element -> element + step);
    }

    static Range<Byte> of(byte firstElement, byte lastElement) {
        return of(firstElement, lastElement, element -> (byte) (element + firstElement));
    }

    static Range<BigInteger> of(BigInteger firstElement, BigInteger lastElement) {
        return of(firstElement, lastElement, element -> element.add(firstElement));
    }

    static Range<BigDecimal> of(BigDecimal firstElement, BigDecimal lastElement) {
        return of(firstElement, lastElement, element -> element.add(firstElement));
    }

}