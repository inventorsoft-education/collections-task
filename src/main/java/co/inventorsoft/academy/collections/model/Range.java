package co.inventorsoft.academy.collections.model;

import java.util.*;
import java.util.function.Function;

public class Range<T> implements Set<T> {

    private HashMap<T, Object> map;
    private static final Object PRESENT = new Object();
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    private Range() {
        map = new HashMap<>();
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
        Object[] r = new Object[size()];
        Iterator<T> it = iterator();
        for (int i = 0; i < r.length; i++) {
            if (!it.hasNext())
                return Arrays.copyOf(r, i);
            r[i] = it.next();
        }
        return it.hasNext() ? finishToArray(r, it) : r;
    }

    private static <T1> T1[] finishToArray(T1[] r, Iterator<?> it) {
        int i = r.length;
        while (it.hasNext()) {
            int cap = r.length;
            if (i == cap) {
                int newCap = cap + (cap >> 1) + 1;
                if (newCap - MAX_ARRAY_SIZE > 0)
                    newCap = hugeCapacity(cap + 1);
                r = Arrays.copyOf(r, newCap);
            }
            r[i++] = (T1) it.next();
        }
        return (i == r.length) ? r : Arrays.copyOf(r, i);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0)
            throw new OutOfMemoryError
                    ("Required array size too large");
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE :
                MAX_ARRAY_SIZE;
    }

    public <T1> T1[] toArray(T1[] a) {
        int size = size();
        T1[] r = a.length >= size ? a :
                (T1[]) java.lang.reflect.Array
                        .newInstance(a.getClass().getComponentType(), size);
        Iterator<T> it = iterator();

        for (int i = 0; i < r.length; i++) {
            if (!it.hasNext()) {
                if (a == r) {
                    r[i] = null;
                } else if (a.length < i) {
                    return Arrays.copyOf(r, i);
                } else {
                    System.arraycopy(r, 0, a, 0, i);
                    if (a.length > i) {
                        a[i] = null;
                    }
                }
                return a;
            }
            r[i] = (T1) it.next();
        }
        return it.hasNext() ? finishToArray(r, it) : r;
    }

    public boolean add(T t) {
        return map.put(t, PRESENT) == null;
    }

    public boolean remove(Object o) {
        return map.remove(o) == PRESENT;
    }

    public boolean containsAll(Collection<?> c) {
        for (Object e : c)
            if (!contains(e))
                return false;
        return true;
    }

    public boolean addAll(Collection<? extends T> c) {
        boolean modified = false;
        for (T e : c)
            if (add(e))
                modified = true;
        return modified;
    }

    public boolean retainAll(Collection<?> c) {
        Objects.requireNonNull(c);
        boolean modified = false;
        Iterator<T> it = iterator();
        while (it.hasNext()) {
            if (!c.contains(it.next())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    public boolean removeAll(Collection<?> c) {
        Objects.requireNonNull(c);
        boolean modified = false;
        Iterator<?> it = iterator();
        while (it.hasNext()) {
            if (c.contains(it.next())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    public void clear() {
        map.clear();
    }

//    static Range<Integer> of(int firstElement, int lastElement) {
//        Range<Integer> range = new Range<>();
//        if (firstElement == lastElement) {
//            return range;
//        } else {
//            int size = lastElement / firstElement;
//            int step = firstElement;
//            for (int i = 0; i < size; i++) {
//                range.add(firstElement);
//                firstElement = firstElement + step;
//            }
//        }
//        return range;
//    }

//    static Range<Float> of(float firstElement, float lastElement) {
//        Function<Float, Float> floatFloatFunction = (Float param) -> {
//            return param + 1;
//        };
//
//        class FloatFunction implements Function<Float, Float> {
//
//            @Override
//            public Float apply(Float param) {
//                return param + 1;
//            }
//        }
//        return of(firstElement, lastElement, floatFloatFunction);
//        Range<Float> range = new Range<>();
//        if (firstElement == lastElement) {
//            return range;
//        } else {
//            float size = lastElement / firstElement;
//            float step = firstElement;
//            for (int i = 0; i < size; i++) {
//                range.add(firstElement);
//                firstElement = firstElement + step;
//            }
//        }
//        return range;
//    }

    static <T extends Number> Range<T> of(T firstElement, T lastElement, ) {
        Range<T> range = new Range<>();
        range.add(firstElement);
        while (firstElement != lastElement){
            range.add(firstElement);
        }
        return range;
    }

    static Range<Character> of(char firstElement, char lastElement, Function<Character, Character> function) {
        Range<Character> range = new Range<>();
        range.add(firstElement);
        while (firstElement != lastElement) {
            firstElement = function.apply(firstElement);
            range.add(firstElement);
        }
        return range;
    }

}