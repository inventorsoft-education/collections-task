package co.inventorsoft.academy.collections.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class Range<T> implements Set<T> {


    public List<T> MyList = new ArrayList<>();

    public int size() {
        return MyList.size();
    }

    public boolean isEmpty() {
        return MyList.isEmpty();
    }

    public boolean contains(Object o) {
        return MyList.contains(o);
    }

    public Iterator<T> iterator() {
        return MyList.iterator();
    }

    public Object[] toArray() {
        return MyList.toArray();
    }

    public <T1> T1[] toArray(T1[] a) {
        return MyList.toArray(a);
    }

    public boolean add(T t) {

        if (!MyList.contains(t)) {
            return MyList.add(t);
        }
        return false;
    }

    public boolean remove(Object o) {
        return MyList.remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        return MyList.containsAll(c);
    }

    public boolean addAll(Collection<? extends T> c) {
        for (T t : MyList) {
            add(t);
        }
        return false;
    }

    public boolean retainAll(Collection<?> c) {
        return MyList.retainAll(c);
    }

    public boolean removeAll(Collection<?> c) {
        return MyList.removeAll(c);
    }

    public void clear() {
        MyList.clear();

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