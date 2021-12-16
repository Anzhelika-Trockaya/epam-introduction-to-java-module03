package by.epam.module03.task3108;

import java.util.Scanner;

public class Main {
    //8. Вводится строка слов, разделенных пробелами. Найти самое длинное слово и вывести его на экран. Случай, когда самых
    //длинных слов может быть несколько, не обрабатывать.
    public static void main(String[] args) {
        String s;
        int maxWordSize = 0;
        String longestWord = "";
        String[] words;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter words: ");
        s = scanner.nextLine();

        words = s.split("\s");

        for (String word : words) {

            if (word.length() > maxWordSize) {
                maxWordSize = word.length();
                longestWord = word;
            }

        }

        System.out.println("The longest word is \"" + longestWord + "\"");

    }
}
