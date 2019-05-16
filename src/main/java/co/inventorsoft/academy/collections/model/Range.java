package model;

import java.util.*;
import java.util.function.Function;

public class Range<T>  implements Set<T>  {

    ArrayList<T> arrayList = new ArrayList<>();

    public int size() {
        return arrayList.size();
    }

    public boolean isEmpty() {

        return arrayList.isEmpty();
    }

    public boolean contains(Object o) {
        return arrayList.contains(o);
    }

    public Iterator<T> iterator() {
        return arrayList.iterator();
    }

    public Object[] toArray() {

        return arrayList.toArray();
    }

    public <T1> T1[] toArray(T1[] a) {

        return (T1[]) arrayList.toArray();
    }

    public boolean add(T t) {
        if (arrayList.contains(t)) return false;
        return  arrayList.add(t);
    }

    public boolean remove(Object o) {

        return arrayList.remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        return arrayList.containsAll(c);
    }

    public boolean addAll(Collection<? extends T> c) {

        return arrayList.addAll(c);
    }

    public boolean retainAll(Collection<?> c) {

        return arrayList.retainAll(c);
    }

    public boolean removeAll(Collection<?> c)
    {
        return arrayList.removeAll(c);
    }

    public void clear() {
        arrayList.clear();
    }



    public static Range<Integer> of(int i, int i1) {

        return of(i, i1, integer -> (integer + 1));
    }

    public static Range<Float> of(float v, float v1) {

        return of(v, v1, f -> (f + 0.1f));

    }

    public static Range<Character> of(char a, char d, Function<Character, Character> function) {

        Range<Character> range= new Range<>();
        if (a<d) {
            for (int j = a; j <= d; j ++) {
                range.add((char) j);
            }
        }
        return range;
    }

    public static <T extends Comparable> Range<T> of (T e1, T e2, Function<T, T> function) {
        Range<T> range = new Range<>();
        if (e1.compareTo(e2) < 0) {
            T i = e1;
            while (i.compareTo(e2) <= 0) {
                range.add(i);
                i = function.apply(i);
            }
        }
        return range;
    }
}
