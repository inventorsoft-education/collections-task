package co.inventorsoft.academy.collections.model;

import java.util.*;
import java.util.function.Function;

public class Range<T extends Comparable<T>> implements Set<T> {

    private T from;
    private T to;
    private Function<T,T> function;

    public Range(T from, T to, Function<T, T> function) {
        this.from = from;
        this.to = to;
        this.function = function;
    }

    //Short and Byte type also apply in Int
    public static Range of(Integer from, Integer to) {
        return new Range<>(from, to, integerValue -> integerValue + 1);
    }

    public static Range of(Double from, Double to) {
        return new Range<>(from, to, doubleValue -> doubleValue + 0.1d);
    }

    public static Range of(Float from, Float to) {
        return new Range<>(from, to, floatValue -> floatValue + 0.1f);
    }

    public static Range of(Character from, Character to, Function<Character, Character> function) {
        return new Range<>(from, to, function);
    }

    public int size() {
        return toArray().length;
    }

    public boolean isEmpty() {
        return from.compareTo(to) == 0;
    }

    public boolean contains(Object o) {
        T t = (T) o;
        if(t != null){
            return t.compareTo(from) >= 0 && t.compareTo(to) <= 0;
        }else{
            return false;
        }
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
                    next = from;
                }
                return next.compareTo(to) <= 0;
            }

            @Override
            public T next() {
                if(cursor == null){
                    cursor = from;
                    return cursor;
                }
                if(cursor.compareTo(to)>0){
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
        if(t.compareTo(from) > 0){
            if(t.compareTo(to) < 0){
                return false;
            }
            to = t;
            return true;
        }else {
            from = t;
            return true;
        }
    }

    public boolean remove(Object o) {
        if(contains(o)){
            to = (T) o;
            return true;
        }else {
            return false;
        }
    }


    public boolean containsAll(Collection<?> c) {
        return c.stream()
                .filter(this::contains)
                .count() == c.size();
    }

    //not use
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }
    //not use
    public boolean retainAll(Collection<?> c) {
        return false;
    }
    //not use
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    public void clear() {
        to = from;
    }
}