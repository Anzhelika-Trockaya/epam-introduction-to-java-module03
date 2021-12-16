package by.epam.module03.task3107;

import java.util.Scanner;

public class Main {
    //7. Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы. Например, если было введено "abc cde
    //def", то должно быть выведено "abcdef".
    public static void main(String[] args) {
        String s;
        char[] charArray;

        System.out.println("Enter a string:");
        Scanner scanner = new Scanner(System.in);
        s = scanner.nextLine();

        charArray = s.toCharArray();

        for (int i = 0; i < charArray.length - 1; i++) {
            for (int j = i + 1; j < charArray.length; j++) {

                if (charArray[j] == charArray[i]) {
                    charArray[j] = ' ';
                }

            }
        }

        s = new String(charArray).replaceAll("\s", "");
        System.out.println(s);
    }
}
