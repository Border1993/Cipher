package org.rozanski.cipher;

import org.rozanski.cipher.list.CipherCycle;

/**
 * Implementation of cesar cipher.
 */
public class CesarCipher {
    private final Encoder encoder;
    private final Decoder decoder;
    private final int shift;

    public CesarCipher(Alphabet alphabet, int shift) {
        this.shift = shift;
        CipherCycle cipherCycle = CipherCycle.getDefault(alphabet.getCharacters());
        this.encoder = new Encoder(cipherCycle);
        this.decoder = new Decoder(cipherCycle);
    }

    /**
     * Encodes given text.
     *
     * @param textToEncode text to be encoded.
     * @return encoded text.
     */
    public String encode(String textToEncode) {
        return encoder.encode(textToEncode, shift);
    }

    /**
     * Decodes given text.
     *
     * @param textToDecode text to be decoded.
     * @return decoded text.
     */
    public String decode(String textToDecode) {
        return decoder.decode(textToDecode, shift);
    }
}
