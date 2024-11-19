# Lab4: Classes in Java

## Objective
Learn the concepts of relationships between classes in Java. Gain practical skills in creating and utilizing classes for different elements of text (letters, words, sentences, punctuation marks, and text) and using them to perform text manipulation tasks.

## Task
1. **Modify Lab 2 as follows:**
    - Create separate classes for **letters**, **words**, **sentences**, **punctuation marks**, and **text**.
    - A **word** should consist of an array of `Letter` objects.
    - A **sentence** should consist of an array of `Word` and `PunctuationMark` objects.
    - A **text** should consist of an array of `Sentence` objects.
    - Replace consecutive spaces and tabs in the text with a single space.

2. **Implement a new class containing an executable method** that performs the operations described in Lab 2 using the newly created classes as data types.

---

## Implementation Details

### Class Design

- **Letter Class**: Represents a single letter.
- **Word Class**: Contains an array of `Letter` objects and provides methods for word-level operations.
- **PunctuationMark Class**: Represents a punctuation mark (e.g., `.`, `,`, `!`).
- **Sentence Class**: Contains an array of `Word` and `PunctuationMark` objects and includes methods for sentence-level operations.
- **Text Class**: Composed of an array of `Sentence` objects and provides methods for manipulating the entire text.

### Coding Standards
The code will adhere to Java Code Conventions (or Google Java Style Guide) to ensure readability and maintainability.

---

## Getting Started
To get started with this project:
1. Clone the repository to your local machine.
2. Open the project in your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse).
3. Run the program:
```cmd
  mvn clean install
  java -cp target/Lab4_Horai-1.0-SNAPSHOT.jar org.example.Main
```
