import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Range<T> implements Set<T> {

    private static List mainList = new ArrayList();

    public static Range<Character> of(char a, char d, Function<Character, Character> characterCharacterFunction) {
        return new Range<>();
    }

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
        return mainList.toArray();
    }

    public <T1> T1[] toArray(T1[] a) {
        return null;
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
        c = c.stream()
                .distinct()
                .collect(Collectors.toList());
        if (mainList.containsAll(c)) {
            return false;
        } else {
            return mainList.addAll(c);
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

    public static Range of(int startList, int endList) {
        mainList.clear();
        if (startList != endList) {
            for (int i = startList; i <= endList; i++) {
                mainList.add(i);
            }
        }
        return new Range();

    }

    public static Range of(float startList, float endList) {
        mainList.clear();
        if (startList != endList) {
            for (float i = startList; i <= endList; i = i + 0.1f) {
                mainList.add(i);
            }
        }
        return new Range();
    }

    public static Range of(char startList, char endList) {
        mainList.clear();
        return new Range();
    }

    @Override
    public String toString() {
        return mainList.toString();
    }

}
