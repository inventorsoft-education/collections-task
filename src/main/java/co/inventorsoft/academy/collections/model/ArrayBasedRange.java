//developed by V.Havryliuk
package co.inventorsoft.academy.collections.model;

import java.util.function.Function;

import java.util.*;

//a range collection based on array
public class ArrayBasedRange<T> implements Set<T> {

    private T[] array;
    private int size = 0;
    private final int INIT_VALUE = 10;

    private ArrayBasedRange() {
        array = (T[]) new Object[INIT_VALUE];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals((T) o)) {
                return true;
            }
        }
        return false;
    }

    public Iterator<T> iterator() {
        return new RangeIterator();
    }

    public Object[] toArray() {
        T[] resultArray = (T[]) new Object[size];
        System.arraycopy(array, 0, resultArray, 0, size);
        return resultArray;
    }

    public <T1> T1[] toArray(T1[] a) {
        if (a.length < size) {
            return (T1[]) Arrays.copyOf(array, size, a.getClass());
        }
        System.arraycopy(array, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
        return a;
    }

    public boolean add(T t) {
        if (this.contains(t)) {
            return false;
        }
        array[size++] = t;
        if (array.length == size) {
            T[] newArray = (T[]) new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        return true;
    }

    public boolean remove(Object o) {
        if (this.contains(o)) {
            return false;
        }
        int i;
        for (i = 0; i < size; i++) {
            if (array[i].equals(o)) {
                array[i] = null;
                break;
            }
        }

        size--;
        for (int j = i; j < size; j++) {
            array[j] = array[j + 1];
        }
        return true;
    }

    public boolean containsAll(Collection<?> c) {
        for (Object elem : c) {
            if (!this.contains((T) elem)) {
                return false;
            }
        }
        return true;
    }

    public boolean addAll(Collection<? extends T> c) {
        for (Object elem : c) {
            if (!this.add((T) elem)) {
                return false;
            }
        }
        return true;
    }

    public boolean retainAll(Collection<?> c) {
        boolean result = false;
        for (Object elem : c) {
            if (!this.contains((T) elem)) {
                remove((T) elem);
                result = true;
            }
        }
        return result;
    }

    public boolean removeAll(Collection<?> c) {
        boolean result = false;
        for (Object elem : c) {
            if (this.contains((T) elem)) {
                remove((T) elem);
                result = true;
            }
        }
        return result;
    }

    public void clear() {
        array = (T[]) new Object[INIT_VALUE];
    }

    public static <T extends Comparable<T>> ArrayBasedRange<T> of(T from, T to, Function<T, T> function) {
        ArrayBasedRange<T> range = new ArrayBasedRange<>();
        if (from.equals(to)) {
            return range;
        }

        range.add(from);
        while (!from.equals(to)) {
            from = function.apply(from);
            range.add(from);
        }
        return range;
    }

    public static ArrayBasedRange<Double> of(Double from, Double to) {
        if (from > to) {
            return of(from, to, value -> value - 0.1);
        }

        return of(from, to, value -> value + 0.1);
    }

    public static ArrayBasedRange<Float> of(Float from, Float to) {
        if (from > to) {
            return of(from, to, value -> value - 0.1f);
        }

        return of(from, to, value -> value + 0.1f);
    }

    public static ArrayBasedRange<Integer> of(Integer from, Integer to) {
        if (from > to) {
            return of(from, to, value -> value - 1);
        }

        return of(from, to, value -> value + 1);
    }

    public static ArrayBasedRange<Byte> of(Byte from, Byte to) {
        if (from > to) {
            return of(from, to, value -> (byte) (value + 1));
        }

        return of(from, to, value -> (byte) (value + 1));
    }

    public static ArrayBasedRange<Short> of(Short from, Short to) {
        if (from > to) {
            return of(from, to, value -> (short) (value + 1));
        }

        return of(from, to, value -> (short) (value + 1));
    }

    private class RangeIterator implements Iterator<T> {
        private int it = 0;

        @Override
        public boolean hasNext() {
            return array[it] == null;
        }

        @Override
        public T next() {
            return array[it++];
        }
    }

}