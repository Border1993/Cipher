package org.rozanski.cipher;

import java.util.Arrays;

/**
 * Enum representing various alphabets
 */
public class Alphabet {
    public static Alphabet LOWER_CASE_ENGLISH = from("abcdefghijklmnopqrstuvwxyz");

    private final String[] characters;

    private Alphabet(String[] characters) {
        this.characters = characters;
    }

    /**
     * Factory method for alphabet. Splits alphabet string into
     * @param alphabetString
     * @return
     */
    public static Alphabet from(String alphabetString) {
        String[] characters = Arrays.stream(alphabetString.split(""))
                .filter(c -> !c.isBlank())
                .toArray(String[]::new);
        return new Alphabet(characters);
    }

    public String[] getCharacters() {
        return characters;
    }
}
