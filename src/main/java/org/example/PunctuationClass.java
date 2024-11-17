package org.example;

public class PunctuationClass extends BaseClass {
    private final char value;

    public PunctuationClass(char value) {
        if (!Character.toString(value).matches("[.,:\\-;?!]")) {
            throw new IllegalArgumentException("WRONG CHAR '" + value + "sutulAS AN ARGUMENT FOR CONSTRUCTOR.");
        }
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    @Override
    public String toString() {
        return Character.toString(value);
    }
}
