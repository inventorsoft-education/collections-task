package co.inventorsoft.academy.collections.model;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;

public class Range<T> implements Set<T> {

    private TreeSet<T> data;

    public Range() {
        data = new TreeSet<>();
    }

    public static Range<Integer> of(int e1, int e2){
        Range<Integer> range = new Range<>();
        if (e1 < e2){
            for (Integer i = e1; i <= e2; i++){
                range.add(i);
            }
        }
        return range;
    }

    public static Range<Float> of(float e1, float e2){
        Range<Float> range = new Range<>();
        if (e1 < e2){
            for (Float i = e1; i <= e2; i = i + 0.1f){
                range.add(i);
            }
        }
        return range;
    }

    public static Range<Character> of(char e1, char e2, Function function){
        Range<Character> range = new Range<>();
        if (e1 < e2){
            char i = e1;
            while(i <= e2){
                range.add(i);
                i = (Character) function.apply(i);
            }
        }
        return range;
    }


    public int size() {
        return data.size();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public boolean contains(Object o) {
        return data.contains(o);
    }

    public Iterator<T> iterator() {
        return data.iterator();
    }

    public Object[] toArray() {
        return data.toArray();
    }

    public <T1> T1[] toArray(T1[] a) {
        return data.toArray(a);
    }

    public boolean add(T t) {
        return data.add(t);
    }

    public boolean remove(Object o) {
        return data.remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        return data.containsAll(c);
    }

    public boolean addAll(Collection<? extends T> c) {
        return data.addAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        return data.retainAll(c);
    }

    public boolean removeAll(Collection<?> c) {
        return data.remove(c);
    }

    public void clear() {
        data.clear();
    }
}
