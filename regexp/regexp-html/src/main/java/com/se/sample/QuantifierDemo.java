package com.se.sample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuantifierDemo {

    public static void main(String[] args) {

        greedyQuantifierMode();
        superGreedyQuantifierMode();
        lazyQuantifierMode();
        positionDemo();
    }

// умолчанию квантификатор работает в жадном режиме
    public static void  greedyQuantifierMode() {
        String text = "Егор Алла Александр";
        Pattern pattern = Pattern.compile("А.+а");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            //Алла Алекса
            System.out.println(text.substring(matcher.start(), matcher.end()));
        }
    }

    /// Сверхжадный режим квантификатора
    public static void  superGreedyQuantifierMode() {
        //А.++а
        String text = "Егор Алла Александр";
        Pattern pattern = Pattern.compile("А.++а");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            //Алла Алекса
            System.out.println(text.substring(matcher.start(), matcher.end()));
        }
    }

    ///  Ленивый режим квантификатора
    public static void  lazyQuantifierMode() {
        String text = "Егор Алла Александр";
        Pattern pattern = Pattern.compile("А.+?а");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            //Алла Алекса
            System.out.println(text.substring(matcher.start(), matcher.end()));
        }
    }

    public static void positionDemo(){
        String text = "Егор Алла Анна";
        Pattern pattern = Pattern.compile("А.+?а");

        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            int start=matcher.start();
            int end=matcher.end();
            System.out.println("Найдено совпадение " + text.substring(start,end) + " с "+ start + " по " + (end-1) + " позицию");
        }
        System.out.println(matcher.replaceFirst("Ира"));
        System.out.println(matcher.replaceAll("Ольга"));
        System.out.println(text);
    }
}