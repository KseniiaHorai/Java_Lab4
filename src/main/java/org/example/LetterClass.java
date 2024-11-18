package org.example;

/**
 * LetterClass is for one letter.
 */
public class LetterClass {
    private final char value;

    /**
     * LetterClass creates a Letter object.
     *
     * @param value CHAR VALUE.
     * @throws IllegalArgumentException IS NOT A LETTER.
     */
    public LetterClass(char value) {
        if (!Character.toString(value).matches("[a-zA-Zа-яА-ЯҐґЄєЇїІі]")) {
            throw new IllegalArgumentException("INCORRECT PARAMETER.");
        }
        this.value = value;
    }
    /**
     * getValue receives char value of the letter.
     *
     * @return CHAR VALUE.
     */
    public char getValue() {
        return value;
    }
}
