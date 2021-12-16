package by.epam.module03.task3001;

import java.util.Arrays;

public class Main {
    //1. Дан массив названий переменных в camelCase. Преобразовать названия в snake_case.
    public static void main(String[] args) {
        String[] namesInCamelCase;
        String[] namesInSnakeCase;

        namesInCamelCase = new String[]{"sumOfDigits", "arraySize", "n", "indexOfMaximum"};
        System.out.println(Arrays.toString(namesInCamelCase));

        namesInSnakeCase = toSnakeCase(namesInCamelCase);

        System.out.println(Arrays.toString(namesInSnakeCase));
    }

    public static String[] toSnakeCase(String[] namesInCamelCase) {
        String[] namesInSnakeCase;

        namesInSnakeCase = new String[namesInCamelCase.length];

        if (areVarsInCamelCase(namesInCamelCase)) {

            for (int i = 0; i < namesInCamelCase.length; i++) {
                namesInSnakeCase[i] = toSnakeCase(namesInCamelCase[i]);
            }

        } else {
            return null;
        }

        return namesInSnakeCase;
    }

    private static boolean areVarsInCamelCase(String[] vars) {
        String camelCaseRegex;

        camelCaseRegex = "[a-z][a-zA-Z]*";

        for (String var : vars) {
            if (!var.matches(camelCaseRegex)) {
                return false;
            }
        }

        return true;
    }

    private static String toSnakeCase(String nameInCamelCase) {
        char[] nameChars;
        StringBuilder nameToSnakeCase;

        nameChars = nameInCamelCase.toCharArray();
        nameToSnakeCase = new StringBuilder();

        for (int i = 0; i <nameChars.length; i++) {

            if (Character.isLowerCase(nameChars[i])) {
                nameToSnakeCase.append(nameChars[i]);
            } else {
                nameToSnakeCase.append('_');
                nameToSnakeCase.append(Character.toLowerCase(nameChars[i]));
            }

        }

        return nameToSnakeCase.toString();
    }
}
