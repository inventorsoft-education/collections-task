package co.inventorsoft.academy.collections.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class Range<T> implements Set<T> {


    public List<T> myList = new ArrayList<>();

    public int size() {
        return myList.size();
    }

    public boolean isEmpty() {
        return myList.isEmpty();
    }

    public boolean contains(Object o) {
        return myList.contains(o);
    }

    public Iterator<T> iterator() {
        return myList.iterator();
    }

    public Object[] toArray() {
        return myList.toArray();
    }

    public <T1> T1[] toArray(T1[] a) {
        return myList.toArray(a);
    }

    public boolean add(T t) {

        if (!myList.contains(t)) {
            return myList.add(t);
        }
        return false;
    }

    public boolean remove(Object o) {
        return myList.remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        return myList.containsAll(c);
    }

    public boolean addAll(Collection<? extends T> c) {
        for (T t : myList) {
            add(t);
        }
        return false;
    }

    public static class MyInteger implements Function<Integer, Integer> {

        @Override
        public Integer apply (Integer y) {
            return y + 1;
        }

    }
    public static Range<Integer> of(Integer first, Integer last) {
        MyInteger isA = new MyInteger();
        Range<Integer> intRange = Range.of(first, last, isA);

        return intRange;
    }


    public static class MyFloat implements Function<Float, Float> {

        @Override
        public Float apply(Float f) {
            return f + 0.1f;
        }
    }
    public static Range<Float> of(Float first, Float last) {
        Function<Float, Float> flt = new MyFloat();
        Range<Float> floatRange = Range.of(first, last, flt);

        return floatRange;
    }

    public static <T extends Comparable<T>> Range of(T first, T last, Function<T, T> rng) {
        Range<T> elementR = new Range<>();
        if (first.compareTo(last) < 0) {
            T valueR = first;
            while (valueR.compareTo(last) < 1) {
                elementR.add(valueR);
                System.out.println(valueR);
                valueR = rng.apply(valueR);
            }
        }

        return elementR;
    }


}
