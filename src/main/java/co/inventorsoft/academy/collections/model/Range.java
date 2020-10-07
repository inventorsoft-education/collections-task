package co.inventorsoft.academy.collections.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Function;

public class Range<T> implements Set<T> {

    private HashSet<T> range;

    private Range() {
        range = new HashSet<>();
    }

    public static Range<Integer> of(int start, int end) {
        return Range.of(start, end, integer -> integer + 1);
    }

    public static Range<Float> of(float start, float end) {
        return Range.of(start, end, aFloat -> aFloat + 0.1f);
    }

    static <T extends Comparable> Range<T> of(T start, T end, Function<T, T> function) {
        Range<T> rT = new Range<>();
        if (start.equals(end)) {
            return rT;
        }
        while (start.compareTo(end) <= 0) {
            rT.add(start);
            start = function.apply(start);
        }
        return rT;
    }

    public int size() {
        return range.size();
    }

    public boolean isEmpty() {
        return range.isEmpty();
    }

    public boolean contains(Object o) {
        return range.contains(o);
    }

    public Iterator<T> iterator() {
        return range.iterator();
    }

    public Object[] toArray() {
        return range.toArray();
    }

    public <T1> T1[] toArray(T1[] a) {
        return range.toArray(a);
    }

    public boolean add(T t) {
        return range.add(t);
    }

    public boolean remove(Object o) {
        return range.remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        return range.containsAll(c);
    }

    public boolean addAll(Collection<? extends T> c) {
        return range.addAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        return range.retainAll(c);
    }

    public boolean removeAll(Collection<?> c) {
        return range.removeAll(c);
    }

    public void clear() {
        range.clear();
    }
}
