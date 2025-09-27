package org.rozanski.cipher.list;

public class CipherCycle<T> {
    private int size = 0;
    private Node<T> firstElementInChain = null;

    public CipherCycle() {
    }

    public CipherCycle(T... elements) {
        addAll(elements);
    }

    int size() {
        return size;
    }

    boolean isEmpty() {
        return size == 0;
    }

    boolean add(T t) {
        final Node<T> newElement = new Node<>(t);

        if (firstElementInChain == null) {
            firstElementInChain = newElement;
        } else {
            final Node<T> lastElement = findLastElementInAChain();
            lastElement.setNext(newElement);
            newElement.setPrevious(lastElement);
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

    T get(int index) {
        Node<T> current = firstElementInChain;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getValue();
    }

    void addAll(T... elements) {
        for (T element : elements) {
            add(element);
        }
    }

    private Node<T> find(T valueToFind) {
        Node<T> current = firstElementInChain;
        while (current != null) {
            if (current.getValue().equals(valueToFind)) {
                return current;
            }
            current = current.getNext();
        }
        throw new ElementNotFoundException(valueToFind.toString());
    }

    public T shift(T valueToShift, int shiftValue) {
        Node<T> currentNode = find(valueToShift);
        int elementsToShift = Math.abs(shiftValue);

        if (shiftValue > 0) {
            for (int i = 0; i < elementsToShift; i++) {
                currentNode = currentNode.getNext();
            }
        } else if (shiftValue < 0) {
            for (int i = 0; i < elementsToShift; i++) {
                currentNode = currentNode.getPrevious();
            }
        }

        return currentNode.getValue();
    }
}
