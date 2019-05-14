package co.inventorsoft.academy.collections.model;

import java.util.Objects;

class Node<T> {
    T data;
    Node next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, next);
    }
    public String toString(){
        return data.toString();
    }
}

