package co.inventorsoft.academy.collections.model;

import java.util.*;
import java.util.function.Function;

public class Range<T extends Comparable> extends AbstractSet<T> implements Set<T> {

    Set<T> set;

    private Range(T first, T last, Function<T, T> function){
        set = new TreeSet<T>();

        if (first.compareTo(last) == 0){
            return;
        }

        while (first.compareTo(last) <= 0){
            set.add(first);
            first = function.apply(first);
        }
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

    public int size() {
        return set.size();
    }

    public boolean add(T t){
        return set.add(t);
    }

    public Iterator<T> iterator() {
        return set.iterator();
    }
}
