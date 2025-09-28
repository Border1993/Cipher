package org.rozanski.cipher;

import java.util.Arrays;

/**
 * Enum representing various alphabets
 */
public enum Alphabet {
    LOWER_CASE_ENGLISH("abcdefghijklmnopqrstuvwxyz");
    private final String[] characters;

    Alphabet(String alphabetString) {
        this.characters = Arrays.stream(alphabetString
                        .split(""))
                .filter(c -> !c.isBlank())
                .toArray(String[]::new);
    }

    public String[] getCharacters() {
        return characters;
    }
}
