package co.inventorsoft.academy.collections.model;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Function;

public class Range<T extends Comparable<T>> implements Set<T>  {
    private T from;
    private T to;
    private List<T> rangeList;
    private Range(T from, T to) {
        rangeList = new ArrayList<T>();
        this.from=from;
        this.to=to;

    }

    public int size() {
        return toArray().length;
    }

    public boolean isEmpty() {
        return from.compareTo(to) == 0;
    }

    public boolean contains(Object o) {
        return rangeList.contains(o);
    }

    public Iterator<T> iterator() {
        return rangeList.iterator();
    }

    public Object[] toArray() {
        List<T> rangeList = new ArrayList<>();
        for (T t : this) {
            rangeList.add(t);
        }
        return rangeList.toArray();
    }

    public <T1> T1[] toArray(T1[] a) {
        List<T> range = new ArrayList<>();
        for (T t : this) {
            range.add(t);
        }
        return range.toArray(a);
    }

    public boolean add(T t) {
        if (rangeList.contains(t))
            return false;
          else return rangeList.add(t);

    }

    public boolean remove(Object o) {
        return rangeList.remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        return rangeList.containsAll(c);
    }

    public boolean addAll(Collection<? extends T> c) {
        if (c.isEmpty()) {
            return false;
        } else {
            for (T l : c) {
                if (!rangeList.contains(l)) {
                    rangeList.add(l);
                }
            }
            return true;
        }
    }

    public boolean retainAll(Collection<?> c) {
        return rangeList.retainAll(c);
    }

    public boolean removeAll(Collection<?> c) {
        return false;
    }

    public void clear() {
        rangeList.clear();

    }

    public static <T extends Comparable<T>> Range<T> of(T from, T to, Function<T, T> increment) {
        Range<T> range = new Range<T>( from, to);
        if (from.compareTo(to) == 0) {
            return range;
        }

        T next = from;
        while (next.compareTo(to) <= 0) {
            range.add(next);
            next = increment.apply(next);
        }
        return range;
    }


    public static Range<Float> of(Float from, Float to) {
        return of(from, to, new Function<Float, Float>() {

            public Float apply(Float aFloat) {
                return aFloat + 0.1f;
            }
        });
    }


    public static Range<Integer> of(Integer from, Integer to) {
        return of(from, to, new Function<Integer, Integer>() {

            public Integer apply(Integer aInteger) {
                return aInteger + 1;
            }
        });
    }

    public static Range<Double> of(Double from, Double to) {
        return of(from, to, new Function<Double, Double>() {

            public Double apply(Double aDouble) {
                return aDouble + 0.1;
            }
        });
    }



    public static Range<Short> of(Short from, Short to) {
        return of(from, to, new Function<Short, Short>() {

            public Short apply(Short aShort) {
                return (short)(aShort + 1);
            }
        });
    }

    public static Range<Byte> of(Byte from, Byte to) {
        return of(from, to, new Function<Byte, Byte>() {

            public Byte apply(Byte aByte) {
                return (byte)(aByte + 1);
            }
        });
    }


}
