package org.example;

public class TextClass {
    private final SentenceClass [] sentences;

    public TextClass (SentenceClass [] linguisticExpressions) {
        this.sentences = linguisticExpressions;
    }

    public SentenceClass[] getSentences() {
        return sentences;
    }
}


