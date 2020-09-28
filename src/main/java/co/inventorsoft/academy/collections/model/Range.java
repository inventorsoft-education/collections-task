
import java.text.DecimalFormat;
import java.util.*;
import java.util.function.Function;


public class Range<T> implements Set<T> {




    private Set<T> set;
    public Range() {
        set = new HashSet<>();
    }

    public int size() {
        return set.size();
    }

    public boolean isEmpty() {

        return set.isEmpty();
    }

    public boolean contains(Object o) {

        return set.contains(o);
    }

    public Iterator<T> iterator() {
        return set.iterator();
    }

    public Object[] toArray() {
        return set.toArray();
    }

    public <T1> T1[] toArray(T1[] a) {
        return set.toArray(a);
    }

    public boolean add(T t) {
        return set.add(t);
    }

    public boolean remove(Object o) {
        return set.remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        return set.containsAll(c);
    }

    public boolean addAll(Collection<? extends T> c) {
        return set.addAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        return set.retainAll(c);
    }

    public boolean removeAll(Collection<?> c) {
        return set.removeAll(c);
    }

    public void clear() {
        set.clear();
    }

    public static <T extends Comparable> Range<T> function(T fisrtIndex, T lastIndex, Function<T, T> increment) {
        Range<T> range = new Range<T>();
        if (fisrtIndex.compareTo(lastIndex) == 0) {
            return range;
        }
        T index = fisrtIndex;
        while (index.compareTo(lastIndex) <= 0) {
            range.add(index);
            index = increment.apply(index);
        }
        return range;
    }

    public static Range<Float> function(float fisrtIndex , float lastIndex ) {
        return function(fisrtIndex , lastIndex, f -> f + 0.1f);
    }


    public static Range<Double> function(double fisrtIndex, double lastIndex) {
        return function(fisrtIndex, lastIndex, d -> d + 0.1d);
    }

    public static Range<Integer> function(int fisrtIndex, int lastIndex) {
        return function(fisrtIndex, lastIndex, i -> i + 1);
    }



    public static void main(String[] args) {


    }
}
