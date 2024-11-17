package org.example;

import java.util.Arrays;

public class WordClass extends BaseClass {
    private final LetterClass[] letters;

    public WordClass(LetterClass[] letters) {
        this.letters = letters;
    }

    public LetterClass[] getLetters() {
        return letters;
    }

    @Override
    public String toString() {
        return Arrays.toString(
                Arrays.stream(letters).map(LetterClass::getValue).toArray()
        ).replaceAll("[\\[, \\]]+", "");
    }
}
