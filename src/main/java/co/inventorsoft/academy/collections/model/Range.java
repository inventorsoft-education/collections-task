package co.inventorsoft.academy.collections.model;

import java.util.*;
import java.util.function.Function;

public class Range<T extends Comparable<T>> implements Set<T> {

    private static final float FLOAT_STEP = 0.1f;
    private int size = 0;
    private Node<T> first;
    private Node<T> last;

    private static class Node<V> {
        V item;
        Node<V> next;
        Node<V> prev;

        public Node(V item) {
            this.item = item;
        }

        Node(Node<V> prev, V element, Node<V> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public static Range<Integer> of(Integer start, Integer end) {
        return new Range<>(start, end, value -> ++value);
    }

    public static Range<Float> of(Float start, Float end) {
        return new Range<>(start, end, value -> value + FLOAT_STEP);
    }

    public static Range<Character> of(Character start, Character end, Function<Character, Character> func) {
        return new Range<>(start, end, func);
    }

    public Range(T start, T end, Function<T, T> func) {
        if (start.compareTo(end) > 0) {
            throw new IllegalArgumentException("[start] can't be greater than [end]");
        } else if (start.compareTo(end) < 0) {
            T current = start;
            do {
                addNode(current);
                current = func.apply(current);
            } while (current.compareTo(end) <= 0);
        }
    }

    public boolean add(T t) {
        boolean flag = false;
        if (last == null) {
            addNode(t);
        } else {
            if (!contains(t)) {
                flag = true;
                addNode(t);
            }
        }
        return flag;
    }

    private void addNode(T t) {
        final Node<T> l = last;
        final Node<T> newNode = new Node<>(l, t, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o) {
        boolean flag = false;
        Iterator<T> iter = iterator();
        while (iter.hasNext()) {
            if (o.equals(iter.next())) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private Node<T> lastReturned;
            private Node<T> next = first;
            private int nextIndex = 0;

            @Override
            public boolean hasNext() {
                return size > nextIndex;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                } else {
                    lastReturned = next;
                    next = next.next;
                    nextIndex++;
                }
                return lastReturned.item;
            }

            @Override
            public void remove() {
                if (lastReturned == null)
                    throw new IllegalStateException();

                Node<T> lastNext = lastReturned.next;
                if (next == lastReturned) {
                    next = lastNext;
                }
                nextIndex--;
                lastReturned = null;
            }
        };
    }

    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;

        Iterator<T> iter = iterator();
        while (iter.hasNext()) {
            result[i] = iter.next();
            i++;
        }

        return result;
    }

    public <T1> T1[] toArray(T1[] a) {
        if (a.length < size)
            a = (T1[]) java.lang.reflect.Array.newInstance(
                    a.getClass().getComponentType(), size);
        int i = 0;
        Object[] result = a;
        for (Node<T> x = first; x != null; x = x.next)
            result[i++] = x.item;

        if (a.length > size)
            a[size] = null;

        return a;
    }

    public boolean remove(Object o) {
        if (o == null) {
            for (Node<T> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<T> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    T unlink(Node<T> x) {
        final T element = x.item;
        final Node<T> next = x.next;
        final Node<T> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        return element;
    }

    public boolean containsAll(Collection<?> c) {
        boolean flag = true;
        for (Object e : c) {
            if (!contains(e)) {
                flag = false;
            }
        }
        return flag;
    }

    public boolean addAll(Collection<? extends T> c) {
        boolean flag = true;
        for (T t : c) {
            if (contains(t)) {
                flag = false;
            } else {
                add(t);
                flag = true;
            }
        }
        return flag;
    }

    public boolean retainAll(Collection<?> c) {
        boolean flag = true;
        Iterator<T> e = iterator();
        while (e.hasNext()) {
            if (!c.contains(e.next())) {
                e.remove();
                flag = false;
            }
        }
        return flag;
    }

    public boolean removeAll(Collection<?> c) {
        Objects.requireNonNull(c);
        boolean flag = false;

        for (Iterator<?> i = iterator(); i.hasNext(); ) {
            if (c.contains(i.next())) {
                i.remove();
                flag = true;
            }
        }
        return flag;
    }

    public void clear() {
        for (Node<T> x = first; x != null; ) {
            Node<T> next = x.next;
            x.item = null;
            x.next = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }
}