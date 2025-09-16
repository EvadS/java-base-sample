package com.se.sample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexpHelper {

    public static int runTest(final String patternStr,final String inputString,final String comment) {
        if (comment != null && comment.length() > 0) {
            System.out.println(comment);
        }
        System.out.println("input string: " + inputString);
        System.out.println("patten: " + patternStr);

        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(inputString);

        int i = 1;
        while (matcher.find()) {
            String group = matcher.group(0);
            System.out.println("found(" + (i) + "): " + group);
            i++;
        }
        if (i < 2) {
            System.out.println("ничего не найдено");
        }
        System.out.println("----------------------------------------");
        return i;
    }

    private static int runTest(final String patternStr, final String inputString) {
        return runTest(patternStr, inputString, "");
    }
}
