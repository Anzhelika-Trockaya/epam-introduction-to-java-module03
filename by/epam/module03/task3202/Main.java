package by.epam.module03.task3202;

//2. Напишите анализатор, позволяющий последовательно возвращать содержимое узлов xml-документа и его тип (открывающий
//тег, закрывающий тег, содержимое тега, тег без тела). Пользоваться готовыми парсерами XML для решения данной задачи
//нельзя.

public class Main {
    public static void main(String[] args) {
        String text;
        Analyzer analyzer;
        String currentNode;

        text = """
                <notes>
                    <note id = "1">
                        <to>Вася</to>
                        <from>Света</from>
                        <heading>Напоминание</heading>
                        <body>Позвони мне завтра!</body>
                    </note>
                    <note id = "2">
                        <to>Петя</to>
                        <from>Маша</from>
                        <heading>Важное напоминание</heading>
                        <body/>
                    </note>
                </notes>
                """;
        analyzer = new Analyzer(text);

        while ((currentNode = analyzer.nextNode()) != null) {
            System.out.println(currentNode);
        }
    }
}
