package by.epam.module03.task3102;

public class Main {
    //2. В строке вставить после каждого символа 'a' символ 'b'
    public static void main(String[] args) {
        String s = "jhalalfaaa";
        System.out.println(s);

        s = s.replaceAll("a", "ab");
        System.out.println(s);
    }
}
