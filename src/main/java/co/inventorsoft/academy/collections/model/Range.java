package co.inventorsoft.academy.collections.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class Range<T> implements Set<T> {

    @Override
    public String toString() {
        return "Range{" +
                "expectedElements=" + expectedElements +
                '}';
    }

    private final List<T> expectedElements = new ArrayList<>();

    public static class IntegerNextValue implements Function<Integer, Integer> {

        @Override
        public Integer apply(Integer i) {
            return i + 1;
        }
    }


    public static Range<Integer> of(Integer first, Integer last) {
        IntegerNextValue inv = new IntegerNextValue();
        return Range.of(first, last, inv);
    }

    public static class FloatNextValue implements Function<Float, Float> {
        @Override
        public Float apply(Float f) {
            return f + 0.1f;
        }
    }

    public static Range<Float> of(Float first, Float last) {
        Function<Float, Float> fnv = new FloatNextValue();

        return Range.of(first, last, fnv);
    }

    public static <T extends Comparable<T>> Range of(T first, T last, Function<T, T> func) {
        Range<T> tRange = new Range<>();
        if (first.compareTo(last) < 0) {
            T tVal = first;
            while (tVal.compareTo(last) < 1) {
                tRange.add(tVal);
                tVal = func.apply(tVal);
            }
        }

        return tRange;
    }

    public int size() {
        return expectedElements.size();
    }

    public boolean isEmpty() {
        return expectedElements.isEmpty();
    }

    public boolean contains(Object o) {
        return expectedElements.contains(o);
    }

    public Iterator<T> iterator() {
        return expectedElements.iterator();
    }

    public Object[] toArray() {
        return expectedElements.toArray();
    }

    public <T1> T1[] toArray(T1[] a) {
        return expectedElements.toArray(a);
    }

    public boolean add(T t) {

        if (!expectedElements.contains(t)) {
            return expectedElements.add(t);
        }
        return false;
    }

    public boolean remove(Object o) {
        return expectedElements.remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        return expectedElements.containsAll(c);
    }

    public boolean addAll(Collection<? extends T> c) {
        for (T t : expectedElements) {
            add(t);
        }
        return false;
    }

    public boolean retainAll(Collection<?> c) {
        return expectedElements.retainAll(c);
    }

    public boolean removeAll(Collection<?> c) {
        return expectedElements.removeAll(c);
    }

    public void clear() {
        expectedElements.clear();
    }
}