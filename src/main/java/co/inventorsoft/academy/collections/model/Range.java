package co.inventorsoft.academy.collections.model;

import java.util.*;
import java.util.function.Function;

public class Range<T> implements Set<T> {


    private Node[] buckets;
    private static final Integer INITIAL_CAPACITY = 30;
    private int size;
    Node<T>current=null;
    Node<T> start=null;

    public Range(final int capacity) {
        this.buckets = new Node[capacity];
    }

    public Range() {
        this(INITIAL_CAPACITY);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o) {
        int index = o.hashCode() % buckets.length;
        Node bucket = buckets[index];
        boolean flag = false;

        if (bucket == null) {
            return flag;
        }

        if (bucket.data.equals(o)) {
            flag = true;
        }
        return flag;
    }

    public Iterator<T> iterator() {

        Iterator<T> iterator = new Iterator<T>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public T next() {
                Object tmp = start;

                if (hasNext()){
                    tmp=start.getData();
                    current=start;
                    start=current.getNext();
                    currentIndex++;
                    return (T)tmp;
                }

                return (T) tmp;
            }

        };

        return iterator;
    }

    public Object[] toArray() {
        int size = this.size;
        Object array[] = new Object[size];
        for (int i = 0; i < size; i++) {
            if (buckets[i] != null) {
                array[i] = buckets[i];
            }
        }
        return array;
    }

    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    public boolean add(T t) {

        //changing size if not enough
        if (size >= 14) {
            Node[] newBuckets = new Node[size * 2];
            for (int i = 0; i < size; i++) {
                newBuckets[i] = buckets[i];
            }
            buckets = newBuckets;
        }

        int index = t.hashCode() % buckets.length;

        //inserting new values
        Node bucket = buckets[index];
        Node<T> newNode = new Node<>(t);


        if (bucket == null) {
            if (size==0){
                buckets[index] = newNode;
                size++;
                current=buckets[index];
                start=buckets[index];
                return true;

            }else {
            buckets[index] = newNode;
            size++;
            current.setNext(buckets[index]);
            current=buckets[index];
            return true;}
        } else return false;

    }

    public boolean remove(Object o) {

        int index = o.hashCode() % buckets.length;
        Node bucket = buckets[index];
        boolean flag = false;


        if (bucket == null) {
            throw new NoSuchElementException("No Element Found");

        }

        if (bucket.data.equals(o)) {
            buckets[index] = bucket.next;
            size--;
            flag = true;
        }
        return flag;
    }

    public boolean containsAll(Collection<?> c) {
        for (Object elem : c) {
            if (!this.contains(elem)) {
                return false;
            }
        }
        return true;
    }

    public boolean addAll(Collection<? extends T> c) {
        for (T elem : c) {
            this.add(elem);
        }
        return true;

    }

    public boolean retainAll(Collection<?> c) {
        for (Object elem : c) {
            if (this.contains(elem) && elem != null) {
                this.remove(elem);
            }
        }
        return false;
    }

    public boolean removeAll(Collection<?> c) {
        for (Object elem : c) {
            this.remove(elem);
        }
        return false;
    }

    public void clear() {
        Node[] newBuckets = new Node[size];
        buckets = newBuckets;

    }

    public String toString() {
        return null;
    }

    static Range<Integer> of(int e1, int e2) {
        int start = e1;
        int end = e2;
        int range = end - start;

        Range<Integer> newRange;
        if (range == 0) {
            return new Range<Integer>(0);
        } else {
            newRange = new Range<Integer>();
            for (int i = start; i <= end; i++) {
                newRange.add(i);
            }
        }
        return newRange;
    }

    static Range<Float> of(float e1, float e2) {
        float start = e1;
        float end = e2;
        float range = end - start;

        Range<Float> newRange;
        if (range == 0) {
            return new Range<Float>(0);
        } else {
            newRange = new Range<Float>();
            for (float i = start; i <= end; i+=0.1) {
                newRange.add(i);
            }
        }
        return newRange;
    }

    static Range<Double> of(double e1, double e2) {
        double start = e1;
        double end = e2;
        double range = end - start;

        Range<Double> newRange;
        if (range == 0) {
            return new Range<Double>(0);
        } else {
            newRange = new Range<Double>();
            for (double i = start; i <= end; i+=0.1) {
                newRange.add(i);
            }
        }
        return newRange;
    }

    static Range<Character> of(Character e1, Character e2,Function<Character,Character> function) {
        char start = e1;
        char end = e2;
        int range = end - start;

        Range<Character> newRange;
        if (range == 0) {
            return new Range<Character>(0);
        } else {
            newRange = new Range<Character>();
            for (char i = start; i <= end; i++) {
                newRange.add(i);
            }
        }
        return newRange;
    }




}

