package org.rozanski.cipher.list;

/**
 * Exception thrown when element is not found within the cycle of characters.
 */
public class ElementNotFoundException extends RuntimeException {
    public ElementNotFoundException() {
    }

    public ElementNotFoundException(String message) {
        super(message);
    }
}
