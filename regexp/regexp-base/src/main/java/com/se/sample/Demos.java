package com.se.sample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demos {

    public static void main(String[] args) {


        checkExpression("(text 99");
        checkExpression("text 99");
        checkExpression("(text 99)");

        System.out.println("bye");
    }

    private static boolean checkExpression(String input) {
        Pattern pattern = Pattern.compile("\\([\\d+/*-]*\\)");
        Matcher matcher = pattern.matcher(input);


        while (matcher.find()){
            String group = matcher.group(0);
            System.out.println(group);
        }

        return input.matches("[\\d+/*-]*");
    }
}
