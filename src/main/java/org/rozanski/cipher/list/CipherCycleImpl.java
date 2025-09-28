package org.rozanski.cipher.list;

import java.util.List;

/**
 * Cycle of elements for cipher. Effectively a bidirectional cyclic list.
 */
class CipherCycleImpl implements CipherCycle {
    private int size = 0;
    private Node firstElementInCycle = null;
    private Node lastElementInCycle = null;

    CipherCycleImpl() {
    }

    /**
     * Creates cipher with provided characters.
     *
     * @param elements array with characters of the cipher.
     */
    CipherCycleImpl(String... elements) {
        addAll(elements);
    }

    /**
     * Creates cipher with provided characters.
     *
     * @param elements characters of the cipher.
     * @implNote groovy doesn't understand varargs.
     */
    CipherCycleImpl(List<String> elements) {
        addAll(elements.toArray(String[]::new));
    }

    int size() {
        return size;
    }

    void add(String element) {
        final Node newElement = new Node(element);
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
    }

    String get(int index) {
        Node current = firstElementInCycle;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getValue();
    }

    void addAll(String... elements) {
        for (String element : elements) {
            add(element);
        }
    }

    private Node find(String valueToFind) {
        if (size > 0) {
            Node current = firstElementInCycle;
            do {
                if (current.getValue().equals(valueToFind)) {
                    return current;
                }
                current = current.getNext();
            } while (current != firstElementInCycle);
        }

        throw new ElementNotFoundException("Element: " + valueToFind + " not found.");
    }

    /**
     * Shifts character by provided amount of characters.
     *
     * @param valueToShift character to shift.
     * @param shiftValue   amount of characters to shift. Can be negative.
     * @return shifted character.
     */
    @Override
    public String shift(String valueToShift, int shiftValue) {
        Node currentNode = find(valueToShift);
        final int elementsToShift = Math.abs(shiftValue);

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
