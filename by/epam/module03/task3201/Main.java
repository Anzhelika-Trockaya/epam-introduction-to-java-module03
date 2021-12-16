package by.epam.module03.task3201;

//Cоздать приложение, разбирающее текст (текст хранится в строке) и позволяющее выполнять с текстом три различных
//операции: отсортировать абзацы по количеству предложений; в каждом предложении отсортировать слова по длине;
//отсортировать лексемы в предложении по убыванию количества вхождений заданного символа, а в случае равенства – по
//алфавиту.

public class Main {
    public static void main(String[] args) {
        String string;
        Text text;

        string = """
                This is 1 sentence. This is second sentence... This is third sentence!
                In this paragraph is 1 sentence.
                This text contains 6 sentence! And that is six.
                This is a joke! It's 8...
                Ammlkll jl ok; k. Alphabet a paragraph aaakaa; faaaa — aa5aaa, faaaaf!""";

        text = new Text(string);

        System.out.println(text.getString());
        text.paragraphsSort();
        System.out.println("Sorted paragraphs:\n" + text.getString());
        text.wordsInSentencesSort();
        System.out.println("Sorted words in all sentences:\n" + text.getString());
        text.sortLexemesInASentenceInDescendingOrderOfCharNumber(4, 2, 'a');
        System.out.println("Sorted lexemes in the 2 sentence of 4 paragraph in descending order of the number of occurrences" +
                " of a given character 'a':\n" + text.getString());
    }
}
