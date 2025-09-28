package org.rozanski.cipher;

import org.rozanski.cipher.list.CipherCycle;

import java.util.Arrays;
import java.util.stream.Collectors;


/**
 * Encoder for strings. Transforms each character according to cipher cycle rules and character shift count.
 */
class Encoder {
    private final CipherCycle cipherCycle;

    Encoder(CipherCycle cipherCycle) {
        this.cipherCycle = cipherCycle;
    }

    /**
     * Encodes provided string.
     *
     * @param textToEncode text to be encoded.
     * @param shift        amount of characters to be shifted.
     * @return encoded string.
     */
    public String encode(String textToEncode, int shift) {
        return Arrays.stream(textToEncode.split(""))
                .filter(c -> !c.isBlank()) //The split will produce empty string at the beginning.
                .map(c -> cipherCycle.shift(c, shift))
                .collect(Collectors.joining());
    }
}
