package co.inventorsoft.academy.collections.model;

import java.util.*;

public class Range<T> implements Set<T> {

    private static List  mainList = new ArrayList();

    public int size() {
        return mainList.size();
    }

    public boolean isEmpty() {
        return mainList.isEmpty();
    }

    public boolean contains(Object o) {
        return mainList.contains(o);
    }

    public Iterator<T> iterator() {
        return mainList.iterator();
    }

    public Object[] toArray() {
        return mainList.toArray();
    }

    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    public boolean add(T t) {
        return mainList.add(t);
    }

    public boolean remove(Object o) {
        return mainList.remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        return mainList.containsAll(c);
    }

    public boolean addAll(Collection<? extends T> c) {
        return mainList.addAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        return mainList.retainAll(c);
    }

    public boolean removeAll(Collection<?> c) {
        return mainList.removeAll(c);
    }

    public void clear() {
        mainList.clear();
    }
    public static Range of(int startList, int endList){
        mainList.clear();
        if (startList != endList) {
            for (int i=startList; i<=endList; i++)
            {
                mainList.add(i);
            }
        }
        return new Range();

    }

    public static Range of(float startList, float endList){
        mainList.clear();
        if (startList != endList) {
            for (float i=startList; i<=endList; i =i+0.1f)
            {
                mainList.add(i);
            }
        }
        return new Range();
    }

}
