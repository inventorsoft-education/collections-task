package co.inventorsoft.academy.collections.model;

import java.util.*;
import java.util.function.Function;

public class Range<T> implements Set<T> {

    private ArrayList<T> elementData  = new ArrayList<>();
    private T to;
    private T from;

    public Range(T from, T to, Function<T, T> function) {
        this.from = from;
        this.to = to;

        do{
            this.elementData.add(from);
            from = function.apply(from);
        }
        while (!(from.equals(to)));
        this.elementData.add(to);
       /* while (function.apply(from)) {
            this.elementData.add(from);
        }*/
    }


    public static Range<Integer> of(Integer from, Integer to) {
        Range<Integer> range = new Range<>(from, to, intValue -> intValue + 1);
        range.from = from;
        range.to = to;
        for(Integer j = range.from; j<=range.to; j++){
            range.add(j);
        }
        return range;

    }

    public static Range<Float> of(Float from, Float to) {
        Range<Float> range = new Range<>(from, to, intValue -> intValue + 1);
        range.from = from;
        range.to = to;
        for(Float j = from; j<=to; j=j+0.1f){
            range.add(j);
        }
        return range;

    }

    public static Range<Character> of(char from, char to, Function<Character, Character> characterCharacterFunction) {
        return new Range<>(from, to, characterCharacterFunction);
    }

    public int size() {
        return this.elementData.size();
    }

    public boolean isEmpty() { return this.elementData.isEmpty();}

    public boolean contains(Object o) {
        return this.elementData.indexOf(o) >= 0;
    }

    public Iterator<T> iterator() {
        Iterator iterator = this.elementData.iterator();
        return iterator;
    }

    public Object[] toArray() {
        return this.elementData.toArray();
    }

    public <T1> T1[] toArray(T1[] a) {
        return this.elementData.toArray(a);
    }


    public boolean add(T t) {

        if(this.elementData.indexOf(t) >= 0){
            return false;
        }

        this.elementData.add(t);
        return true;
    }

    public boolean remove(Object o) {

        return  this.elementData.remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        return this.elementData.containsAll(c);
    }

    public boolean addAll(Collection<? extends T> c) {
        return this.elementData.addAll(c);
    }

    public boolean retainAll(Collection<?> c) {

        return this.elementData.retainAll(c);
    }

    public boolean removeAll(Collection<?> c) {

        return this.elementData.removeAll(c);
    }

    public void clear() {
        this.elementData.clear();
    }

   /* @Override
    public int compareTo(Object o) {
        if(this == o)
            return 0;
        return 1;
    }*/
}
