package com.se.sample;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchRegexpTest {

    // текст перед закрывающим
    final String resSnipet = ";keep-together:always;}\n" +
            ".t1{table-layout:fixed;border-collapse:collapse;border-spacing:0;}\n" +
            "</style>\n" +
            "<title><span id='snippet_1092'></span><snippet class=\"found\" style=\"background:#2196f3\">ДОГОВІР</snippet> N</title>\n" +
            "<meta content=\"Volodyko-N\" name=\"author\">\n" ;

    // открывающий обрезан
    final String resSnipet2 = "tyle>;keep-together:always;}\n" +
            ".t1{table-layout:fixed;border-collapse:collapse;border-spacing:0;}\n" +
            "</style>\n" +
            "<title><span id='snippet_1092'></span><snippet class=\"found\" style=\"background:#2196f3\">ДОГОВІР</snippet> N</title>\n" +
            "<meta content=\"Volodyko-N\" name=\"author\">\n";

    // закрывающий обрезан
    final String resSnipet3 = "le>\n" +
            "<title><span id='snippet_1092'></span><snippet class=\"found\" style=\"background:#2196f3\">ДОГОВІР</snippet> N</title>\n" +
            "<meta content=\"Volodyko-N\" name=\"author\">\n" +
            "</head>\n";

    @Test
    public void demoTest1(){

        String regex = "(?<=\\>)([^\"<]*)(?=\\<)";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(resSnipet3);

        while (m.find()){
            String group = m.group(0);
            int start = m.start();
            int end = m.end();

            int a =0;
        }

    }

    //произвольный символ
    // (.)(<\/)

    // [^>]*(<\/)
}
