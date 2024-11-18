package org.example;
/**
 * SentenceClass is for sentences with expressions.
 */
public class SentenceClass {
    private final BaseClass[] linguisticExpressions;

    /**
     * SentenceClass creates a Sentence object.
     *
     * @param linguisticExpressions EXPRESSION ARRAY.
     */
    public SentenceClass (BaseClass[] linguisticExpressions) {
        this.linguisticExpressions = linguisticExpressions;
    }
    /**
     * getLinguisticExpressions gets the array of linguistic expressions.
     *
     * @return EXPRESSION ARRAY.
     */
    public BaseClass[] getLinguisticExpressions() {
        return linguisticExpressions;
    }
}
