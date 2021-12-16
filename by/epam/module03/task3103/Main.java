package by.epam.module03.task3103;

public class Main {
    //3. Проверить, является ли заданное слово палиндромом.
    public static void main(String[] args) {
        String word = "madam";
        System.out.println(isPalindrome(word) ?
                "The word " + word + " is palindrome."
                : "The word " + word + " doesn't palindrome.");
        String word1 = "lemon";
        System.out.println(isPalindrome(word1) ?
                "The word " + word1 + " is palindrome."
                : "The word " + word1 + " doesn't palindrome.");
        String word2 = "noon";
        System.out.println(isPalindrome(word2) ?
                "The word " + word2 + " is palindrome."
                : "The word " + word2 + " doesn't palindrome.");

    }

    public static boolean isPalindrome(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
