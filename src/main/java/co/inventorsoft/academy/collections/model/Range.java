package main.java.co.inventorsoft.academy.collections.model;

import java.util.*;
import java.util.function.Function;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Range<T> implements Set<T> {
    private List<T> arrayList = new ArrayList<>();
    private static List<Integer> integerList = new ArrayList<>();
    private static List<Float> floatList = new ArrayList<>();
    private static List<Character> characterList = new ArrayList<>();
    private static List<Double> doubleList = new ArrayList<>();

    public Range() {

    }

    public Range(List<T> arrayList) {
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
        return arrayList.iterator();
    }

    public Object[] toArray() {
        return arrayList.toArray();
    }

    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    public boolean add(T t) {
        return arrayList.add(t);
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

    public boolean removeAll(Collection<?> c) {
        return arrayList.removeAll(c);
    }

    public void clear() {
        arrayList.clear();
    }

    public static Range<Integer> of(int i, int i1) {
        integerList.clear();
        if (i < i1) {
            for (int j = i; j <= i1; j++) {
                integerList.add(j);
            }
        }
        return new Range<>(integerList);
    }

    public static Range<Float> of(float i, float i1) {
        floatList.clear();
        if (i < i1) {
            for (float j = i; j <= i1; j = j + 0.1f) {
                floatList.add(j);
            }
        }
        return new Range<>(floatList);
    }

    public static Range<Double> of(double i, double i1) {
        doubleList.clear();
        if (i < i1) {
            for (double j = i; j <= i1; j = j + 0.1) {
                doubleList.add(j);
            }
        }
        return new Range<>(doubleList);
    }


    public static Range<Character> of(char a, char d, Function<Character, Character> characterCharacterFunction) {
        characterList.clear();
        characterList.add(new Character(a));
        Character next = characterCharacterFunction.apply(a);
        while (!next.equals(new Character(d))) {
            characterList.add(next);
            next = characterCharacterFunction.apply(next.charValue());
        }
        characterList.add(new Character(d));
        return new Range<>(characterList);
    }
}
