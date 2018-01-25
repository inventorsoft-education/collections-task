package co.inventorsoft.academy.collections.model;

import java.util.*;
import java.util.function.Function;

public class Range<T extends Comparable<T>> implements Set<T> {

    private T start;
    private T end;
    private List<T> items;

    public Range(T start, T end, Function<T, T> function) {
        this.start = start;
        this.end = end;
        items = new ArrayList<>();
        for (T i = start; i.compareTo(end) <= 0; i = function.apply(i)) {
            items.add(i);
        }
    }

    public static Range of(Integer start, Integer end) {
        return new Range<>(start, end, new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer + 1;
            }
        });
    }

    public static Range of(Double start, Double end) {
        return new Range<>(start, end, new Function<Double, Double>() {
            @Override
            public Double apply(Double num) {
                return num + 0.1D;
            }
        });
    }

    public static Range of(Float start, Float end) {
        return new Range<>(start, end, new Function<Float, Float>() {
            @Override
            public Float apply(Float num) {
                return num + 0.1f;
            }
        });
    }

    public static Range of(Character start, Character end) {
        return new Range<>(start, end, new Function<Character, Character>() {
            @Override
            public Character apply(Character character) {
                return (char) (character + 1);
            }
        });
    }

    public static Range of(Character start, Character end, Function function) {
        return new Range<>(start, end, function);
    }

    public int size() {
        return items.size();
    }

    public boolean isEmpty() {
        return items.size()==0;
    }

    public boolean contains(Object o) {
        return items.contains(o);
    }

    public Iterator<T> iterator() {
        return items.iterator();
    }

    public Object[] toArray() {
        return items.toArray();
    }

    public <T1> T1[] toArray(T1[] a) {
        return items.toArray(a);
    }

    public boolean add(T t) {
        return false;
    }

    public boolean remove(Object o) {
        return false;
    }

    public boolean containsAll(Collection<?> c) {
        return false;
    }

    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    public boolean retainAll(Collection<?> c) {
        return false;
    }

    public boolean removeAll(Collection<?> c) {
        return false;
    }

    public void clear() {

    }
}
