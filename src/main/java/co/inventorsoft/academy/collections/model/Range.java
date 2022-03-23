package co.inventorsoft.academy.collections.model;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Function;


public class Range<T> implements Set<T> {
    private Set<T> mySetlist = new java.util.HashSet<>();

    private  Range() {
    }

    public static Range of(int i, int i1) {

        Range<Integer> intRange = Range.of(i, i1, i2 -> (int) (i2 + 1));
        return intRange;
    }

    public static Range of(float i, float i1) {
        Range<Float> floatRange = Range.of(i, i1, i2 -> (float) (i2 + 0.1));
        return floatRange;

    }


    public int size() {
        return mySetlist.size();
    }

    public boolean isEmpty() {
        return mySetlist.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return mySetlist.contains(o);
    }

    @Override
    public Iterator iterator() {
        return mySetlist.iterator();
    }

    @Override
    public Object[] toArray() {
        return mySetlist.toArray();
    }

    @Override
    public boolean remove(Object o) {
        return mySetlist.remove(o);
    }

    public boolean addAll(Collection<? extends T> c) {
        return mySetlist.addAll(c) ;
    }

    @Override
    public void clear() {
        mySetlist.clear();
    }

    @Override
    public boolean removeAll(Collection c) {
        return mySetlist.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection c) {

        return mySetlist.retainAll(c);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return mySetlist.containsAll(c);
    }

    @Override
    public <T1> T1[] toArray(T1[] o) {
        return mySetlist.toArray(o);
    }


    public boolean add(T t) {
        if (!mySetlist.contains(t)) {
            return mySetlist.add(t);
        }
        return false;
    }


    public static <T extends Comparable<T>> Range of(T a, T b, Function<T, T> rg) {
        Range<T> elem = new Range<>();
        if (a.compareTo(b) < 0) {
            T value = a;
            while (value.compareTo(b) < 1) {
                elem.add(value);
                value = rg.apply(value);
            }
        }
        return elem;
    }


}
