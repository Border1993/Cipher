package org.rozanski.cipher;

import org.rozanski.cipher.list.CipherCycle;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Decoder for strings.Transforms each character according to cipher cycle rules and character shift count.
 */
public class Decoder {
    public static final String WHITESPACE_SYMBOL = " ";
    private final CipherCycle cipherCycle;

    public Decoder(CipherCycle cipherCycle) {
        this.cipherCycle = cipherCycle;
    }

    /**
     * Decodes provided string.
     *
     * @param encodedText   encoded text.
     * @param encodingShift shift that was used for encoding.
     * @return decoded text.
     */
    public String decode(String encodedText, int encodingShift) {
        return Arrays.stream(encodedText.split(""))
                .filter(c -> !c.isBlank() || c.equals(" "))
                .map(c -> c.equals(WHITESPACE_SYMBOL) ? " " : cipherCycle.shift(c, -encodingShift))
                .collect(Collectors.joining());
    }
}
