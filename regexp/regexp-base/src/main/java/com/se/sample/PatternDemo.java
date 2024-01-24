package com.se.sample;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternDemo {
    public static void main(String[] args) {

        String input = "+12343454556";

        boolean isPhoneNumber = isPhoneNumber(input);

        if(isPhoneNumber){
            System.out.println("It is a phone number");
        }
        else{
            System.out.println("It is not a phone number!");
        }

        System.out.println("-----------------------------");
       // demoSearchJava();
        demoRegexp();
    }

    private static void demoSearchJava() {
        String input = "Hello Java! Hello JavaScript! JavaSE 8.";
        //что после "Java" в совпадении может находиться любое количество алфавитно-цифровых символов
        Pattern pattern = Pattern.compile("Java(\\w*)");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            System.out.println(matcher.group());
            int s = matcher.start();
            System.out.println("start position:" + s);
            int e = matcher.end();
            System.out.println("end position:" + e);
        }
        int a = 10;
    }

    public static void demoRegexp() {
        String s = "Its a great <strong><b>job</strong>";
        s = "Its a great <strong>job</strong>";
        Map<Integer, Integer> indexes = new HashMap();

        // String regex = "<(\w)*>([^<])*</(\w)>";
        //String regex = "<(\\w)*>"; // работает
        String regex = "<(\\w)*>(\\w*)</(\\w*)>";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(s);

        int opening = -1;
        int closing = -1;

        while (m.find()) {
            if (!m.group(0).equals(m.group(2))) {
                opening = m.start(1);
                closing = m.group(1).indexOf('>');
            }

            if (opening != -1 && closing != -1) {
                indexes.put(opening, closing);
            }
        }
    }

    public static  boolean isPhoneNumber(String  str){
        return  str.matches("(\\+*)\\d{11}");
    }
}
