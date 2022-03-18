package co.inventorsoft.academy.collections.model;

import java.util.*;
import java.util.function.Function;


public class Range<T> implements Set<T> {

    List<T> mylist  = new ArrayList();


    public Range(float a, float b) {
        if(!(a==b)){
            while (a <=b) {
                mylist.add((T)(Float) a);
                a = a + 0.1f;
            }}
    }

    public Range(int a, int b) {
        if (!(a==b)){
            while (a <= b) {
                mylist.add((T)(Integer)a);
                a = a + 1;
            }}

    }


    public static Range of(int i, int i1) {
        return new Range(i, i1);
    }

    public static Range of(float i, float i1) {
        return new Range(i, i1);
    }
    public int size() {
        return mylist.size();
    }

    public boolean isEmpty() {
        return mylist.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return mylist.contains(o);
    }

    @Override
    public Iterator iterator() {
        return mylist.iterator();
    }

    @Override
    public Object[] toArray() {
        return mylist.toArray();
    }

    @Override
    public boolean remove(Object o) {
        return mylist.remove(o);
    }

    public boolean addAll(Collection<? extends T> c) {
        for (T t : mylist) {add(t);}return false;
    }

    @Override
    public void clear() {
        mylist.clear();
    }

    @Override
    public boolean removeAll(Collection c) {
        return mylist.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection c) {

        return mylist.retainAll(c);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return mylist.containsAll(c);
    }

    @Override
    public <T1> T1[] toArray(T1[] o) {
        return mylist.toArray(o);
    }



    public boolean add(T t) {if (!mylist.contains(t)) {return mylist.add(t);}return false;}


Range(){}

    public static   <T extends Comparable<T>> Range of(T a, T b, Function<T, T> rng) {
        Range<T> elem = new Range<>();
        if (a.compareTo(b) < 0) {
            T value = a;
            while (value.compareTo(b) < 1) {
                elem.add(value);
                value = rng.apply(value);
            }
        }
        return elem;
    }


}
