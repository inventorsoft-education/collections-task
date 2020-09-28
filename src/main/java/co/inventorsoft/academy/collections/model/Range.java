package co.inventorsoft.academy.collections.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Range<T> implements Set<T> {

    private HashSet<T> range;
    private static final Range<Byte> rByte = new Range();
    private static final Range<Short> rShort = new Range();
    private static final Range<Integer> rInt = new Range();
    private static final Range<Long> rLong = new Range();
    private static final Range<Double> rDouble = new Range();
    private static final Range<Float> rFloat = new Range();
//    private static final Range<Character> rChar = new Range();

    public Range(){
        range = new HashSet<T>();
    }

    public int size() {
        return range.size();
    }

    public boolean isEmpty() {
        if(size()==1){
            return true;
        }
        return range.isEmpty();
    }

    public boolean contains(Object o) {
        return range.contains(o);
    }

    public Iterator<T> iterator() {
        return range.iterator();
    }

    public Object[] toArray() {
        return range.toArray();
    }

    public <T1> T1[] toArray(T1[] a) {
        return (T1[]) range.toArray(a);
    }

    public boolean add(T t) {
        return range.add(t);
    }

    public boolean remove(Object o) {
        return range.remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        return range.containsAll(c);
    }

    public boolean addAll(Collection<? extends T> c) {
        return range.addAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        return range.retainAll(c);
    }

    public boolean removeAll(Collection<?> c) {
        return range.removeAll(c);
    }

    public void clear() {
        range.clear();
    }

    public static Range<Byte> of( byte element1, byte element2){
        for(byte i=element1;i<=element2;i++){
            rByte.add(i);
        }
        return rByte;
    }

    public static Range<Short> of( short element1, short element2){
        for(short i=element1;i<=element2;i++){
            rShort.add(i);
        }
        return rShort;
    }
    public static Range<Integer> of( int element1, int element2){
        for(int i=element1;i<=element2;i++){
            rInt.add(i);
        }
        return rInt;
    }
    public static Range<Long> of( long element1, long element2){
        for(long i=element1;i<=element2;i++){
            rLong.add(i);
        }
        return rLong;
    }
    public static Range<Double> of( double element1, double element2){
        for(double i=element1;i<=element2;i=i+0.1){
            rDouble.add(i);
        }
        return rDouble;
    }
    public static Range<Float> of( float element1, float element2){
        for(float i=element1;i<=element2;i=i+0.1f){
            rFloat.add(i);
        }
        return rFloat;
    }


}
