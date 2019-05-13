package co.inventorsoft.academy.collections.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.function.Function;

public class Range<T> implements Set<T> {

    private Set<T> set = new TreeSet<>();

    private Range() {
    }

    public static <T1 extends Number> Range<T1> of(T1 from, T1 to){
        Range<T1> range = new Range<>();
        if (!from.equals(to)){
            range.buildNumberRangeSet(from,to);
        }
        return range;
    }

    public static <T1> Range<T1> of(T1 from, T1 to, Function<T1,T1> function){
        Range<T1> range = new Range<>();
        if (!from.equals(to) && from instanceof Comparable){
            //add first range element into set
            range.set.add(from);
            do {
                from = function.apply(from); // calculate next value
                range.set.add(from);//add range element into set
            }
            while (!from.equals(to));

        }
        return range;
    }

    private void buildNumberRangeSet(T from, T to) {
        //identifying type of number
        if (from instanceof Byte) buildNumberRangeSet((Byte)from, (Byte)to);
        else if (from instanceof Short) buildNumberRangeSet((Short)from, (Short)to);
        else if (from instanceof Integer) buildNumberRangeSet((Integer)from, (Integer)to);
        else if (from instanceof Long) buildNumberRangeSet((Long)from, (Long)to);
        else if (from instanceof Float) buildNumberRangeSet((Float)from, (Float)to);
        else if (from instanceof Double) buildNumberRangeSet((Double)from, (Double)to);
    }

    private void buildNumberRangeSet(Byte from, Byte to){
        //building a range set
        while (from <= to){
            set.add((T) from);
            from = (byte)(from+1);
        }
    }

    private void buildNumberRangeSet(Short from, Short to){
        //building a range set
        set.clear();
        while (from <= to){
            set.add((T) from);
            from = (short)(from+1);
        }
    }

    private void buildNumberRangeSet(Integer from, Integer to){
        //building a range set
        while (from <= to){
            set.add((T) from);
            from +=1;
        }
    }

    private void buildNumberRangeSet(Long from, Long to){
        //building a range set
        while (from <= to){
            set.add((T) from);
            from = (long)(from+1);
        }

    }

    private void buildNumberRangeSet(Float from, Float to){
        //setting one digit precision after comma
        from = BigDecimal.valueOf(from).setScale(1, RoundingMode.HALF_UP).floatValue();

        //building a range set
        while (from <= to){
            set.add((T) from);
            from += 0.1f;
        }
    }

    private void buildNumberRangeSet(Double from, Double to){
        //setting one digit precision after comma
        from = BigDecimal.valueOf(from).setScale(1, RoundingMode.HALF_UP).doubleValue();

        //building a range set
        while (from <= to){
            set.add((T) from);
            from += 0.1f;
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
