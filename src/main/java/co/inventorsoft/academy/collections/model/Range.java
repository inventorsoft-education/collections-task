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

        if (buckets[index]==null || buckets[index].getNext() == null ||  buckets[index].getData()==null) {
            return flag;
        }

        if (bucket.data.equals(o)) {
            flag = true;
        }
        else{
            flag=false;
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

                if (hasNext()&& size!=0){
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
                for(int j=0;j<size;j++){
                    if (array[j]!=buckets[i]){
                        array[i] = buckets[i];
                    }
                }
            }
        }
        return array;
    }

    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    public boolean add(T t) {

        //changing size if not enough
        if (size >= INITIAL_CAPACITY) {
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
                start=current;
                return true;

            }else  {
            buckets[index] = newNode;
            size++;
            current.setNext(buckets[index]);
            current=buckets[index];
            return true;}
        } else
            {
                System.out.println(buckets[index].data+ " "+"is already exists");
                return false;
            }

    }

    public boolean remove(Object o) {

        int index = o.hashCode() % buckets.length;
        Node bucket = buckets[index];
        boolean flag = false;


        if (bucket == null) {
            throw new NoSuchElementException("No Element Found");
        }

        if (bucket.data.equals(o)) {
            if (buckets[index-1]!=null && buckets[index-1].getNext()!=null && buckets[index].getData()!=null){
                buckets[index-1].setNext(bucket.next);
                size--;
                flag = true;
            }
            else {
                buckets[index].setNext(null);
                buckets[index].data=null;
                start=buckets[index+1];
                flag=true;
            }
        }
        return flag;
    }

    public boolean containsAll(Collection<?> c) {
        boolean flag=true;
        for (Object elem : c) {
            if (!this.contains(elem)) {
                flag=false;
            }
        }
        return flag;
    }

    public boolean addAll(Collection<? extends T> c) {
        for (T elem : c) {
            this.add(elem);
        }
        return true;

    }

    public boolean retainAll(Collection<?> c) {
        boolean changed=false;
        Object tmp=null;

       Iterator iterator=this.iterator();

       while(iterator.hasNext()){
           tmp=iterator.next();
           if (!c.contains((tmp))){
               remove(tmp);
               changed=true;
           }
       }

        return changed;
    }

    public boolean removeAll(Collection<?> c) {
        int counter=0;
        for (Object elem : c) {
            if (this.contains(elem)){
                if (this.remove(elem)){
                    counter++;
                }
            }
        }
        return counter>0;
    }

    public void clear() {
        while(iterator().hasNext()){
            remove(iterator().next());
        }


    }


    public static <T extends Comparable> Range<T> of(T start, T end, Function<T, T> increment){
        Range<T> range=new Range<>();

        if (start.compareTo(end)==0){
            return range;
        }

        T next = start;
        while (next.compareTo(end) <= 0) {
            range.add(next);
            next = increment.apply(next);
        }

        return range;
    }

    public static Range<Float> of(Float from, Float to) {
        return of(from, to, new Function<Float, Float>() {

            public Float apply(Float aFloat) {
                return aFloat + 0.1f;
            }
        });
    }

    public static Range<Integer> of(Integer from, Integer to) {
        return of(from, to, new Function<Integer, Integer>() {

            public Integer apply(Integer aInteger) {
                return aInteger + 1;
            }
        });
    }


}

