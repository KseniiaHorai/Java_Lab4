package org.example;

/**
 * TextClass is text from sentences.
 */
public class TextClass {
    private final SentenceClass [] sentences;

    /**
     * TextClass creates a Text object.
     *
     * @param linguisticExpressions SENTENCE ARRAY.
     */
    public TextClass (SentenceClass [] linguisticExpressions) {
        this.sentences = linguisticExpressions;
    }
    /**
     * getSentences gets the sentence array.
     *
     * @return SENTENCE ARRAY.
     */
    public SentenceClass[] getSentences() {
        return sentences;
    }
}


