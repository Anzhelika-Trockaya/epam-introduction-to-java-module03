package by.epam.module03.task3004;

public class Main {
    //4. В строке найти количество чисел
    public static void main(String[] args) {
        String s = "This1 is a 41.5 stri3.14ng 25";
        System.out.println(s);

        System.out.println("This string contains " + countNumbers(s) + " numbers");
    }

    public static int countNumbers(String s) {
        int amountOfNumbers;
        char[] sChars;

        sChars = s.toCharArray();
        amountOfNumbers = 0;

        for (int i = 0; i < sChars.length; i++) {

            if (Character.isDigit(sChars[i])) {

                amountOfNumbers++;
                i++;

                while (i < sChars.length && Character.isDigit(sChars[i])) {
                    i++;
                }

                if (i < sChars.length && sChars[i] == '.' && (i + 1) < sChars.length && Character.isDigit(sChars[i + 1])) {
                    i++;

                    while (i < sChars.length && Character.isDigit(sChars[i])) {
                        i++;
                    }

                }

            }

        }

        return amountOfNumbers;
    }
}
