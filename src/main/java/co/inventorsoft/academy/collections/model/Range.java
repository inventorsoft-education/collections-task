package co.inventorsoft.academy.collections.model;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.function.Function;

public class Range<T> implements Set<T> {

    Map<T, Object> map = new HashMap<T, Object>();
    Object Obj = new Object();

    public Range (T ... params) {
        for (T t: params) {
            if (map.containsKey(t))
                continue;
            this.map.put (t, Obj);
        }
    }

    public Range (){
        this.map = new HashMap<>();
    }

    public static Range of(int iteration, int end){
        Range range = new Range();
        int currentValue = iteration;
        while (currentValue < end){
            range.add(currentValue);
            currentValue += iteration;
            range.add(currentValue);
        }
        return range;
    }

    public static Range of (float iteration, float end){
        Range range = new Range();
        float currentValue = iteration;
        while (currentValue < end){
            range.add(currentValue);
            currentValue += iteration;
            range.add(currentValue);
        }
        return range;
    }

    public static <T extends Comparable<T>> Range <T> of(T start, T end, Function<T, T> function){
        Range range = new Range();
        while (start.compareTo(end) <= 0){
            range.add(start);
            start = function.apply(start);
        }
        return range;
    }

    public int size() {
        return map.size();
    }

    public boolean isEmpty() {
        return this.size()==0;
    }

    public boolean contains(Object o) {
        for (T t: map.keySet()) {
            if (t == (T) o)
                return true;
        }
        return false;
    }

    public Iterator<T> iterator() {
        Iterator <T> it = new Iterator<T>() {
            Set keySet = map.keySet();
            Iterator itSet = keySet.iterator();

            public boolean hasNext() {
                if (itSet.hasNext())
                    return true;
                return false;
            }

            public T next() {
                while (itSet.hasNext())
                    return (T) itSet.next();
                return null;
            }

            public void remove(){}
        };

        return it;
    }

    public Object[] toArray() {
        return map.keySet().toArray();
    }

    public <T1> T1[] toArray(T1[] a) {
        Object [] current = map.keySet().toArray();
        int arrayLength = this.size() + a.length;
        Object [] array = new Object[arrayLength];
        System.arraycopy(current, 0, array, 0, current.length);
        System.arraycopy(a, 0, array, current.length, a.length);
        return (T1[]) array;
    }

    public boolean add(T t) {
        if (!map.containsKey(t)) {
            map.put(t, Obj);
            return true;
        }
        return false;
    }

    public boolean remove(Object o) {
        T t = (T) o;
        if (map.containsKey(t)) {
            map.remove(t);
            return true;
        }
        return false;
    }

    public boolean containsAll(Collection<?> c) {
        if (map.keySet().containsAll(c))
            return true;
        return false;
    }

    public boolean addAll(Collection<? extends T> c) {
        for (T t: c) {
            this.add(t);
        }
        return true;
    }

    public boolean retainAll(Collection<?> c) {
        for (T t: map.keySet()){
            if (!c.contains(t))
                map.remove(t);
        }
        return true;
    }

    public boolean removeAll(Collection<?> c) {
        for (T t: map.keySet())
            map.remove(t);
        return true;
    }

    public void clear() {
        map = new HashMap<T, Object>();
    }
}
