package main.java.co.inventorsoft.academy.collections.model;

import java.util.*;
import java.util.function.Function;

public class Range<T> implements Set<T> {
    private static List<Object> arrayList = new ArrayList<>();

    public Range() {
        this.arrayList = arrayList;
    }

    public Range(List<Object> arrayList) {
        this.arrayList = arrayList;
    }


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
        return (Iterator<T>) arrayList.iterator();
    }

    public Object[] toArray() {
        return arrayList.toArray();
    }

    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    public boolean add(T t) {
        if (!arrayList.contains(t)) {
            return arrayList.add(t);
        } else {
            return false;
        }
    }

    public boolean remove(Object o) {
        return arrayList.remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        return arrayList.containsAll(c);
    }

    public boolean addAll(Collection<? extends T> c) {
        Object[] objects = c.toArray();
        boolean containElement = false;
        for (int i = 0; i < objects.length; i++) {
            if (!arrayList.contains(objects[i])) {
                arrayList.add(objects[i]);
                containElement = true;
            }
            containElement = false;
        }
        return containElement;
    }

    public boolean retainAll(Collection<?> c) {
        return arrayList.retainAll(c);
    }

    public boolean removeAll(Collection<?> c) {
        return arrayList.removeAll(c);
    }

    public void clear() {
        arrayList.clear();
    }

    public static Range<Integer> of(int i, int i1) {
        arrayList.clear();
        if (i < i1) {
            for (int j = i; j <= i1; j++) {
                arrayList.add(j);
            }
        }
        return new Range<>();
    }

    public static Range<Float> of(float i, float i1) {
        arrayList.clear();
        if (i < i1) {
            for (float j = i; j <= i1; j = j + 0.1f) {
                arrayList.add(j);
            }
        }
        return new Range<>();
    }

    public static Range<Double> of(double i, double i1) {
        arrayList.clear();
        if (i < i1) {
            for (double j = i; j <= i1; j = j + 0.1) {
                arrayList.add(j);
            }
        }
        return new Range<>(arrayList);
    }


    public static Range<Character> of(char a, char d, Function<Character, Character> characterCharacterFunction) {
        arrayList.clear();
        arrayList.add(new Character(a));
        Character next = characterCharacterFunction.apply(a);
        while (!next.equals(new Character(d))) {
            arrayList.add(next);
            next = characterCharacterFunction.apply(next.charValue());
        }
        arrayList.add(new Character(d));
        return new Range<>();
    }
}
