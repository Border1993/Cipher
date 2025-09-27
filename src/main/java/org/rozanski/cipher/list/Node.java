package org.rozanski.cipher.list;

class Node {
    private final String value;
    private Node next;
    private Node previous;

    public Node(String value) {
        this.value = value;
        next = null;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node newElement) {
        next = newElement;
    }

    public String getValue() {
        return value;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }
}
