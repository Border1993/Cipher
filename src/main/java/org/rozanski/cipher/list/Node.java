package org.rozanski.cipher.list;

public class Node<T> {
    private T value;
    private Node<T> next;

    public Node(T value) {
        this.value = value;
        next = null;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> newElement) {
        next = newElement;
    }

    public T getValue() {
        return value;
    }
}
