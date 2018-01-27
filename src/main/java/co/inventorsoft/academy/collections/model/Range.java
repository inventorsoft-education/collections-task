package co.inventorsoft.academy.collections.model;

import java.util.*;
import java.util.function.Function;

public class Range<T extends Comparable> extends AbstractSet<T> implements Set<T> {

    private T first;
    private T last;
    private Function<T,T> function;

    private Range(T first, T last, Function<T, T> function){

        this.first = first;
        this.last = last;
        this.function = function;
    }

    public static Range<Integer> of(Integer firstItem, Integer lastItem) {
        return new Range<>(firstItem,lastItem, integer -> integer + 1);
    }

    public static Range<Float> of(Float firstItem, Float lastItem) {
        return new Range<>(firstItem, lastItem, floatItem -> floatItem + 0.1f);
    }

    public static Range<Character> of(Character firstItem, Character lastItem, Function<Character, Character> function) {
        return new Range<>(firstItem,lastItem,function);
    }

    public boolean contains(Object o) {
        T t = (T) o;
        if(t == null){
            return false;
        } else {
            return t.compareTo(first) >= 0 && t.compareTo(last) <= 0;
        }
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {

            T current;

            @Override
            public boolean hasNext() {
                if(current == null) {
                    return first.compareTo(last) <= 0;
                } else {
                    T next = function.apply(current);
                    return next.compareTo(last) <= 0;
                }
            }

            @Override
            public T next() {
                if(current == null){
                    current = first;
                    return current;
                }
                if(current.compareTo(last)>0){
                    return null;
                }
                current = function.apply(current);
                return current;
            }
        };
    }

    public int size() {
        return toArray().length;
    }

    public boolean isEmpty() {
        return first.compareTo(last) == 0;
    }

    public boolean add(T t) {
        if(t.compareTo(first) > 0){
            if(t.compareTo(last) < 0){
                return false;
            }
            last = t;
            return true;
        } else {
            first = t;
            return true;
        }
    }

    public Object[] toArray() {
        List<T> list = new ArrayList<>();
        for (T t : this) {
            list.add(t);
        }
        return list.toArray();
    }

}
