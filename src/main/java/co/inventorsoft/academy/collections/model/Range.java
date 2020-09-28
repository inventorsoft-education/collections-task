package co.inventorsoft.academy.collections.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Function;

public class Range<T> implements Set<T> {

    private Set<T> hashSet;

    private Range() {
        hashSet = new HashSet<>();
    }

    static <T extends Comparable<T>> Range<T> of(T from, T to, Function<T, T> increase) {
        Range<T> range = new Range<>();
        if (from.equals(to)) {
            return range;
        }
        while (0 >= from.compareTo(to)) {
            range.add(from);
            from = increase.apply(from);
        }
        return range;
    }

    static Range<Integer> of(int v, int v1) {
        return of(v, v1, i -> i + 1);
    }

    static Range<Float> of(float v, float v1) {
        return of(v, v1, f -> f + 0.1f);
    }

    public int size() {
        return hashSet.size();
    }

    public boolean isEmpty() {
        return hashSet.isEmpty();
    }

    public boolean contains(Object o) {
        return hashSet.contains(o);
    }

    public Iterator<T> iterator() {
        return hashSet.iterator();
    }

    public Object[] toArray() {
        return hashSet.toArray();
    }

    public <T1> T1[] toArray(T1[] a) {
        return hashSet.toArray(a);
    }

    public boolean add(T t) {
        return hashSet.add(t);
    }

    public boolean remove(Object o) {
        return hashSet.remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        return hashSet.containsAll(c);
    }

    public boolean addAll(Collection<? extends T> c) {
        return hashSet.addAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        return hashSet.retainAll(c);
    }

    public boolean removeAll(Collection<?> c) {
        return hashSet.removeAll(c);
    }

    public void clear() {
        hashSet.clear();
    }
}
