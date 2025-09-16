package com.se.sample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Опережающие и ретроспективные проверки
 */
public class LookAheadAndBehind {

    public static void main(String[] args) {
        System.out.println("Опережающая проверка");
        demo1();
        System.out.println("--------------------------------------");
        System.out.println("Более сложная Опережающая проверка ");
        demo1_1();
        System.out.println("--------------------------------------");
        System.out.println("Негативная опережающая проверка");
        demo2 ();

        System.out.println("--------------------------------------");
        demo3();

        System.out.println("-------------------------------------");
        System.out.println("Скобочные группы");
        demo5();


        // allAttributes();

        //lookingBehindSearching();

        booleanAttributes();
    }

    // Опережающая проверка
    private static void demo1 (){
        String text = "1 индейка стоит 30€";
        Pattern pattern = Pattern.compile("\\d+(?=€)");
        Matcher matcher = pattern.matcher(text);
        System.out.println();
      //  boolean b = matcher.find();

        while (matcher.find()) {
            System.out.println(matcher.group());
            int s = matcher.start();
            System.out.println("start position:" + s);
            int e = matcher.end();
            System.out.println("end position:" + e);
        }
    }

    // Опережающая проверка c несколькими условиями

    /**
     * узнать из строки количество индеек, то есть число \d+, за которым НЕ следует знак €.
     */
    private static void demo1_1 (){
        /**
         *  X(?=Y)(?=Z) означает:
         *
         *     Найти X.
         *     Проверить, идёт ли Y сразу после X (если нет – не подходит).
         *     Проверить, идёт ли Z сразу после X (если нет – не подходит).
         *     Если обе проверки прошли – совпадение найдено.
         */


        String text = "1 индейка стоит 30€";
        //шаблон означает, что мы ищем X при условии, что за ним идёт и Y и Z.
        Pattern pattern = Pattern.compile("\\d+(?=\\s)(?=.*30)");
        Matcher matcher = pattern.matcher(text);
        //  boolean b = matcher.find();

        while (matcher.find()) {
            System.out.println(matcher.group());
            int s = matcher.start();
            System.out.println("start position:" + s);
            int e = matcher.end();
            System.out.println("end position:" + e);
        }
    }

    // Негативная опережающая проверка
    private static void demo2 (){
        //количество индеек, то есть число \d+, за которым НЕ следует знак €.
        String text = "1 индейка стоит $30";
        // найди такой X, за которым НЕ следует .
        Pattern pattern = Pattern.compile("(?<=\\$)\\d+");
        Matcher matcher = pattern.matcher(text);
        //  boolean b = matcher.find();

        while (matcher.find()) {
            System.out.println(matcher.group());
            int s = matcher.start();
            System.out.println("start position:" + s);
            int e = matcher.end();
            System.out.println("end position:" + e);
        }
    }

    // Ретроспективная проверка
    private static void demo3 (){
        System.out.println("найти количество индеек – число, перед которым не идёт $");
        String text = "2 индейки стоят $60";

        Pattern pattern = Pattern.compile("(?<!\\$)\\d+");
        Matcher matcher = pattern.matcher(text);
        //  boolean b = matcher.find();

        while (matcher.find()) {
            System.out.println(matcher.group());
            int s = matcher.start();
            System.out.println("start position:" + s);
            int e = matcher.end();
            System.out.println("end position:" + e);
        }
    }

    // Скобочные группы
    private static void demo5 (){
        String text = "1 индейка стоит 30€";
        Pattern pattern = Pattern.compile("\\d+(?=(€|kr))");
        Matcher matcher = pattern.matcher(text);
        System.out.println();
        //  boolean b = matcher.find();

        while (matcher.find()) {
            System.out.println(matcher.group());
            int s = matcher.start();
            System.out.println("start position:" + s);
            int e = matcher.end();
            System.out.println("end position:" + e);
        }
    }



    // todo list
    // - negative looking behind /(?<=<.+? )(?<!>)[\w-]+=".+?"/gm
    //bool attr /(?<=<.+? )(?<!>)[\w-]+(?:=".+?"|\b)(?!<)(?=.*?>)/gm
    static String html = "<div>fake=\"true\"<h1 class=\"title-class\"></h1><form><label data-columns=\"3\"><input name=\"name\" id=\"name\" placeholder=\"Your Name\" disabled /></label></form></div>";



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
