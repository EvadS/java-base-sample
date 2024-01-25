package com.se.sample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * разбираемся с жадными и ленивыми кватификаторами
 */
public class AppGreedyLazy {

    public static void main(String[] args) {
       demoHtml1();
       // demoApp1();
       // demoApp2();
       // demoApp3();
       // demoGreedyLazy();
        backReferenceDemo();
    }

    private static void backReferenceDemo() {
        /*
        [ ]+ → один или несколько пробелов, так мы ограничиваем слово. В принципе, тут можно заменить на метасимвол \b.
        (\w+) → любой буквенный или цифровой символ, или знак подчеркивания. Квантификатор «+» означает, что символ должен идти минимум один раз. А то, что мы взяли все это выражение в круглые скобки, говорит о том, что это группа. Зачем она нужна, мы пока не знаем, ведь рядом с ней нет квантификатора. Значит, не для повторения. Но в любом случае, найденный символ или слово — это группа 1.
        [ ]+ → снова один или несколько пробелов.
        \1 → повторение группы 1. Это и есть ссылка
         */
        runTest("[ ]+(\\w+)[ ]+", "Поздравляем! Вы прошли на на новый уровень. Так что что улыбаемся и и машем.");

    }

    private static void demoGreedyLazy() {
        System.out.println("квалификаторы");

        // находит самую длинную последовательность символов, завершающуюся на ox
        System.out.println("поглощает всю строку ");
        System.out.println("после чего откатывается вплоть до обнаружения того, что входной текст заканчивается этими символам");
        runTest(".*ox", " fox box pox", "наглядный пример жадного");

        //находит самую короткую последовательность символов, завершающуюся на ox
        runTest(".*?ox", " fox box pox", "наглядный пример ленивого");

        /*
         *  он поглощает весь входной текст и не остается ничего, что могло бы соответствовать ox
         *  в конце регулярного выражения
         */
        runTest(".*+ox", " fox box pox", "сверх-жадный квантификатор");

    }



    private static void demoApp2() {
    }

    private static void demoHtml1() {
        String inputXmlString = "<req> <query>Ан</query> <gender>FEMALE</gender></req>";
        String result = inputXmlString.replaceAll("<.*>","");
        System.out.println(result);
        System.out.println("==============================================");

        int i = runTest("<.*?>", "<req> <query>Ан</query> <gender>FEMALE</gender></req>");
         i = runTest("<.*>", "<req> <query>Ан</query> <gender>FEMALE</gender></req>");

        System.out.println(result);
        System.out.println("==============================================");

        inputXmlString = "<req> <query>Ан</query> <gender>FEMALE</gender></req>";
        result = inputXmlString.replaceAll("<[^>]*>","");
        System.out.println(result);
        System.out.println("==============================================");

        inputXmlString = "<query>Ан</query> <gender>FEMALE</gender></req>";
        result = inputXmlString.replaceAll("<[^>]*>|<[^>\\/]\\/>","");
        System.out.println(result);

        inputXmlString = "<req> <query>Ан</query> <gender>FEMALE</gender></req>";
        result = inputXmlString.replaceAll("/<(\\/?)[a-zA-Z]+(?:[^>\"']+|\"[^\"]*\"|'[^']*')*>/g","");
        System.out.println(result);
        System.out.println("==============================================");

    }

    private static void demoApp1() {

        // регулярное выражение возвращает целую строку, внутри которой есть несколько тегов.
        runTest("<.*>", "<req> <query>Ан</query> <gender>FEMALE</gender></req>", "первый вариант");
        System.out.println("ленивый вместо жадного");
        runTest("<.*>", "<req> <query>Ан</query> <gender>FEMALE</gender></req>", "первый вариант");

        //начинается на < внутри нет >
        runTest("<[^>]+?>", "<req> <query>Ан</query> <gender>FEMALE</gender></req>", "первый вариант");

        runTest("<[^>]*>", "<req> <query>Ан</query> <gender>FEMALE</gender></req>", "первый вариант");

    }

    public static int runTest(String patternStr, String inputString, String comment) {
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


    public static int runTest(String patternStr, String inputString) {
        return runTest(patternStr, inputString, "");
    }

    private static void demoApp3() {

        runTest("^The\\w{0,1}", "Therefore" );
        runTest("^The\\w{0,1}", "The one " );
        runTest("^[The]\\w{0,1}", "The fore" );
        int a =0;
    }
}
