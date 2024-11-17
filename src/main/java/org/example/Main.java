package org.example;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try {
            TextClass  text = readConsoleInput();
            List<WordClass > words = extractWordsFromText(text);
            List<WordClass > filteredWords = removeDuplicates(words);
            List<WordClass > filteredArray = new ArrayList<>(filteredWords);
            filteredArray.sort(Comparator.comparing(word -> word.toString().toLowerCase()));

            printLinguisticExpressionArrayWithMessage(words.toArray(new BaseClass[0]), "\nYOUR INPUT");
            printLinguisticExpressionArrayWithMessage(filteredWords.toArray(new BaseClass[0]), "\nFILTERED DATA");
            printLinguisticExpressionArrayWithMessage(filteredArray.toArray(new BaseClass[0]), "\nUNIQUE SORTED DATA");
        } catch (IOException e) {
            throw new RuntimeException("An error occurred while reading the console input: " + e.getMessage());
        }
    }

    public static TextClass readConsoleInput() throws IOException {
        Scanner scanner = new Scanner(System.in);
        char[] lineChars = scanner.nextLine().toCharArray();
        char[][] sentences = splitSentences(lineChars);
        SentenceClass [] sentenceObjects = new SentenceClass [sentences.length];

        for (int i = 0; i < sentences.length; i++) {
            SentenceClass  sentence = new SentenceClass (extractLinguisticExpressions(sentences[i]));
            sentenceObjects[i] = sentence;
        }

        scanner.close();
        return new TextClass (sentenceObjects);
    }

    public static char[][] splitSentences(char[] lineChars) {
        List<char[]> sentences = new ArrayList<>();
        List<Character> currentWordLetters = new ArrayList<>();

        for (char c : lineChars) {
            if (Character.toString(c).matches("[.!?]")) {
                writeWordChars(sentences, currentWordLetters);
                sentences.add(new char[]{c});
            } else if (Character.toString(c).matches("[a-zA-Zа-яА-ЯҐґЄєЇїІі'`]|\\d")) {
                currentWordLetters.add(c);
            } else if (c == ' ') {
                writeWordChars(sentences, currentWordLetters);
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

    private static void writeWordChars(List<char[]> sentences, List<Character> currentWordLetters) {
        if (!currentWordLetters.isEmpty()) {
            char[] wordChars = new char[currentWordLetters.size()];
            for (int i = 0; i < currentWordLetters.size(); i++) {
                wordChars[i] = currentWordLetters.get(i);
            }
            sentences.add(wordChars);
            currentWordLetters.clear();
        }
    }

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

    public static WordClass createWord(LetterClass[] letters) {
        return new WordClass(letters);
    }

    public static List<WordClass> extractWordsFromText(TextClass text) {
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

    public static List<WordClass> removeDuplicates(List<WordClass> unfilteredWords) {
        Map<String, WordClass> uniqueWordsMap = new LinkedHashMap<>();

        for (WordClass word : unfilteredWords) {
            String lowercaseWord = word.toString().toLowerCase();
            uniqueWordsMap.putIfAbsent(lowercaseWord, word);
        }

        return new ArrayList<>(uniqueWordsMap.values());
    }

    public static void printLinguisticExpressionArrayWithMessage(BaseClass[] array, String message) {
        System.out.println(message);
        for (BaseClass expression : array) {
            System.out.print(expression.toString() + " ");
        }
        System.out.println();
    }
}
