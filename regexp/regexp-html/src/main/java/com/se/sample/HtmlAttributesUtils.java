package com.se.sample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://www.codemzy.com/blog/get-html-attributes-regex
 */
public class HtmlAttributesUtils {

    // todo list
    // - negative looking behind /(?<=<.+? )(?<!>)[\w-]+=".+?"/gm
    //bool attr /(?<=<.+? )(?<!>)[\w-]+(?:=".+?"|\b)(?!<)(?=.*?>)/gm

    static String html = "<div>fake=\"true\"<h1 class=\"title-class\"></h1><form><label data-columns=\"3\"><input name=\"name\" id=\"name\" placeholder=\"Your Name\" disabled /></label></form></div>";

    public static void main(String[] args) {
        // allAttributes();
        //lookingBehindSearching();
        booleanAttributes();
    }

    /**
     * Getting all attributes
     */
    private static void allAttributes() {

        String patternStr = "[\\w-]+=\".+?\"";
        runTest(patternStr, html);
    }

    /// The Lookbehind will look like this: (?<=<.+? ).
    private static void lookingBehindSearching() {
        // todo: как узнать 160?
        String patternStr = "(?<=<.{0,160} )(?<!>)[\\w-]+=\".+?\"(?!<)(?=.*?>)";
        runTest(patternStr, html);
    }

    private static void booleanAttributes() {

        String patternStr = "[\\w-]+(?:=\".+?\"|\\b)";
        runTest(patternStr, html);
    }



    private static void  demo5 (){
        //    <([a-z]+)([^<]+)*(?:>(.*)<\/\1>|\s+\/>)
        /*
        • <([a-z]+): Matches the opening tag name (e.g., div, a).
        • ([^<]+)*: Matches any attributes within the tag.
        • (?:>(.*)<\/\1>|\s+\/>): Matches the content between the opening and closing tags or self-closing tags.
        */
    }

    private static void demo6(){
        String html =" <html>\n" +
                "    <body>\n" +
                "      <a href=\"http://example.com\">Example</a>\n" +
                "      <a href=\"http://anotherexample.com\">Another Example</a>\n" +
                "    </body>\n" +
                "  </html>";
    }

    private static int runTest(String patternStr, String inputString) {

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
}
