package co.inventorsoft.academy.collections.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Function;


public class Range<T> implements Set<T> {

    private final HashSet<T> myOwnSet;

    private Range() {
        myOwnSet = new HashSet<>();
    }


    public int size() {
        return myOwnSet.size();
    }

    public boolean isEmpty() {
        return myOwnSet.isEmpty();
    }

    public boolean contains(Object o) {

        return myOwnSet.contains(o);
    }

    public Iterator<T> iterator() {
        return myOwnSet.iterator();
    }

    public Object[] toArray() {

        return myOwnSet.toArray();
    }

    public <T1> T1[] toArray(T1[] a) {
        return myOwnSet.toArray(a);
    }

    public boolean add(T t) {

        return myOwnSet.add(t);
    }

    public boolean remove(Object o) {

        return myOwnSet.remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        return myOwnSet.containsAll(c);
    }

    public boolean addAll(Collection<? extends T> c) {
        return myOwnSet.addAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        return myOwnSet.retainAll(c);
    }

    public boolean removeAll(Collection<?> c) {
        return myOwnSet.removeAll(c);
    }

    public void clear() {
        myOwnSet.clear();
    }

    public static <T extends Comparable<T>> Range<T> of(T beginIndex, T endIndex, Function<T, T> increment) {
        Range<T> range = new Range<>();
        if (beginIndex.compareTo(endIndex) == 0) {
            return range;
        }
        T nextOne = beginIndex;
        while (0 >= nextOne.compareTo(endIndex)) {
            range.add(nextOne);
            nextOne = increment.apply(nextOne);
        }
        return range;
    }

    public static Range<Float> of(float beginIndex , float endIndex ) {
        return of(beginIndex , endIndex , f -> f + 0.1f);
    }

    public static Range<Integer> of(int beginIndex, int endIndex) {
        return of(beginIndex, endIndex, i -> i + 1);
    }

    public static Range<Double> of(double beginIndex, double endIndex) {
        return of(beginIndex, endIndex, d -> d + 0.1);
    }

}

