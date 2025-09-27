package org.rozanski.cipher.list;

public class CipherCycle<T> {
    private int size = 0;
    private Node<T> firstElementInChain = null;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean add(T t) {
        final Node<T> newElement = new Node<>(t);

        if (firstElementInChain == null) {
            firstElementInChain = newElement;
        } else {
            findLastElementInAChain().setNext(newElement);
        }
        size++;
        return true;
    }

    private Node<T> findLastElementInAChain() {
        Node<T> current = firstElementInChain;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        return current;
    }

    public T get(int index) {
        Node<T> current = firstElementInChain;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getValue();
    }

    public void addAll(T... elements) {
        for (T element : elements) {
            add(element);
        }
    }
}
