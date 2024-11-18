package org.example;

import java.util.Arrays;

/**
 *  WordClass is for a word made up of letters.
 */
public class WordClass extends BaseClass {
    private final LetterClass[] letters;

    /**
     * WordClass creates a Word object.
     *
     * @param letters LETTER ARRAY.
     */
    public WordClass(LetterClass[] letters) {
        this.letters = letters;
    }

    /**
     * LetterClass gets letter array.
     *
     * @return LETTER ARRAY.
     */
    public LetterClass[] getLetters() {
        return letters;
    }

    /**
     * toString returns a string representation of the word.
     *
     * @return STRING.
     */
    @Override
    public String toString() {
        return Arrays.toString(
                Arrays.stream(letters).map(LetterClass::getValue).toArray()
        ).replaceAll("[\\[, \\]]+", "");
    }
}
