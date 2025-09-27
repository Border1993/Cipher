package org.rozanski.cipher.list;

public interface CipherCycle {
    String shift(String valueToShift, int shiftValue);

    static CipherCycle getDefault(String... elements) {
        return new CipherCycleImpl(elements);
    }
}
