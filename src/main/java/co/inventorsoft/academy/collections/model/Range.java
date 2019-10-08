package co.inventorsoft.academy.collections.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Function;

public class Range<T> implements Set<T> {

    private HashSet<T> hashSet;

    public Range() {
        hashSet = new HashSet<>();
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
        return hashSet.remove(0);
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

    public static Range<Integer> of(Integer begin, Integer end) {
        Range<Integer> range = new Range<>();

        if (begin.compareTo(end) == 0) {
            return range;
        }

        while (begin.compareTo(end) <= 0) {
            range.add(begin);
            begin++;
        }

        return range;
    }

    public static Range<Byte> of(Byte begin, Byte end) {
        Range<Byte> range = new Range<>();

        if (begin.compareTo(end) == 0) {
            return range;
        }

        while (begin.compareTo(end) <= 0) {
            range.add(begin);
            begin++;
        }

        return range;
    }

    public static Range<Short> of(Short begin, Short end) {
        Range<Short> range = new Range<>();

        if (begin.compareTo(end) == 0) {
            return range;
        }

        while (begin.compareTo(end) <= 0) {
            range.add(begin);
            begin++;
        }

        return range;
    }

    public static Range<Float> of(Float begin, Float end) {
        Range<Float> range = new Range<>();

        if (begin.compareTo(end) == 0) {
            return range;
        }

        while (begin.compareTo(end) <= 0) {
            range.add(begin);
            begin = begin + 0.1f;
        }

        return range;
    }

    public static Range<Double> of(Double begin, Double end) {
        Range<Double> range = new Range<>();

        if (begin.compareTo(end) == 0) {
            return range;
        }

        while (begin.compareTo(end) <= 0) {
            range.add(begin);
            begin = begin + 0.1;
        }

        return range;
    }

    public static <T extends Comparable> Range<T> of(T begin, T end, Function<T, T> i) {
        Range<T> range = new Range<>();

        if (begin.compareTo(end) == 0) {
            return range;
        }

        while (begin.compareTo(end) <= 0) {
            range.add(begin);
            begin = i.apply(begin);
        }

        return range;
    }

}