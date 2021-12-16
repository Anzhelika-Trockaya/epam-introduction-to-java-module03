package by.epam.module03.task3002;

public class Main {
    //2. Замените в строке все вхождения 'word' на 'letter'.
    public static void main(String[] args) {
        String s;

        s = "As nouns the difference between word and words is that word is the smallest unit of language which " +
                "has a particular meaning and can be expressed by itself; the smallest discrete," +
                " meaningful unit of language while words is .word";
        System.out.println(s);

        s = replaceAll(s, "word", "letter");
        System.out.println(s);
    }

    public static String replaceAll(String text, String substring, String replacement) {
        String result;
        char[] textChars;
        int numberOfSubstringsInText;
        int resultTextSize;
        char[] resultTextChars;

        textChars = text.toCharArray();

        numberOfSubstringsInText = numberOfSubstrings(textChars, substring.toCharArray());
        resultTextSize = findResultTextSize(textChars.length, substring.length(), replacement.length(), numberOfSubstringsInText);
        resultTextChars = new char[resultTextSize];
        fillResultStringChars(textChars, resultTextChars, substring.toCharArray(), replacement.toCharArray());

        result = new String(resultTextChars);

        return result;
    }

    private static int numberOfSubstrings(char[] text, char[] substring) {
        int number = 0;
        int numberOfCharsMatches;

        for (int i = 0; i < text.length - substring.length + 1; i++) {

            numberOfCharsMatches = 0;

            for (int j = 0; j < substring.length; j++) {
                if (text[i + j] == substring[j]) {
                    numberOfCharsMatches++;
                }
            }

            if (numberOfCharsMatches == substring.length) {
                number++;
                i += (substring.length - 1);
            }

        }

        return number;
    }

    private static int findResultTextSize(int textSize, int substringSize, int replacementSize, int numberOfReplacement) {
        int resultTextSize = textSize;

        if (substringSize != replacementSize && numberOfReplacement != 0) {
            resultTextSize += (replacementSize - substringSize) * numberOfReplacement;
        }

        return resultTextSize;
    }

    private static void fillResultStringChars(char[] textChars, char[] resultTextChars, char[] substringChars, char[] replacementChars) {
        int indexOfResultArray = 0;

        for (int i = 0; i < textChars.length; i++) {

            if (isSubstringFromThePosition(textChars, substringChars, i)) {

                writeReplacementFromThePosition(resultTextChars, replacementChars, indexOfResultArray);
                i += substringChars.length - 1;
                indexOfResultArray += replacementChars.length;

            } else {

                resultTextChars[indexOfResultArray] = textChars[i];
                indexOfResultArray++;

            }

        }
    }

    private static boolean isSubstringFromThePosition(char[] textChars, char[] substringChars, int position) {
        if (position > textChars.length - substringChars.length + 1) {
            return false;
        }

        for (int j = 0; j < substringChars.length; j++) {

            if (textChars[j + position] != substringChars[j]) {
                return false;
            }

        }

        return true;
    }

    private static void writeReplacementFromThePosition(char[] resultTextChars, char[] replacementChars, int position) {
        for (int i = 0; i < replacementChars.length; i++) {
            resultTextChars[i + position] = replacementChars[i];
        }
    }
}
