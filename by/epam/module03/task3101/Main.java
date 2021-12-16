package by.epam.module03.task3101;

public class Main {
    //1. Дан текст (строка). Найдите наибольшее количество подряд идущих пробелов в нем.
    public static void main(String[] args) {
        String s;
        int maxNumberOfSpace;
        int currentNumberOfSpace;

        s = "This is text.  This is       {7}text.This is text.   This is text.     This is text. This is text.";
        System.out.println(s);

        maxNumberOfSpace = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == ' ') {

                currentNumberOfSpace = 1;
                i++;

                while (i < s.length() && s.charAt(i) == ' ') {
                    currentNumberOfSpace++;
                    i++;
                }

                if (currentNumberOfSpace > maxNumberOfSpace) {
                    maxNumberOfSpace = currentNumberOfSpace;
                }

            }

        }

        System.out.println("The largest number of consecutive spaces in this text = " + maxNumberOfSpace);
    }
}
