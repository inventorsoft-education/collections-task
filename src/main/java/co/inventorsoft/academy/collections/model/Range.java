package co.inventorsoft.academy.collections.model;

import java.util.*;
import java.util.function.Function;

public class Range<T> implements Set<T> {

    private HashSet<T> mySet;

    public Range() {
        mySet = new HashSet<>();
    }

    public int size() {
        return mySet.size();
    }

    public boolean isEmpty() {
        return mySet.isEmpty();
    }

    public boolean contains(Object o) {
        return mySet.contains(o);
    }

    public Iterator<T> iterator() {
        return mySet.iterator();
    }

    public Object[] toArray() {
        return mySet.toArray();
    }

    public <T1> T1[] toArray(T1[] a) {
        return mySet.toArray(a);
    }

    public boolean add(T t) {
        return mySet.add(t);
    }

    public boolean remove(Object o) {
        return mySet.remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        return mySet.containsAll(c);
    }

    public boolean addAll(Collection<? extends T> c) {
        return mySet.addAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        return mySet.retainAll(c);
    }

    public boolean removeAll(Collection<?> c) {
        return mySet.removeAll(c);
    }

    public void clear() {
        mySet.clear();
    }

    public static Range<Byte> of(byte first, byte second) {
        return of(first, second, element -> (byte) (element + 1));
    }

    public static Range<Integer> of(int first, int second) {
        return of(first, second, element -> (element + 1));
    }

    public static Range<Float> of(float first, float second) {
        return of(first, second, element -> element + 0.1f);
    }

    public static Range<Long> of(long first, long second) {
        return of(first, second, element -> element + 1);
    }

    public static <T extends Comparable> Range<T> of(T first, T second, Function<T, T> function) {
        Range<T> range = new Range<>();
        if (first != second) {
            while (first.compareTo(second) <= 0) {
                range.add(first);
                first = function.apply(first);
            }
        }
        return range;
    }
}