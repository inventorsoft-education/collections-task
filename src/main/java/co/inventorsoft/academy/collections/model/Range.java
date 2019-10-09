package co.inventorsoft.academy.collections.model;

import java.util.*;
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
        HashSet<T> hashSet = new HashSet<T>();
        return hashSet.toArray(a);
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
            if (add(o)) {
                result = true;
            }
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
        Range<Byte> range = new Range<Byte>();
        if (firstArg == secondArg) return range;
        while (firstArg <= secondArg) {
            range.add(firstArg);
            firstArg++;
        }
        return range;
    }

    public static Range<Short> of(short firstArg, short secondArg) {
        Range<Short> range = new Range<Short>();
        if (firstArg == secondArg) return range;
        while (firstArg <= secondArg) {
            range.add(firstArg);
            firstArg++;
        }
        return range;
    }

    public static Range<Integer> of(int firstArg, int secondArg) {
        Range<Integer> range = new Range<Integer>();
        if (firstArg == secondArg) return range;
        while (firstArg <= secondArg) {
            range.add(firstArg);
            firstArg++;
        }
        return range;
    }

    public static Range<Double> of(double firstArg, double secondArg) {
        Range<Double> range = new Range<Double>();
        if (firstArg == secondArg) return range;
        while (firstArg <= secondArg) {
            range.add(firstArg);
            firstArg += 0.1;
        }
        return range;
    }

    public static Range<Float> of(float firstArg, float secondArg) {
        Range<Float> range = new Range<Float>();
        if (firstArg == secondArg) return range;
        while (firstArg <= secondArg) {
            range.add(firstArg);
            firstArg += 0.1f;
        }
        return range;
    }

    public static Range<Character> of(char firstArg, char secondArg, Function<Character, Character> function) {
        Range<Character> range = new Range<Character>();
        if (firstArg == secondArg) return range;
        while (firstArg <= secondArg) {
            firstArg=function.apply(firstArg);
            range.add(firstArg);
        }
        return range;
    }
}
