import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class Range<T> implements Set<T> {

    private List<T> mainList = new ArrayList();

    public int size() {
        return mainList.size();
    }

    public boolean isEmpty() {
        return mainList.isEmpty();
    }

    public boolean contains(Object o) {
        return mainList.contains(o);
    }

    public Iterator<T> iterator() {
        return mainList.iterator();
    }

    public Object[] toArray() {
        Object[] objects = new Object[size()];
        int index = 0;
        for (Object current : mainList) {
            objects[index] = current;
            index++;
        }
        return objects;
    }

    public <T1> T1[] toArray(T1[] a) {
        int index = 0;
        for (T current : mainList) {
            a[index] = (T1) current;
            index++;
        }
        return a;
    }

    public boolean add(T t) {
        if (mainList.contains(t)) {
            return false;
        } else {
            return mainList.add(t);
        }
    }

    public boolean remove(Object o) {
        return mainList.remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        return mainList.containsAll(c);
    }

    public boolean addAll(Collection<? extends T> c) {
        if (c.isEmpty()) {
            return false;
        } else {
            for (T iter : c) {
                if (!mainList.contains(iter)) {
                    mainList.add(iter);
                }
            }
            return true;
        }
    }

    public boolean retainAll(Collection<?> c) {
        return mainList.retainAll(c);
    }

    public boolean removeAll(Collection<?> c) {
        return mainList.removeAll(c);
    }

    public void clear() {
        mainList.clear();
    }

    public static Range<Integer> of(Integer startList, Integer endList) {
        return (Range<Integer>) Range.of(startList, endList, integer -> integer + 1);
    }

    public static Range<Float> of(Float startList, Float endList) {
        return (Range<Float>) Range.of(startList, endList, aFloat -> aFloat + 0.1f);
    }

    public static <T extends Comparable<T>> Range of(T startList, T endList, Function<T, T> range) {
        Range<T> arr = new Range<>();
        if (startList.compareTo(endList) < 0) {
            while (startList.compareTo(endList) < 1) {
                arr.add(startList);
                startList = range.apply(startList);
            }
        }
        return arr;
    }

    @Override
    public String toString() {
        return mainList.toString();
    }

}



