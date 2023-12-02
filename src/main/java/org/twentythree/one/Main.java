package org.twentythree.one;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        List<String> input = readFile("2023/1/input");
        System.out.println("Solution for part one is:" + calculate(input, "(\\d)"));
        System.out.println("Solution for part two is:" + calculate(input, "(one|two|three|four|five|six|seven|eight|nine|\\d)"));
    }

    private static int calculate(List<String> list, String match) {
        int sum = 0;

        for(String item: list) {

            String[] array = match(item, match);

            String first = parseToDecimal(array[0]);
            String last = array.length > 1 ? parseToDecimal(array[array.length - 1]) : first;

            sum += Integer.parseInt(first + last);
        }
        return sum;
    }

    private static String[] match (String input, String regex) {
        return Pattern
                .compile(regex)
                .matcher(input)
                .results()
                .map(MatchResult::group)
                .toArray(String[]::new);
    }

    private static String parseToDecimal(String number) {
        String result = number;
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            result = String.valueOf(Numbers.valueOf(number).getValue());
        }
        return result;
    }

    private static List<String> readFile(String path) throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(path);
        Reader reader = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(reader);
        String line;
        List<String> lines = new LinkedList<>();

        while((line = br.readLine()) != null)
        {
            lines.add(line);
        }
        br.close();
        return lines;
    }
}

