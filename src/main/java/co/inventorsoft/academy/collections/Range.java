package co.inventorsoft.academy.collections;

import java.util.*;
import java.util.function.Function;

public class Range<T> implements Set<T> {
    List mylist = new ArrayList();

    public static void main(String[] args) {
        Range a = Range.of(1, 10);
        a.test();
        System.out.println("size "+a.size());
        System.out.println("is empty?" + a.isEmpty());
        System.out.println(a.add(0.2f));
        System.out.println(a.contains(5));
        a.test();
    }

    public Range(float a, float b) {
        if(!(a==b)){
        while (a <=b) {
            mylist.add(a);
            a = a + 0.1f;
            a = a * 10;
            a = Math.round(a);
            a = a / 10;

        }}
    }

    public Range(int a, int b) {
        if (!(a==b)){
        while (a <= b) {
            mylist.add(a);
            a = a + 1;
        }}

    }

    public static Range of(int i, int i1) {
        return new Range(i, i1);
    }

    public static Range of(float i, float i1) {
        return new Range(i, i1);
    }

    public static Range of(char i, char i1) {
        return new Range(i, i1);
    }

    public static Range<Character> of(char a, char d, Function<Character, Character> characterCharacterFunction) {
        return null;
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
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return mylist.add(o);
    }

    @Override
    public boolean remove(Object o) {
        return mylist.remove(o);
    }

    @Override
    public boolean addAll(Collection c) {
        return mylist.addAll(c);
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
    public boolean containsAll(Collection c) {

        return mylist.containsAll(c);
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    public boolean contains(float o) {
        return mylist.contains(o);
    }
    public boolean contains(int o) {
        return mylist.contains(o);
    }

    public boolean add(Float Float) {
        return mylist.add(Float);
    }

    public void test() {
        for (int i = 0; i < 1; i++) {
            System.out.println("It my list" + mylist.toString());
        }
    }
}
