package com.se.sample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * начинаем разбираться
 */
public class App2 {
    public static void main(String[] args) {
        // demo1();
        demo2();

        сapturingGroups();
        boundaryPosition();
    }

    private static void demo2() {
        String input = "a";
        // любой символ от 0 до 7 раз все слово
        Pattern pattern = Pattern.compile(".{0,7}");
        Matcher matcher = pattern.matcher("foofoo");

        while (matcher.find()) {
            String group = matcher.group(0);
            int a = 0;
        }
        System.out.println("----------------------------------------");
        System.out.println("Предикаты");
        //  символ f или o
        runTest("[fo]", "fooafooa", "");
        // все что цифра
        runTest("\\d", "123ABC", "");

        // все что не цифра
        runTest("\\D", "a6c", "");

        // все что не цифра
        runTest("[a-zA-Z0-9_]", "a6cD_Ef", "любая цифра, буква, а также знак нижнего подчёркивания;");
        runTest("\\w", "a6cD_Ef", "любая цифра, буква, а также знак нижнего подчёркивания;");

        runTest("\\S", "a c", "не-пробельные символы");
        runTest("\\W", "hi!", "не слова");

        runTest("[\\^abc]", "abcde", "negation, matches everything except a, b, or c");
        runTest("[abc]", "abcde", "simple, matches a or b, or c");
        runTest("[^abcdef]", "abcde", "start from abc");
        runTest("[eabc]", "abcde", "start from abc");
        runTest("[eabc]", "abcd", "end of string ");
        runTest("[fifaeabc]", "$abc", "end of string ");

        runTest("\\bWORD WORD\\b", "WORD 21231321 WORD", "начало и конец ");
        runTest("\\bWORD WORD\\b", "21231321 WORD", "начало и конец ");
        runTest("\\bWORD WORD\\b", "21231321", "начало и конец ");

        System.out.println("квалификаторы");
        System.out.println("a  найдено 0 раз из двух символов");
        runTest("\\a?", "hi", " text zero or one time");

        runTest("h?", "h i", " text zero or one time");
        System.out.println("h  найдено 0 раз из 3-х символов, при этом 'h' есть");

        runTest("\\a{0,}", "hi", "ноль и более");
        runTest("\\a+", "hi", "1 и более");
        runTest("\\a{1,}", "hi", "1 и более");

        runTest("a{3}", "aa", "2 совпадения  - 3 по два из 6-ти");
        runTest("a{2,3}", "aa", "3 по два из 6-ти, вторая треть ");


        runTest("zo*", "zoo", "0 и более раз ");

    }

    private static void сapturingGroups() {

        runTest("(\\d\\d)", "12", "число из 2х цифр");
        runTest("(\\d\\d)", "1212", "число из 2х цифр");

        runTest("(\\d\\d)\\1", "1212", "распространить выражение на всю длину(back referencing ) ");
        runTest("(\\d\\d)(\\d\\d)", "1212", "без back referencing ");
   }

    private static void boundaryPosition() {
        runTest("^dog", "dogs are friendly","dog can be found at the beginning");
        runTest("dog$", "is a dog man's best friend?");
        System.out.println("\"dog$\" the same dog\\b");
        runTest("\\bdog\\b", "dog snoop dogg is a rapper dog");
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

    private static void demo1() {
        Pattern pattern = Pattern.compile("w3schools", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("Visit W3Schools!");
        boolean matchFound = matcher.find();
        if (matchFound) {
            System.out.println("Match found");
        } else {
            System.out.println("Match not found");
        }
    }
}
