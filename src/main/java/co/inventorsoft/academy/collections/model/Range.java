package co.inventorsoft.academy.collections.model;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

public class Range<T extends Comparable<T>> implements Set<T> {
    private final Set<T> excluded = new HashSet<>();
    private T start;
    private T end;
    private final Function<T, T> next;

    private Range(T start, T end, Function<T, T> next) {
        this.start = start;
        this.end = end;
        this.next = next;
    }

    public static <T extends Comparable<T>> Range<T> of(T start, T end, Function<T, T> next) {
        return new Range<>(start, end, next);
    }

    public static Range<Double> of(Double start, Double end) {
        return of(start, end, current -> current + 0.1D);
    }

    public static Range<Float> of(Float start, Float end) {
        return of(start, end, current -> current + 0.1F);
    }

    public static Range<Long> of(Long start, Long end) {
        return of(start, end, current -> current + 1L);
    }

    public static Range<Integer> of(Integer start, Integer end) {
        return of(start, end, current -> current + 1);
    }

    public static Range<Short> of(Short start, Short end) {
        return of(start, end, current -> (short) (current + 1));
    }

    public static Range<Byte> of(Byte start, Byte end) {
        return of(start, end, current -> (byte) (current + 1));
    }

    boolean isBetween(T element) {
        return element.compareTo(start) >= 0 && element.compareTo(end) <= 0;
    }

    boolean isBefore(T element) {
        return element.compareTo(start) < 0;
    }

    boolean isAfter(T element) {
        return element.compareTo(end) > 0;
    }

    public int size() {
        int size = 0;
        for (T t : this) {
            size++;
        }
        return size;
    }

    public boolean isEmpty() {
        return size() == 1;
    }

    public boolean contains(Object o) {
        T value = (T) o;
        return isBetween(value);
    }

    public Iterator<T> iterator() {

        return new Iterator<T>() {
            T current = start;

            @Override
            public boolean hasNext() {
                while (current.compareTo(end) <= 0 && excluded.contains(current)) {
                    current = next.apply(current);
                }
                return current.compareTo(end) <= 0;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T result = current;
                current = next.apply(current);
                return result;
            }
        };
    }

    public Object[] toArray() {
        Object[] array = new Object[size()];
        int i = 0;
        for (T t : this) {
            array[i++] = t;
        }

        return array;
    }

    public <T1> T1[] toArray(T1[] a) {
        int size = size();
        if (a.length < size) {
            a = (T1[]) Array.newInstance(a.getClass().getComponentType(), size);
        } else if (a.length > size) {
            a[size] = null;
        }

        int i = 0;
        for (T t : this) {
            a[i++] = (T1) t;
        }

        return a;
    }

    public boolean add(T t) {
        if (isBetween(t)) {
            excluded.remove(t);
            return true;
        }
        return false;
    }

    public boolean remove(Object o) {
        if (!(o instanceof Comparable)) {
            return false;
        }
        T value = (T) o;

        if (isBetween(value)) {
            excluded.add(value);
            return true;
        }
        return false;
    }

    public boolean containsAll(Collection<?> c) {
        return c.stream().allMatch(e -> isBetween((T) e) && !excluded.contains(e));
    }

    public boolean addAll(Collection<? extends T> c) {
        return c.stream().anyMatch(this::isBetween);
    }

    @SuppressWarnings("unchecked")
    public boolean retainAll(Collection<?> c) {
        Optional<T> min = (Optional<T>) c.stream().min((o1, o2) -> ((T) o1).compareTo((T) o2));
        Optional<T> max = (Optional<T>) c.stream().max((o1, o2) -> ((T) o1).compareTo((T) o2));

        if (min.isPresent()) {
            start = min.get();
            end = max.get();
            return true;
        }
        return false;
    }

    public boolean removeAll(Collection<?> c) {
        return excluded.addAll((Collection<? extends T>) c);
    }

    public void clear() {
        end = start;
    }

    public T getStart() {
        return start;
    }

    public T getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "Range{" +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
