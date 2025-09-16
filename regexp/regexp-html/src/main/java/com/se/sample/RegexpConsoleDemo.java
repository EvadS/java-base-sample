package com.se.sample;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class RegexpConsoleDemo
{
    public static void main(String[] args)
    {

        System.out.println("RegexDemo");
        System.out.println("demo values to check :");
        System.out.println("regex = море");
        System.out.println("input =  Море, море, море, океан");

        // for program parameters
//        if (args.length != 2)
//        {
//            System.err.println("usage: java RegexDemo regex input");
//            return;
//        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter pattern:");
        String pattern = sc.next();

        System.out.println("Enter text:");
        // The quick brown fox jumps over the lazy ox.
        Scanner scLine = new Scanner(System.in);
        String text = scLine.nextLine();

        // Преобразуем символьные последовательности начала новой строки (\n) в символы начала строки.
        text = text.replaceAll("\\\\n", "\n");
        try
        {
            System.out.println("regex = " + pattern);
            System.out.println("input = " + text);
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(text);
            while (m.find())
                System.out.println("Found [" + m.group() + "] starting at "
                        + m.start() + " and ending at " + (m.end() - 1));
        }
        catch (PatternSyntaxException pse)
        {
            System.err.println("Неправильное регулярное выражение: " + pse.getMessage());
            System.err.println("Описание: " + pse.getDescription());
            System.err.println("Позиция: " + pse.getIndex());
            System.err.println("Неправильный шаблон: " + pse.getPattern());
        }
    }
}