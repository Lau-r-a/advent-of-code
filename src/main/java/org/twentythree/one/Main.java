package org.twentythree.one;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        List<String> inputs = readFile("2023/1/input");

        int sum = 0;

        for(String input : inputs) {
            String[] array = Pattern.compile("(\\d)").matcher(input).results().map(MatchResult::group)
                    .toArray(String[]::new);;

            String first = "";
            String last = "";

            if (array.length == 1) {
                first = array[0];
                last = first;
            } else if (array.length > 1) {
                first = array[0];
                last = array[array.length - 1];
            }
            sum += Integer.parseInt(first + last);
        }

        System.out.println(sum);
    }

    public static
    List<String> readFile(String path) throws IOException {
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

