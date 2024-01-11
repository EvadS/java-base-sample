package com.se.sample.formatter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FormatLocalDateTimeDemo2 {
    public static void main(String[] args) {
        Locale current = Locale.getDefault();
        System.out.println("current locale: "+current);

        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM, dd, yyyy HH:mm:ss", Locale.US);
        System.out.println(dateTime.format(formatter));

        System.out.println("-------------------------------------");
        Locale ruLocale = new Locale("ISO 639","RU");
        DateTimeFormatter formatterRu = DateTimeFormatter.ofPattern("MMMM, dd, yyyy HH:mm:ss", ruLocale);
        System.out.println(dateTime.format(formatterRu));

        System.out.println("-------------------------------------");
        Locale rus = new Locale("ru", "RU");
        DateTimeFormatter formatterRus = DateTimeFormatter.ofPattern("MMMM, dd, yyyy HH:mm:ss", rus);
        System.out.println(dateTime.format(formatterRus));

    }
}