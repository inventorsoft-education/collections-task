package co.inventorsoft.academy.collections.model;

import java.util.*;
import java.util.function.Function;

public class Range<T> implements Set<T> {

    private List<T> list;

    private Range() {
        list = new ArrayList<>();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public boolean contains(Object o) {
        return list.contains(o);
    }

    public Iterator<T> iterator() {
        return list.iterator();
    }

    public Object[] toArray() {
        return list.toArray();
    }

    public <T1> T1[] toArray(T1[] a) {
        return (T1[])list.toArray(a);
    }

    public boolean add(T t) {
        return list.add(t);
    }

    public boolean remove(Object o) {
        return list.remove(o);
    }

    public boolean containsAll(Collection<?> c) {
       return list.containsAll(c);
    }

    public boolean addAll(Collection<? extends T> c) {
        return list.addAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        return list.retainAll(c);
    }

    public boolean removeAll(Collection<?> c) {
      return list.removeAll(c);
    }

    public void clear() {
        list.clear();
    }

    //AtomicInteger, AtomicLong, BigDecimal, BigInteger, Byte, Double, Float, Integer, Long, Short

    static Range<Character> of(char firstElement, char lastElement, Function<Character, Character> function) {
        Range<Character> range = new Range<>();
        range.add(firstElement);
        while (firstElement != lastElement) {
            firstElement = function.apply(firstElement);
            range.add(firstElement);
        }
        return range;
    }

    static Range<Integer> of(int firstElement, int lastElement){
        Range<Integer> range = new Range<>();
        int step = firstElement;
        if(firstElement == lastElement){
            return range;
        } else {
            while (firstElement != lastElement){
                range.add(firstElement);
                firstElement = firstElement + step;
            }
            range.add(firstElement);
            return range;
        }
    }

    static Range<Float> of(float firstElement, float lastElement){
        Range<Float> range = new Range<>();
        float step = firstElement;
        if(firstElement == lastElement){
            return range;
        } else {
            while (firstElement != lastElement){
                range.add(firstElement);
                firstElement = firstElement + step;
            }
            range.add(firstElement);
            return range;
        }
    }

}