package by.epam.module03.task3106;

public class Main {
    //6. Из заданной строки получить новую, повторив каждый символ дважды.
    public static void main(String[] args) {
        String s = "This is a string!";
        String result;
        System.out.println(s);

        result = new String(doubleArraysChars(s.toCharArray()));
        System.out.println(result);
    }

    public static char[] doubleArraysChars(char[] array) {
        char[] result;

        result = new char[array.length * 2];

        for (int i = 0; i < array.length; i++) {
            result[2 * i] = array[i];
            result[2 * i + 1] = array[i];
        }

        return result;
    }
}
