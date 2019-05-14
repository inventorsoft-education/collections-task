package co.inventorsoft.academy.collections.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.function.Function;

public class Range<T> implements Set<T> {

    private Set<T> set = new TreeSet<>();

    private Range() {

    }

    public static Range<Byte> of(Byte from, Byte to){
        Range<Byte> range = new Range<>();
        range.buildRangeSet(from, to, t1 -> (byte)(t1 + 1));
        return range;
    }

    public static Range<Short> of(Short from, Short to){
        Range<Short> range = new Range<>();
        range.buildRangeSet(from, to, t1 -> (short)(t1 + 1));
        return range;
    }

    public static Range<Integer> of(Integer from, Integer to){
        Range<Integer> range = new Range<>();
        range.buildRangeSet(from, to, t1 -> t1 + 1);
        return range;
    }

    public static Range<Long> of(Long from, Long to){
        Range<Long> range = new Range<>();
        range.buildRangeSet(from, to, t1 -> t1 + 1);
        return range;
    }

    public static Range<Float> of(Float from, Float to){
        Range<Float> range = new Range<>();
        from = BigDecimal.valueOf(from).setScale(1, RoundingMode.HALF_UP).floatValue();
        range.buildRangeSet(from, to, t1 -> t1 + 0.1f);
        return range;
    }

    public static Range<Double> of(Double from, Double to){
        Range<Double> range = new Range<>();
        from = BigDecimal.valueOf(from).setScale(1, RoundingMode.HALF_UP).doubleValue();
        range.buildRangeSet(from, to, t1 -> t1 + 0.1);
        return range;
    }

    public static <T1 extends Comparable> Range<T1> of(T1 from, T1 to, Function<T1,T1> function){
        Range<T1> range = new Range<>();
        range.buildRangeSet(from,to,function);
        return range;
    }

    private void buildRangeSet(T from, T to, Function<T,T> function){
        if (from.equals(to)){
            return;
        }

        //add first range element into set
        set.add(from);
        do {
            from = function.apply(from); // calculate next value
            set.add(from);//add range element into set
        }
        while (!from.equals(to));
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
        return set.removeAll(c);
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
        return set.hashCode();
    }
}
