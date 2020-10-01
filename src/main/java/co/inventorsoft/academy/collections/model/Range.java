package co.inventorsoft.academy.collections.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Function;

public class Range<T> implements Set<T> {

    private HashSet<T> range;

    public Range(){
        range = new HashSet<T>();
    }

    public int size() {
        return range.size();
    }

    public boolean isEmpty() {
        return range.isEmpty();
    }

    public boolean contains(Object o) {
        return range.contains(o);
    }

    public Iterator<T> iterator() {
        return range.iterator();
    }

    public Object[] toArray() {
        return range.toArray();
    }

    public <T1> T1[] toArray(T1[] a) {
        return (T1[]) range.toArray(a);
    }

    public boolean add(T t) {
        return range.add(t);
    }

    public boolean remove(Object o) {
        return range.remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        return range.containsAll(c);
    }

    public boolean addAll(Collection<? extends T> c) {
        return range.addAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        return range.retainAll(c);
    }

    public boolean removeAll(Collection<?> c) {
        return range.removeAll(c);
    }

    public void clear() {
        range.clear();
    }


    public static Range<Integer> of( int element1, int element2){
        Range<Integer> rInt = new Range<>();
        if(element1 == element2){
            return rInt;
        }
        for(int i=element1;i<=element2;i++){
            rInt.add(i);
        }
        return rInt;
    }

    public static Range<Float> of( float element1, float element2){
        Range<Float> rFloat = new Range<>();
        if(element1 == element2){
            return rFloat;
        }
        for(float i=element1;i<=element2;i=i+0.1f){
            rFloat.add(i);
        }
        return rFloat;
    }

    static <T extends Comparable> Range<T> of(T start, T end, Function<T, T> function) {
        Range<T> rT = new Range<>();
        if (start.equals(end)) {
            return rT;
        }
        while (start.compareTo(end)<=0) {
            rT.add(start);
            start = function.apply(start);
        }
        return rT;
    }
}
