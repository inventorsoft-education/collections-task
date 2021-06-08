package co.inventorsoft.academy.collections.model;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Function;

public class Range<T extends Comparable<T>> implements Set<T> {
    private final T first;
    private final T last;
    private final Function<T, T> increment;

    private final int size;

    private Range(T first, T last, Function<T, T> increment) {
        this.first = first;
        this.last = last;
        this.increment = increment;

        int size = 0;
        for (T ignored : this) {
            size++;
        }
        this.size = size;
    }

    public static Range<Integer> of(int first, int last) {
        return new Range<>(first, last, element -> element + 1);
    }
    public static Range<Long> of(long first, long last) {
        return new Range<>(first, last, element -> element + 1);
    }
    public static Range<Float> of(float first, float last) {
        return new Range<>(first, last, element -> element + 0.1f);
    }
    public static Range<Double> of(double first, double last) {
        return new Range<>(first, last, element -> element + 0.1);
    }
    public static <T extends Comparable<T>> Range<T> of(T first, T last, Function<T, T> increment) {
        return new Range<>(first, last, increment);
    }

    public int size() {
        return this.size;
    }
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Returns true if range contains element
     * @param element must to be T type
     * @return true if element in range
     */
    public boolean contains(Object element) {
        T tElement = (T) element;
        return this.first.compareTo(tElement) <= 0 && this.last.compareTo(tElement) >= 0;
    }

    /**
     * Returns true if range contains every element of collection
     * @param collection consist of found elements
     * @return true if range contains every element of collection
     */
    public boolean containsAll(Collection<?> collection) {
        boolean result = true;
        for (Object element: collection) {
            T tElement = (T) element;
            if (this.first.compareTo(tElement) > 0 || this.last.compareTo(tElement) < 0) {
                result = false;
                break;
            }
        }
        return result;
    }

    public Iterator<T> iterator() {
        return new RangeIterator<>(this.first, this.last, this.increment);
    }

    /**
     * Creates and returns array of range elements
     * @return array
     */
    public Object[] toArray() {
        Iterator<T> iterator = this.iterator();
        Object[] array = new Object[this.size];
        for (int i = 0; i < size; i++) {
            array[i] = iterator.next();
        }
        return array;
    }

    /**
     * Writes all values from range to array
     * @param array consist of range elements
     * @return that array
     */
    public <T1> T1[] toArray(T1[] array) {
        if (array.length != this.size) {
            throw new ArrayStoreException();
        }
        Iterator<T1> iterator = (Iterator<T1>) this.iterator();
        for (int i = 0; i < this.size; i++) {
            array[i] = iterator.next();
        }
        return array;
    }

    /**
     * those methods are unsupported because range is an immutable collection
     */
    public void clear() {
        throw new UnsupportedOperationException();
    }
    public boolean add(T t) {
        throw new UnsupportedOperationException();
    }
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }
}
