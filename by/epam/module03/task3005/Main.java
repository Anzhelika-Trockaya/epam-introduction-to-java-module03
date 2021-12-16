package by.epam.module03.task3005;

public class Main {
    //5. Удалить в строке все лишние пробелы, то есть серии подряд идущих пробелов заменить на одиночные пробелы.
    //Крайние пробелы в строке удалить.
    public static void main(String[] args) {
        String s;

        s = "  This     is    a string.    ";
        System.out.println("\"" + s + "\"");

        s = removeRedundantSpaces(s);
        System.out.println("\"" + s + "\"");
    }

    public static String removeRedundantSpaces(String s) {
        char[] sChars;
        String result;
        char[] resultChars;
        int resultSize;
        int resultIndex;
        int sCharsIndex;

        sChars = s.toCharArray();
        resultSize = sChars.length - countNumberOfRedundantSpaces(sChars);

        if (resultSize < sChars.length) {

            resultChars = new char[resultSize];
            sCharsIndex = findFirstNotSpaceSymbolIndex(sChars);
            resultIndex = 0;

            for (; sCharsIndex < sChars.length && resultIndex < resultSize; sCharsIndex++) {

                resultChars[resultIndex] = sChars[sCharsIndex];
                resultIndex++;

                if (sChars[sCharsIndex] == ' ') {

                    while (sCharsIndex + 1 < sChars.length && sChars[sCharsIndex + 1] == ' ') {
                        sCharsIndex++;
                    }

                }
            }

            result = new String(resultChars);

        } else {
            result = s;
        }

        return result;
    }

    private static int findFirstNotSpaceSymbolIndex(char[] sChars) {
        int index;

        index = 0;

        while (sChars[index] == ' ') {
            index++;
        }

        return index;
    }

    private static int countNumberOfRedundantSpaces(char[] sChars) {
        int numberOfSpaces = 0;

        for (int i = 0; i < sChars.length - 1; i++) {
            if (sChars[i] == ' ') {
                i++;

                while (i < sChars.length && sChars[i] == ' ') {
                    numberOfSpaces++;
                    i++;
                }
            }
        }

        if (sChars[0] == ' ') {
            numberOfSpaces++;
        }

        if (sChars[sChars.length - 1] == ' ') {
            numberOfSpaces++;
        }

        return numberOfSpaces;
    }
}
