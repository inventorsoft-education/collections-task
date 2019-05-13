package co.inventorsoft.academy.collections.model;

import java.util.*;
import java.util.function.Function;

public class Range<T> implements Set<T> , Comparable {

    static Object[] elementData = new Object[10];
    static int modCount = 0;

    static Number left;
    static Number right;
    boolean isEmpty = true;

    public static Range<Integer> of(Integer a, Integer b) {
        Range<Integer> range = new Range<>();
        range.clear();
        left = a;
        right = b;
        for(Integer j = left.intValue(); j<=right.intValue(); j++){
            range.add(j);
        }
        return range;

    }

    public static Range<Float> of(Float a, Float b) {
        Range<Float> range = new Range<>();
        range.clear();
        left = a;
        right = b;
        for(Float j = left.floatValue(); j<=right.floatValue(); j=j+0.1f){
            range.add(j);
        }
        return range;

    }

    public static Range<Character> of(char a, char d, Function<Character, Character> characterCharacterFunction) {
        Range<Character> range  = new Range<>();
        range.clear();
        for(Character j = a; j<=d; j++){
            range.add(j);
        }
        return range;
    }

    public int size() {
        return modCount;
    }

    public boolean isEmpty() {
        return this.isEmpty;
    }

    public boolean contains(Object o) {
        return java.util.Arrays.asList(elementData).indexOf(o) >= 0;
    }

    public Iterator<T> iterator() {
        Iterator iterator = new Iterator() {
            int cursor = 0;
            int lastRet = -1;
            @Override
            public boolean hasNext() {
                return cursor != modCount;
            }

            @Override
            public Object next() {
                int i = cursor;
                if (i >= modCount)
                    throw new NoSuchElementException();
                if (i >= elementData.length)
                    throw new ConcurrentModificationException();
                cursor = i + 1;
                return (Object) elementData[lastRet = i];
            }
        };
        return iterator;
    }

    public Object[] toArray() {
        return elementData;
    }

    public <T1> T1[] toArray(T1[] a) {
        T1[] array = (T1[]) new Object[a.length];
        int i = 0;
        for(T1 element: a){
            array[i] = element;
            i++;
        }
        return array;
    }


    public boolean add(T t) {

        if(java.util.Arrays.asList(elementData).indexOf(t) >= 0){
            return false;
        }

        elementData[modCount] = t;
        modCount++;
        if(this.isEmpty){
            this.isEmpty = false;
        }
        if(modCount == 1){
            this.isEmpty = true;
        }
        return true;
    }

    public boolean remove(Object o) {

        int index = java.util.Arrays.asList(elementData).indexOf(o);
        for (int i = index; i<modCount; i++){
            elementData[i] = elementData[i+1];
        }
        modCount--;
        return true;
    }

    public boolean containsAll(Collection<?> c) {
        boolean flag = true;
        for (Object element: c) {
            if(java.util.Arrays.asList(elementData).indexOf(element) < 0){
                flag = false;
            }
        }
        return flag;
    }

    public boolean addAll(Collection<? extends T> c) {
        for(Object element:c){
            if(java.util.Arrays.asList(elementData).indexOf(element) < 0){
                elementData[modCount] = element;
                modCount++;
            }

        }
        return true;
    }

    public boolean retainAll(Collection<?> c) {
        for(Object element:elementData){
            if(java.util.Arrays.asList(c).indexOf(element) < 0){
                this.remove(element);
            }
        }
        return true;
    }

    public boolean removeAll(Collection<?> c) {
        for(Object element:c){
            if(java.util.Arrays.asList(elementData).indexOf(element) >= 0){
                this.remove(element);
            }
        }
        return true;
    }

    public void clear() {
        for(int i = 0; i < modCount; i++){
            elementData[i] = null;
        }
        modCount = 0;
    }

    @Override
    public int compareTo(Object o) {
        if(this == o)
            return 0;
        return 1;
    }
}
