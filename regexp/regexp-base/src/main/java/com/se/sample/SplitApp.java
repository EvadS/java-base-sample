package com.se.sample;

public class SplitApp {

    public static void main(String[] args) {

        String text = "FIFA will never regret it. but,I   not!sure";
        //пробел как разделитель, * - значит 0 и более
        String[] words = text.split("\\s*");
        System.out.println("пробел как разделитель 0 и более раз");
        for(String word : words){
            System.out.println(word);
        }
        System.out.println("------------------------------------");

        words = text.split("\\s+");
        System.out.println("пробел как разделитель 1 и более раз");
        for(String word : words){
            System.out.println(word);
        }
        System.out.println("------------------------------------");

        text = "FIFA will never regret it   . but   !,I   not!sure";
        words = text.split("\\s*(\\s|,|!|\\.)");
        System.out.println("пробел как разделитель");
        System.out.println("указывает группа выражений, которая может идти после неопределенного количества пробелов");
        for(String word : words){
            System.out.println(word);
        }

        System.out.println("------------------------------------");
        System.out.println("bye");
    }
}
