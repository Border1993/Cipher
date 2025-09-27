package org.rozanski.cipher.list;

public class Node<T> {
    private T value;
    private Node<T> next;
    private Node<T> previous;

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

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }
}
