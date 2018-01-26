package co.inventorsoft.academy.collections.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Function;

public class Range<T extends Comparable<T>> implements Set<T> {

    private T from;
    private T to;
    private Function<T, T> increment;
    private ArrayList<T> list = new ArrayList<>();

    private Range(T start, T end, Function<T, T> increment) {
        if (start.compareTo(end) <= 0) {
            return;
        }

        if (end.compareTo(start) < 0) {
            T temp = end;
            end = start;
            start = temp;
        }

        while (start.compareTo(end) < 0) {
            list.add(start);
            list.add(increment.apply(start));
        }
    }

    public ArrayList<T> getList() {
        return list;
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.size() == 0;
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
        return list.contains(t) && list.add(t);
    }

    public boolean remove(Object o) {
        return list.remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        return list.containsAll(c);
    }

    @SuppressWarnings({"unchecked"})
    public boolean addAll(Collection<? extends T> c) {
        return false;
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

    public static <T extends Comparable<T>> Range<T> of(T start, T end, Function<T, T> increment) {
        return new Range<>(start, end, increment);
    }

    public static Range<Short> of(Short from, Short to) {
        return new Range<>(from, to, shortValue -> (short) (shortValue + 1));
    }

    public static Range<Integer> of(Integer from, Integer to) {
        return new Range<>(from, to, intValue -> intValue + 1);
    }

    public static Range<Long> of(Long from, Long to) {
        return new Range<>(from, to, longValue -> longValue + 1);
    }

    public static Range<Double> of(Double from, Double to) {
        return new Range<>(from, to, doubleValue -> doubleValue + 1.0);
    }

    public static Range<Float> of (Float from, Float to) {
        return new Range<>(from, to, floatValue -> floatValue + 1.0f);
    }
}
