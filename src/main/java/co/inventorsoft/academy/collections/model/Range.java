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
        ;
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

    public static class MyInteger implements Function<Integer, Integer> {

        @Override
        public Integer apply(Integer y) {
            return y + 1;
        }

    }

    @Override
    public String toString() {
        return mainList.toString();
    }

}
