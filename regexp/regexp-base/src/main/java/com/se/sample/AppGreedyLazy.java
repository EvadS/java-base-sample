package com.se.sample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * разбираемся с жадными и ленивыми кватификаторами
 */
public class AppGreedyLazy {

    public static void main(String[] args) {


    }

    private static int runTest(String patternStr, String inputString, String comment) {
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


    private static int runTest(String patternStr, String inputString) {
        return runTest(patternStr, inputString, "");
    }
}
