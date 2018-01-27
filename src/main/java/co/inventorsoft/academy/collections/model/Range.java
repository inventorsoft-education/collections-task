package co.inventorsoft.academy.collections.model;

import java.util.*;
import java.util.function.Function;

public class Range<T extends Comparable<T>> implements Set<T> {

    private T from;
    private T to;
    private Function<T, T> increment;

    private Range(T from, T to, Function<T, T> increment) {
        this.from = from;
        this.to = to;
        this.increment = increment;
    }

    public static Range<Integer> of(Integer from, Integer to) {
        return new Range<>(from, to, intValue -> intValue + 1);
    }

    public static Range<Double> of(Double from, Double to) {
        return new Range<>(from, to, doubleValue -> doubleValue + 0.1);
    }

    public static Range<Float> of (Float from, Float to) {
        return new Range<>(from, to, floatValue -> floatValue + 0.1f);
    }

    public static Range<Character> of(Character from, Character to, Function<Character, Character> function) {
        return new Range<>(from, to, function);
    }

    public int size() {
        return this.toArray().length;
    }

    public boolean isEmpty() {
        return from.compareTo(to) == 0;
    }

    @SuppressWarnings("unchecked")
    public boolean contains(Object o) {
        T t = (T) o;
        assert t != null;
        return t.compareTo(from) >= 0 && t.compareTo(to) <= 0;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            T current;

            @Override
            public boolean hasNext() {
                T next;
                if (current != null) {
                    next = increment.apply(current);
                } else {
                    next = from;
                }
                return next.compareTo(to) <= 0;

            }

            @Override
            public T next() {
                if (current == null) {
                    current = from;
                    return current;
                }

                if (current.compareTo(to) > 0) {
                    return null;
                }

                current = increment.apply(current);
                assert current != null;
                return current;
            }
        };
    }

    public Object[] toArray() {
        List<T> range = new ArrayList<>();
        for (T t : this) {
            range.add(t);
        }
        return range.toArray();
    }

    public <T1> T1[] toArray(T1[] a) {
        List<T> range = new ArrayList<>();
        for (T t : this) {
            range.add(t);
        }
        return range.toArray(a);
    }

    public boolean add(T t) {
        if (t.compareTo(from) > 0) {
            if (t.compareTo(to) < 0) {
                return false;
            }
            to = t;
            return true;
        } else {
            from = t;
            return true;
        }
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
        to = from;
    }
}
