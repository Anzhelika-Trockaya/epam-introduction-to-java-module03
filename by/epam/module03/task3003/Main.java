package by.epam.module03.task3003;

public class Main {
    //3. В строке найти количество цифр.
    public static void main(String[] args) {
        String s;
        int numberOfDigits;

        s = "dff5fff2536fff5szc50";
        System.out.println("String: " + s);

        numberOfDigits = 0;
        for (char ch : s.toCharArray()) {

            if (Character.isDigit(ch)) {
                numberOfDigits++;
            }

        }

        System.out.println("This string contains " + numberOfDigits + " digits.");
    }
}
