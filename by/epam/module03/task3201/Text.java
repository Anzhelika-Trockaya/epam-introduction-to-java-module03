package by.epam.module03.task3201;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//Cоздать приложение, разбирающее текст (текст хранится в строке) и позволяющее выполнять с текстом три различных
//операции: отсортировать абзацы по количеству предложений; в каждом предложении отсортировать слова по длине;
//отсортировать лексемы в предложении по убыванию количества вхождений заданного символа, а в случае равенства – по
//алфавиту.

public class Text {
    private final Paragraph[] paragraphs;

    public Text(String s) {
        String[] stringsParagraphs;

        stringsParagraphs = s.split("\n");
        paragraphs = new Paragraph[stringsParagraphs.length];

        for (int i = 0; i < stringsParagraphs.length; i++) {
            paragraphs[i] = new Paragraph(stringsParagraphs[i]);
        }
    }

    public void paragraphsSort() {
        Paragraph temp;

        for (int i = 0; i < paragraphs.length - 1; i++) {
            for (int j = i + 1; j < paragraphs.length; j++) {

                if (paragraphs[i].sentencesNumber() > paragraphs[j].sentencesNumber()) {
                    temp = paragraphs[i];
                    paragraphs[i] = paragraphs[j];
                    paragraphs[j] = temp;
                }

            }
        }
    }

    public void wordsInSentencesSort() {
        for (Paragraph paragraph : paragraphs) {
            for (Sentence sentence : paragraph.getSentences()) {
                sentence.wordsSort();
            }
        }
    }

    public void sortLexemesInASentenceInDescendingOrderOfCharNumber(int numOfParagraph, int numOfSentence, char ch) {
        if (numOfParagraph < 1 || numOfSentence < 1 || numOfParagraph > paragraphs.length ||
                numOfSentence > paragraphs[numOfParagraph - 1].sentencesNumber()) {
            throw new IllegalArgumentException("Sorting failed! Incorrect number of paragraph or number of sentence.");
        }

        paragraphs[numOfParagraph - 1].getSentence(numOfSentence - 1).sortLexemesInDescendingOrderOfCharsNumber(ch);
    }

    public String getString() {
        StringBuilder textBuilder;

        textBuilder = new StringBuilder();

        for (Paragraph paragraph : paragraphs) {
            textBuilder.append(paragraph.getString());
        }

        return textBuilder.toString();
    }

    private static class Paragraph {
        private static final char[] POSSIBLE_PUNCTUATION_MARKS;
        private final Sentence[] sentences;

        static {
            POSSIBLE_PUNCTUATION_MARKS = new char[]{'!', '?', '.', ','};
        }

        public Paragraph(String s) {
            String[] stringsSentences;
            int sizeParagraph;
            StringBuilder punctuationMark;

            stringsSentences = s.split("(!|\\?|(\\.)+)\\s?");
            sentences = new Sentence[stringsSentences.length];

            sizeParagraph = 0;

            for (int i = 0; i < stringsSentences.length; i++) {
                sizeParagraph += stringsSentences[i].length();
                punctuationMark = new StringBuilder();

                while (sizeParagraph < s.length() && isPunctuationMark(s.charAt(sizeParagraph))){
                    punctuationMark.append(s.charAt(sizeParagraph));
                    sizeParagraph++;
                }
                sizeParagraph++;

                sentences[i] = new Sentence(stringsSentences[i], punctuationMark.toString());
            }
        }

        private boolean isPunctuationMark(char ch) {
            for (int i = 0; i < POSSIBLE_PUNCTUATION_MARKS.length; i++) {
                if (ch == POSSIBLE_PUNCTUATION_MARKS[i]) {
                    return true;
                }
            }

            return false;
        }

        public int sentencesNumber() {
            return sentences.length;
        }

        public Sentence[] getSentences() {
            return sentences;
        }

        public Sentence getSentence(int index) {
            return sentences[index];
        }

        public String getString() {
            StringBuilder paragraphBuilder;

            paragraphBuilder = new StringBuilder();

            for (int i = 0; i < sentences.length - 1; i++) {
                paragraphBuilder.append(sentences[i].getString());
                paragraphBuilder.append(" ");
            }

            paragraphBuilder.append(sentences[sentences.length - 1].getString());
            paragraphBuilder.append("\n");

            return paragraphBuilder.toString();
        }
    }

    private static class Sentence {
        private Word[] words;
        private final String punctuationMark;

        public Sentence(String sentence, String punctuationMark) {
            String[] stringWords;

            stringWords = sentence.split("\\s?[,:;\\-—]?\\s");
            words = new Word[stringWords.length];

            for (int i = 0; i < stringWords.length; i++) {
                words[i] = new Word(stringWords[i].replaceAll(" ", "").replaceAll("—", ""));
            }

            this.punctuationMark = punctuationMark;
        }

        public void wordsSort() {
            Word temp;

            for (int i = 0; i < words.length - 1; i++) {
                for (int j = i + 1; j < words.length; j++) {

                    if (words[i].length() > words[j].length()) {
                        temp = words[i];
                        words[i] = words[j];
                        words[j] = temp;
                    }

                }
            }
        }

        public void sortLexemesInDescendingOrderOfCharsNumber(char ch) {
            int currentIndex;
            Word[] sortedWords;
            List<Word> wordsWithEqualLength;

            sortedWords = new Word[words.length];
            wordsWithEqualLength = new ArrayList<>();

            currentIndex = 0;
            for (int numberOfChar = maxNumberOfCharsInAWord(ch); numberOfChar >= 0; numberOfChar--) {

                for (Word word : words) {
                    if (word.countCharsNumber(ch) == numberOfChar) {
                        wordsWithEqualLength.add(word);
                    }
                }

                wordsWithEqualLength.sort(Comparator.comparing(Word::toString));

                for (int j = 0; j < wordsWithEqualLength.size(); j++, currentIndex++) {
                    sortedWords[currentIndex] = wordsWithEqualLength.get(j);
                }

                wordsWithEqualLength.clear();

            }

            words = sortedWords;
        }

        private int maxNumberOfCharsInAWord(char ch) {
            int maxNumber;
            int currentNumber;

            maxNumber = 0;

            for (Word word : words) {
                currentNumber = word.countCharsNumber(ch);

                if (currentNumber > maxNumber) {
                    maxNumber = currentNumber;
                }
            }

            return maxNumber;
        }

        public String getString() {
            StringBuilder sentenceBuilder;

            sentenceBuilder = new StringBuilder();

            for (int i = 0; i < words.length - 1; i++) {
                sentenceBuilder.append(words[i].getString());
                sentenceBuilder.append(" ");
            }

            sentenceBuilder.append(words[words.length - 1].getString());
            sentenceBuilder.append(punctuationMark);

            return sentenceBuilder.toString();
        }
    }

    private static class Word {
        private final String word;

        public Word(String word) {
            this.word = word;
        }

        public int length() {
            return word.length();
        }

        public int countCharsNumber(char ch) {
            int number;
            char[] wordChars;

            number = 0;
            wordChars = word.toCharArray();

            for (int i = 0; i < wordChars.length; i++) {
                if (wordChars[i] == ch) {
                    number++;
                }
            }

            return number;
        }

        public String getString() {
            return word;
        }
    }


}
