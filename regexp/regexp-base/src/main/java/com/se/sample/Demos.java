package com.se.sample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.se.sample.AppGreedyLazy.runTest;

public class Demos {

    final static String resSnipet2 = ";keep-together:always;}\n" +
            ".t1{table-layout:fixed;border-collapse:collapse;border-spacing:0;}\n" +
            "</style>\n" +
            "<title><span id='snippet_1092'></span><snippet class=\"found\" style=\"background:#2196f3\">ДОГОВІР</snippet> N</title>\n" +
            "<meta content=\"Volodyko-N\" name=\"author\">\n" ;
    public static void main(String[] args) {


        checkExpression("(text 99");
        checkExpression("text 99");
        checkExpression("(text 99)");

        System.out.println("bye");


        String pattern = ";[a-z]+[^><]+((?=<)|(?!.*>))";
        String text = resSnipet2;

    //    int aa = AppGreedyLazy.runTest(pattern,  text, "");
        String s = text.replaceAll(pattern, "1111");
        int a =0;


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
