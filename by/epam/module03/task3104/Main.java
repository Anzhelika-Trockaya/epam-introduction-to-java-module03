package by.epam.module03.task3104;

public class Main {
    //4. С помощью функции копирования и операции конкатенации составить из частей слова “информатика” слово “торт”.
    public static void main(String[] args) {
        String s = "информатика";
        String t = s.substring(7, 8);
        String or = s.substring(3, 5);
        String result = t + or + t;
        System.out.println(result);
    }
}
