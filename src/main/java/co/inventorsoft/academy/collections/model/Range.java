package co.inventorsoft.academy.collections.model;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.HashMap;
import java.util.function.Function;

public class Range<T> implements Set<T> {
    private HashMap<T, Object> map;
    private static Object PRESENT = new Object();

    public Range() {
        map = new HashMap<T, Object>();
    }

    public int size() {
        return map.size();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    public Iterator<T> iterator() {
        return map.keySet().iterator();
    }

    public Object[] toArray() {
        Object[] arrayObjects = new Object[this.size()];
        Iterator<T> it = iterator();
        for (int i = 0; i < arrayObjects.length; i++) {
            if (!it.hasNext()) {
                return arrayObjects;
            }
            arrayObjects[i] = it.next();
        }
        return arrayObjects;
    }

    public <T1> T1[] toArray(T1[] a) {
        return map.keySet().toArray(a);
    }

    public boolean add(T t) {
        return map.put(t, PRESENT) == null;
    }

    public boolean remove(Object o) {
        return map.remove(o) == null;
    }

    public boolean containsAll(Collection<?> c) {
        if (c.size() == 0) return false;
        for (Object o : c) {
            if (!this.contains(o)) return false;
        }
        return true;
    }

    public boolean addAll(Collection<? extends T> c) {
        boolean result = false;
        for (T o : c) {
            if (add(o)) result = true;
        }
        return result;
    }

    public boolean retainAll(Collection<?> c) {
        if (c.size() == 0) return false;
        boolean result = false;
        for (T o : map.keySet()) {
            if (!c.contains(o)) {
                this.remove(o);
                result = true;
            }
        }
        return result;
    }

    public boolean removeAll(Collection<?> c) {
        if (c.size() == 0) return false;
        boolean result = false;
        for (T o : map.keySet()) {
            if (c.contains(o)) {
                this.remove(o);
                result = true;
            }
        }
        return result;
    }

    public void clear() {
        map.clear();
    }

    public static Range<Byte> of(byte firstArg, byte secondArg) {
        return of(firstArg, secondArg, new Function<Byte, Byte>() {
            @Override
            public Byte apply(Byte aByte) {
                byte step = 1;
                return aByte = (byte) (aByte + step);
            }
        });
    }

    public static Range<Short> of(short firstArg, short secondArg) {

        return of(firstArg, secondArg, new Function<Short, Short>() {
            @Override
            public Short apply(Short aShort) {
                short step = 1;
                return aShort = (short) (step + aShort);
            }
        });
    }

    public static Range<Integer> of(int firstArg, int secondArg) {

        return of(firstArg, secondArg, new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer += 1;
            }
        });
    }

    public static Range<Double> of(double firstArg, double secondArg) {

        return of(firstArg, secondArg, new Function<Double, Double>() {
            @Override
            public Double apply(Double aDouble) {
                return aDouble += 0.1d;
            }
        });
    }

    public static Range<Float> of(float firstArg, float secondArg) {

        return of(firstArg, secondArg, new Function<Float, Float>() {
            @Override
            public Float apply(Float aFloat) {
                return aFloat += 0.1f;
            }
        });
    }

    public static <T extends Comparable<T>> Range<T> of(T firstArg, T secondArg, Function<T, T> function) {
        Range<T> range = new Range<T>();
        if (firstArg.compareTo(secondArg) == 0) return range;
        while (firstArg.compareTo(secondArg) <= 0) {
            range.add(firstArg);
            firstArg = function.apply(firstArg);


        }
        return range;
    }


}
