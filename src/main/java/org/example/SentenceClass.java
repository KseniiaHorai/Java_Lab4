package org.example;

public class SentenceClass {
    private final BaseClass[] linguisticExpressions;

    public SentenceClass (BaseClass[] linguisticExpressions) {
        this.linguisticExpressions = linguisticExpressions;
    }

    public BaseClass[] getLinguisticExpressions() {
        return linguisticExpressions;
    }
}
