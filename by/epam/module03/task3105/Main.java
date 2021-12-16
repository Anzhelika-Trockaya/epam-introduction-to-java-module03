package by.epam.module03.task3105;

public class Main {
    //5. Подсчитать, сколько раз среди символов заданной строки встречается буква “а”.
    public static void main(String[] args) {
        String s;
        int aLetterNumber;

        s = "Ank...aa  hh;po hhA";
        System.out.println(s);

        aLetterNumber = 0;

        for (char ch : s.toCharArray()) {
            if (ch == 'a' || ch == 'A') {
                aLetterNumber++;
            }
        }

        System.out.println("Number of letter \"a\" = " + aLetterNumber);
    }
}
