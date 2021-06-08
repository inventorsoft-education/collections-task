package co.inventorsoft.academy.collections.model;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class RangeIterator<T extends Comparable<T>> implements Iterator<T> {
    private T current;
    private final T last;
    private final Function<T, T> increment;

    public RangeIterator(T first, T last, Function<T, T> increment) {
        this.current = first;
        this.increment = increment;

        // I incrementing last limit because of strict limits
        this.last = this.increment.apply(last);
    }

    /**
     * Compares last and next value of given range
     * @return true if next <= last
     */

    @Override
    public boolean hasNext() {
        T last = this.last;
        T next = this.increment.apply(current);
        return next.compareTo(last) <= 0;
    }

    // get next value

    /**
     * Returns next value of range if it exists
     * Throws NoSuchElementException if does not
     * @return next element of range
     */
    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        // I need this var because of strict limits
        T data = this.current;
        this.current = this.increment.apply(current);
        return data;
    }

}
