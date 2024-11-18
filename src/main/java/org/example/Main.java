package org.example;

import java.io.IOException;
import java.util.*;

/**
 * MAIN has the MAIN method along with functions for reading input, handling expressions, and displaying the output.
 */

public class Main {
    /**
     * MAIN METHOD reads input, processes expressions, and prints unfiltered, unique, and sorted unique words.
     *
     * @param args ARGUMENTS from the command line.
     */
    public static void main(String[] args) {
        try {
            TextClass  text = readConsoleInput();
            List<WordClass > words = getWordsFromText(text);
            List<WordClass > filteredWords = removeDuplicates(words);
            List<WordClass > filteredArray = new ArrayList<>(filteredWords);
            filteredArray.sort(Comparator.comparing(word -> word.toString().toLowerCase()));

            outputArray(words.toArray(new BaseClass[0]), "\nYOUR INPUT");
            outputArray(filteredWords.toArray(new BaseClass[0]), "\nFILTERED DATA");
            outputArray(filteredArray.toArray(new BaseClass[0]), "\nUNIQUE SORTED DATA");
        } catch (IOException e) {
            throw new RuntimeException("An error occurred while reading the console input: " + e.getMessage());
        }
    }
    /**
     * readConsoleInput gets input users and creates a Text object.
     *
     * @return OBJECT with sentences.
     * @throws IOException ERROR in the input.
     */
    public static TextClass readConsoleInput() throws IOException {
        Scanner scanner = new Scanner(System.in);
        char[] lineChars = scanner.nextLine().toCharArray();
        char[][] sentences = getSentences(lineChars);
        SentenceClass [] sentenceObjects = new SentenceClass [sentences.length];

        for (int i = 0; i < sentences.length; i++) {
            SentenceClass  sentence = new SentenceClass (extractLinguisticExpressions(sentences[i]));
            sentenceObjects[i] = sentence;
        }

        scanner.close();
        return new TextClass (sentenceObjects);
    }

    /**
     * getSentences divides a char array into sentences.
     *
     * @param lineChars ARRAY with input.
     * @return ARRAY with sentences.
     */
    public static char[][] getSentences(char[] lineChars) {
        List<char[]> sentences = new ArrayList<>();
        List<Character> currentWordLetters = new ArrayList<>();

        for (char c : lineChars) {
            if (Character.toString(c).matches("[.!?]")) {
                addLetters(sentences, currentWordLetters);
                sentences.add(new char[]{c});
            } else if (Character.toString(c).matches("[a-zA-Zа-яА-ЯҐґЄєЇїІі'`]|\\d")) {
                currentWordLetters.add(c);
            } else if (c == ' ') {
                addLetters(sentences, currentWordLetters);
            } else {
                sentences.add(new char[]{c});
            }
        }

        // Handle the last word if any
        if (!currentWordLetters.isEmpty()) {
            char[] wordChars = new char[currentWordLetters.size()];
            for (int i = 0; i < currentWordLetters.size(); i++) {
                wordChars[i] = currentWordLetters.get(i);
            }
            sentences.add(wordChars);
        }

        char[][] result = new char[sentences.size()][];
        for (int i = 0; i < sentences.size(); i++) {
            result[i] = sentences.get(i);
        }

        return result;
    }

    /**
     * addLetters adds letters of the word to the list of sentences.
     *
     * @param sentences           LIST of sentences .
     * @param currentWordLetters  LIST of letters .
     */
    private static void addLetters(List<char[]> sentences, List<Character> currentWordLetters) {
        if (!currentWordLetters.isEmpty()) {
            char[] wordChars = new char[currentWordLetters.size()];
            for (int i = 0; i < currentWordLetters.size(); i++) {
                wordChars[i] = currentWordLetters.get(i);
            }
            sentences.add(wordChars);
            currentWordLetters.clear();
        }
    }

    /**
     * extractLinguisticExpressions gets expressions from the sentence.
     *
     * @param sentenceChars SENTENCE from the user.
     * @return ARRAY of objects from the sentence.
     */
    public static BaseClass[] extractLinguisticExpressions(char[] sentenceChars) {
        List<BaseClass> linguisticExpressions = new ArrayList<>();
        List<LetterClass> currentWordLetters = new ArrayList<>();

        for (char c : sentenceChars) {
            if (Character.toString(c).matches("[a-zA-Zа-яА-ЯҐґЄєЇїІі'`]|\\d")) {
                currentWordLetters.add(new LetterClass(c));
            } else {
                if (!currentWordLetters.isEmpty()) {
                    linguisticExpressions.add(createWord(currentWordLetters.toArray(new LetterClass[0])));
                    currentWordLetters.clear();
                }
                if (c != ' ') {
                    linguisticExpressions.add(new PunctuationClass(c));
                }
            }
        }

        // Handle the last word if any
        if (!currentWordLetters.isEmpty()) {
            linguisticExpressions.add(createWord(currentWordLetters.toArray(new LetterClass[0])));
        }

        return linguisticExpressions.toArray(new BaseClass[0]);
    }

    /**
     * createWord creates OBJECT from the string.
     *
     * @param letters ARRAY of letters.
     * @return WORD OBJECT.
     */
    public static WordClass createWord(LetterClass[] letters) {
        return new WordClass(letters);
    }

    /**
     * getWordsFromText gets words from the text object.
     *
     * @param text TEXT OBJECT.
     * @return LIST of word objects from the text.
     */

    public static List<WordClass> getWordsFromText(TextClass text) {
        List<WordClass> words = new ArrayList<>();

        for (SentenceClass sentence : text.getSentences()) {
            for (BaseClass expression : sentence.getLinguisticExpressions()) {
                if (expression instanceof WordClass) {
                    words.add((WordClass) expression);
                }
            }
        }

        return words;
    }
    /**
     * removeDuplicates removes duplicates words the list of words.
     *
     * @param unfilteredWords LIST of words.
     * @return LIST of unique words.
     */
    public static List<WordClass> removeDuplicates(List<WordClass> unfilteredWords) {
        Map<String, WordClass> uniqueWordsMap = new LinkedHashMap<>();

        for (WordClass word : unfilteredWords) {
            String lowercaseWord = word.toString().toLowerCase();
            uniqueWordsMap.putIfAbsent(lowercaseWord, word);
        }

        return new ArrayList<>(uniqueWordsMap.values());
    }
    /**
     * outputArray prints an array with a message.
     *
     * @param array   ARRAY of expressions to be printed.
     * @param message MESSAGE.
     */
    public static void outputArray(BaseClass[] array, String message) {
        System.out.println(message);
        for (BaseClass expression : array) {
            System.out.print(expression.toString() + " ");
        }
        System.out.println();
    }
}
