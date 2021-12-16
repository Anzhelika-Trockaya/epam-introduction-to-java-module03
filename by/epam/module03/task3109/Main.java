package by.epam.module03.task3109;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    //9. Посчитать количество строчных (маленьких) и прописных (больших) букв в введенной строке. Учитывать только английские
    //буквы.
    public static void main(String[] args) {
        String s;
        int uppercaseLetterNumber;
        int lowercaseLetterNumber;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter string: ");
        s = scanner.nextLine();

        uppercaseLetterNumber = countSymbolsInString(s, "[A-Z]");
        lowercaseLetterNumber = countSymbolsInString(s, "[a-z]");

        System.out.println("Number of uppercase letter = " + uppercaseLetterNumber);
        System.out.println("Number of lowercase letter = " + lowercaseLetterNumber);

    }

    public static int countSymbolsInString(String s, String regex) {
        int number = 0;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);

        while (matcher.find()) {
            number++;
        }

        return number;
    }
}
