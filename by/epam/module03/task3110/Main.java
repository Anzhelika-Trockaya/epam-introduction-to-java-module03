package by.epam.module03.task3110;

public class Main {
    //10. Строка X состоит из нескольких предложений, каждое из которых кончается точкой, восклицательным или вопросительным
    //знаком. Определить количество предложений в строке X.
    public static void main(String[] args) {
        String x = "Строка X состоит из нескольких предложений! Каждое из которых кончается точкой, восклицательным! " +
                "Или вопросительным знаком? Определить количество предложений в строке X.";
        System.out.println(x);

        int numberOfSentences = 0;

        for (char ch : x.toCharArray()) {
            if (ch == '.' || ch == '?' || ch == '!') {
                numberOfSentences++;
            }
        }

        System.out.println("Number of sentences per line = " + numberOfSentences);
    }
}
