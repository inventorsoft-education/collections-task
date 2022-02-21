package co.inventorsoft.academy.collections.model;

import java.util.*;
import java.util.function.Function;

public class Range<T> implements Set<T> {
    private Range(List<T> data){
        this.data=data;
    }
    static <E extends Number> Range of(E from, E to){
        List<Number> resulted= new ArrayList<>();
        if(from.equals(to)) return new Range(resulted);
        switch (from.getClass().getName()){
            case "java.lang.Float":
                case "java.lang.Double":
                    for(float i=from.floatValue();i<=to.floatValue();i+=0.1f) {
                        resulted.add(i);
                    }
                    break;
            case "java.lang.Long":
            case "java.lang.Integer":
            case "java.lang.Byte":
            case "java.lang.Short":
                for(int i = from.intValue(); i<=to.intValue(); i+=1) {
                    resulted.add(i);
                }
                break;
            default: return  null;
        }
        return new Range(resulted);
    }
    static <T> Range<T> of(T from, T to, Function<T,T> next){
        if(from==null) return null;
        T current=from;
        List<T> result= new ArrayList<>();
        while(current!=to){
            result.add(current);
            current=next.apply(current);
        }
        result.add(current);
        return new Range<T>(result);
    }
    public int size() {
      return  data.size();
    }

    public boolean isEmpty() {
        return this.size()==0;
    }

    public boolean contains(Object o) {
        T obj=(T)o;
        for(Object curr: data){
            if(obj.equals(curr)) return  true;
        }
        return false;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int current_position=0;
            @Override
            public boolean hasNext() {
                return current_position<size()&&data.get(current_position)!=null;
            }

            @Override
            public T next() {
                return data.get(current_position++);
            }
        };
    }

    public Object[] toArray() {
        Object[] result=new Object[size()];
        int currentIndex=0;
        for(Object curr:data){
            result[currentIndex]=curr;
            currentIndex++;
        };
        return result;
    }

    public <T1> T1[] toArray(T1[] a) {
        int currentIndex=0;
        for(T curr:data){
            a[currentIndex]= (T1) curr;
            currentIndex++;
        };
        return a;
    }

    private void add(Object t, List<Object> elementData) {
        elementData.add(t);
    }

    public boolean add(T t) {
        if(t instanceof Float|| t instanceof  Double){
            float temp=(int)( ((Number) t).floatValue()*10);
            temp/=10;
            add(temp,(List<Object>) data);
        }
        add(t, (List<Object>) data);
        return true;
    }


    public boolean remove(Object o) {
        if(!this.contains(o)) return false;
        data.remove(o);
        return true;
    }

    public boolean containsAll(Collection<?> c) {
        if(c.isEmpty()) return true;
        for(Object curr: c){
            if(!this.contains(curr)) return false;
        }
        return true;
    }

    public boolean addAll(Collection<? extends T> c) {
        for(Object current: c){
            this.add((T)current);
        };
        return true;
    }

    public boolean retainAll(Collection<?> c) {
        for(T current: data){
            if(!c.contains(current)) this.remove(current);
        }
        return true;
    }

    public boolean removeAll(Collection<?> c) {
        for(Object current: c){
            this.remove(current);
        };
        return true;
    }

    public void clear() {
        data.clear();
    }
    public void print(){
        for(T curr: data){
            System.out.println(curr);
        }
    }
    private List<T> data;
}
