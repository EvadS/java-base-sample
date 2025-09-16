package com.se.sample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
// https://www.dhiwise.com/post/mastering-html-regex-a-deep-dive-into-parsing-html

public class HtmlRegexpUtils {
    private static String text = "<p>This is a paragraph.</p>\n" +
            "<a href=\"http://example.com\">This is a link</a>";

    public static void main(String[] args) {
        demo1();
    }


    public static void  demo1() {
        Pattern pattern = Pattern.compile(" <([a-z]+)([^<]+)*(?:>(.*)<\\/\\1>|\\s+\\/>)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
             System.out.println(matcher.group());

//            System.out.println("Found value: " + m.group(0) );
//            System.out.println("Found value: " + m.group(1) );
//            System.out.println("Found value: " + m.group(2) );

            int a=0;
        }
    }
}
