package org.example;
/**
 * PunctuationClass is for punctuation.
 */
public class PunctuationClass extends BaseClass {
    private final char value;

    /**
     * PunctuationClass creates a PunctuationClass object.
     *
     * @param value CHAR VALUE.
     * @throws IllegalArgumentException INVALID INPUT.
     */
    public PunctuationClass(char value) {
        if (!Character.toString(value).matches("[.,:\\-;?!]")) {
            throw new IllegalArgumentException("WRONG CHAR '" + value + "AS AN ARGUMENT FOR CONSTRUCTOR.");
        }
        this.value = value;
    }
    /**
     * getValue gets char value
     *
     * @return CHAR VALUE.
     */
    public char getValue() {
        return value;
    }
    /**
     * toString returns a string representation of the punctuation mark.
     *
     * @return STRING.
     */
    @Override
    public String toString() {
        return Character.toString(value);
    }
}
