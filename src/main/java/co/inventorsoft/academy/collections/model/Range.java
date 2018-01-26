package co.inventorsoft.academy.collections.model;

import java.util.*;
import java.util.function.Function;

public class Range<T extends Comparable<T>> implements Set<T> {

    private T start;
    private T end;
    private Function<T,T> function;

    public Range(T start, T end, Function<T, T> function) {
        this.start = start;
        this.end = end;
        this.function = function;
    }

    public static Range of(Integer start, Integer end) {
        return new Range<>(start, end, integer -> integer + 1);
    }

    public static Range of(Double start, Double end) {
        return new Range<>(start, end, aDouble -> aDouble + 0.1d);
    }

    public static Range of(Float start, Float end) {
        return new Range<>(start, end, aFloat -> aFloat + 0.1f);
    }

    public static Range of(Character start, Character end) {
        return new Range<>(start, end, character -> (char) (character + 1));
    }

    public static Range of(Character start, Character end, Function function) {
        return new Range<>(start, end, function);
    }

    public int size() {
        return toArray().length;
    }

    public boolean isEmpty() {
        return start.compareTo(end) == 0;
    }

    public boolean contains(Object o) {
        T t = (T) o;
        return t.compareTo(start) > 0 && t.compareTo(end) < 0;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            T cursor;
            @Override
            public boolean hasNext() {
                T next;
                if(cursor != null) {
                     next = function.apply(cursor);
                }else{
                    next = start;
                }
                return next.compareTo(end) <= 0;
            }

            @Override
            public T next() {
                if(cursor == null){
                    cursor = start;
                    return cursor;
                }
                if(cursor.compareTo(end)>0){
                    throw new NoSuchElementException();
                }
                cursor = function.apply(cursor);
                return cursor;
            }
        };
    }

    public Object[] toArray() {
        List<T> list = new ArrayList<>();
        Iterator<T> iter = this.iterator();
        while (iter.hasNext()){
            list.add(iter.next());
        }
        return list.toArray();
    }

    public <T1> T1[] toArray(T1[] a) {
        List<T> list = new ArrayList<>();
        Iterator<T> iter = this.iterator();
        while (iter.hasNext()){
            list.add(iter.next());
        }
        return list.toArray(a);
    }

    public boolean add(T t) {
        if(t.compareTo(start) > 0){
            if(t.compareTo(end) < 0){
                return false;
            }
            end = t;
            return true;
        }else {
            start = t;
            return true;
        }
    }

    public boolean remove(Object o) {
        T t = (T) o;
        if(t.compareTo(start) > 0){
            if(t.compareTo(end) < 0){
                end = t;
                return true;
            }
            return false;
        }else {
            return false;
        }
    }

    public boolean containsAll(Collection<?> c) {
         return c.stream()
                 .map(this::contains)
                 .filter(elem -> elem)
                 .count() == c.size();
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
        end = start;
    }

    public static void main(String[] args) {
        Range.of(1, 5).forEach(System.out::println);
        Range.of('a', 'f').forEach(System.out::println);
        Range<Integer> range = Range.of(1,  8);
        System.out.println(range.containsAll(Arrays.asList(3,5,7,9)));
    }
}
