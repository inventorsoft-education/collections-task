package co.inventorsoft.academy.collections.model;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class Range<T> implements Set<T> {

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
       Range<Integer> range= new Range<>();
       if (i<i1) {
           for (int j = i; j <= i1; j++) {
               range.add(j);
           }
       }
        return range;
    }

    public static Range<Float> of(float v, float v1) {

        Range<Float> range= new Range<>();
        if (v<v1) {
            for (float j = v; j <= v1; j += 0.1f) {
                range.add(j);
            }
        }
        return range;


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
}
