package by.epam.module03.task3202;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//2. Напишите анализатор, позволяющий последовательно возвращать содержимое узлов xml-документа и его тип (открывающий
//тег, закрывающий тег, содержимое тега, тег без тела). Пользоваться готовыми парсерами XML для решения данной задачи
//нельзя.

public class Analyzer {
    private final static Pattern START_TAG_PATTERN = Pattern.compile("<([a-zA-Z]+)(?:(?:\\s[a-zA-Z]+\\s?=\\s?\"[^<>]\")|/)*>\n?");

    private final String text;
    private final Matcher startTagMatcher;
    private int currentTextPosition = 0;
    private StringBuilder node;

    public Analyzer(String text) {
        this.text = text;
        this.startTagMatcher = START_TAG_PATTERN.matcher(text);
    }

    public String nextNode() {
        String startTag;

        node = new StringBuilder();

        startTag = findNextStartTag();

        if (startTag != null) {
            currentTextPosition = startTagMatcher.end();

            if (startTag.contains("/>")) {
                addElementToNode(" Tag without body: ", startTagMatcher.group());
            } else {
                addElementToNode(" Start tag: ", startTagMatcher.group().replaceAll("\n", ""));
                addBodyAndEndTagToNode();
            }

            return node.toString();
        }

        return null;
    }

    private String findNextStartTag() {

        if (startTagMatcher.find(currentTextPosition)) {
            return startTagMatcher.group();
        }

        return null;
    }

    private void addElementToNode(String type, String value) {
        node.append(type);
        node.append(value);
        node.append("\n");
    }

    private void addBodyAndEndTagToNode() {
        Pattern currentEndTagPattern;
        Matcher currentEndTagMatcher;
        Pattern currentStartTagPattern;
        Matcher currentStartTagMatcher;
        int currentIndexOfStartTag;
        int currentIndexOfEndTag;
        String tagName;

        tagName = startTagMatcher.group(1);

        currentStartTagPattern = Pattern.compile("<" + tagName + ">");
        currentStartTagMatcher = currentStartTagPattern.matcher(text);
        currentEndTagPattern = Pattern.compile("\\s*</" + tagName + "(?:(?:\\s[a-zA-Z]+\\s?=\\s?\"[^<>]\")|/)*>");
        currentEndTagMatcher = currentEndTagPattern.matcher(text);

        if (currentEndTagMatcher.find(currentTextPosition)) {
            currentIndexOfEndTag = currentEndTagMatcher.start();
        } else {
            throw new IllegalArgumentException("Incorrect text!");
        }

        currentIndexOfStartTag = currentIndexOfEndTag;
        if (currentStartTagMatcher.find(currentTextPosition)) {
            currentIndexOfStartTag = currentStartTagMatcher.start();
        }

        while (currentIndexOfStartTag < currentIndexOfEndTag) {
            if (currentEndTagMatcher.find()) {
                currentIndexOfEndTag = currentEndTagMatcher.start();
            }

            currentIndexOfStartTag = currentIndexOfEndTag;
            if (currentStartTagMatcher.find()) {
                currentIndexOfStartTag = currentStartTagMatcher.start();
            }
        }

        addElementToNode(" Tag body: ", text.substring(currentTextPosition, currentEndTagMatcher.start()).replaceAll("\\s*$", ""));
        addElementToNode(" End tag: ", currentEndTagMatcher.group().replaceAll(" ", "").replaceAll("\n", ""));
    }


}
