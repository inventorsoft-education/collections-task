package co.inventorsoft.academy.collections.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.function.Function;

public class Range<T> implements Set<T> {

    private Set<T> set = new TreeSet<>();

    private Range() {
    }

    public static <T1 extends Number> Range<T1> of(T1 a, T1 b){
        Range<T1> range = new Range<>();
        if (!a.equals(b)){
            range.buildNumberRangeSet(a,b);
        }
        return range;
    }

    public static <T1> Range<T1> of(T1 a, T1 b, Function<T1,T1> function){
        Range<T1> range = new Range<>();
        if (!a.equals(b) && a instanceof Comparable){
            //add first range element into set
            range.set.add(a);
            do {
                a = function.apply(a); // calculate next value
                range.set.add(a);//add range element into set
            }
            while (!a.equals(b));

        }
        return range;
    }

    private void buildNumberRangeSet(T a, T b) {
        //identifying type of number
        if (a instanceof Byte) buildNumberRangeSet((Byte)a, (Byte)b);
        else if (a instanceof Short) buildNumberRangeSet((Short)a, (Short)b);
        else if (a instanceof Integer) buildNumberRangeSet((Integer)a, (Integer)b);
        else if (a instanceof Long) buildNumberRangeSet((Long)a, (Long)b);
        else if (a instanceof Float) buildNumberRangeSet((Float)a, (Float)b);
        else if (a instanceof Double) buildNumberRangeSet((Double)a, (Double)b);
    }

    private void buildNumberRangeSet(Byte a, Byte b){
        //building a range set
        while (a <= b){
            set.add((T) a);
            a = (byte)(a+1);
        }
    }

    private void buildNumberRangeSet(Short a, Short b){
        //building a range set
        set.clear();
        while (a <= b){
            set.add((T) a);
            a = (short)(a+1);
        }
    }

    private void buildNumberRangeSet(Integer a, Integer b){
        //building a range set
        while (a <= b){
            set.add((T) a);
            a +=1;
        }
    }

    private void buildNumberRangeSet(Long a, Long b){
        //building a range set
        while (a <= b){
            set.add((T) a);
            a = (long)(a+1);
        }

    }

    private void buildNumberRangeSet(Float a, Float b){
        //setting one digit precision after comma
        a = BigDecimal.valueOf(a).setScale(1, RoundingMode.HALF_UP).floatValue();

        //building a range set
        while (a <= b){
            set.add((T) a);
            a += 0.1f;
        }
    }

    private void buildNumberRangeSet(Double a, Double b){
        //setting one digit precision after comma
        a = BigDecimal.valueOf(a).setScale(1, RoundingMode.HALF_UP).doubleValue();

        //building a range set
        while (a <= b){
            set.add((T) a);
            a += 0.1f;
        }
    }


    public int size() {
        return set.size();
    }

    public boolean isEmpty() {
        return set.size() == 0;
    }

    public boolean contains(Object o) {
        return set.contains(o);
    }

    public Iterator<T> iterator() {
        return set.iterator();
    }

    public Object[] toArray() {
        return set.toArray();
    }

    public <T1> T1[] toArray(T1[] a) {
        return set.toArray(a);
    }

    public boolean add(T t) {
        return set.add(t);
    }

    public boolean remove(Object o) {
        return set.remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        return set.containsAll(c);
    }

    public boolean addAll(Collection<? extends T> c) {
        return set.addAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        return set.retainAll(c);
    }

    public boolean removeAll(Collection<?> c) {
        return set.retainAll(c);
    }

    public void clear() {
        set.clear();
    }

    @Override
    public String toString() {
        return set.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Range<?> range = (Range<?>) o;

        return Objects.equals(set, range.set);

    }

    @Override
    public int hashCode() {
        return set != null ? set.hashCode() : 0;
    }
}
