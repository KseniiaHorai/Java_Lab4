package org.example;

public class LetterClass {
    private final char value;

    public LetterClass(char value) {
        if (!Character.toString(value).matches("[a-zA-Zа-яА-ЯҐґЄєЇїІі]")) {
            throw new IllegalArgumentException("INCORRECT PARAMETER.");
        }
        this.value = value;
    }

    public char getValue() {
        return value;
    }
}
