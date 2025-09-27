package org.rozanski.cipher.list;

public class CipherCycle<T> {
    private int size = 0;
    private Node<T> firstElementInCycle = null;
    private Node<T> lastElementInCycle = null;

    public CipherCycle() {
    }

    public CipherCycle(T... elements) {
        addAll(elements);
    }

    int size() {
        return size;
    }

    boolean add(T t) {
        final Node<T> newElement = new Node<>(t);

        if (firstElementInCycle == null) {
            firstElementInCycle = newElement;
            lastElementInCycle = newElement;
            newElement.setNext(newElement);
            newElement.setPrevious(newElement);
        } else {
            // Join former last element with new one
            lastElementInCycle.setNext(newElement);
            newElement.setPrevious(lastElementInCycle);

            // Join first element with new one
            firstElementInCycle.setPrevious(newElement);
            newElement.setNext(firstElementInCycle);

            lastElementInCycle = newElement;
        }
        size++;
        return true;
    }

    T get(int index) {
        Node<T> current = firstElementInCycle;
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
        Node<T> current = firstElementInCycle;
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
