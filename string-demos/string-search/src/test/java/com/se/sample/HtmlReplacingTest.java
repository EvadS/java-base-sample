package com.se.sample;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Safelist;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class HtmlReplacingTest {

    @Test
    public void replaceShouldWorkCorrect() {

        final String html = "<p id=x>Sometimes, <b>simpler</b> is better, "
                + "but <i>not</i> always.</p>";

        String test = HtmlReplacing.stripHtmlRegex(html);
        System.out.println(test);
        String test2 = HtmlReplacing.stripTagsCharArray(html);
        System.out.println(test2);
    }

    @Test
    public void replaceSnippetShouldWorkCorrect() {
        String resSnipet = "<style>;keep-together:always;}\n" +
                ".t1{table-layout:fixed;border-collapse:collapse;border-spacing:0;}\n" +
                "</style>\n" +

                "<title><span id='snippet_1092'></span><snippet class=\"found\" style=\"background:#2196f3\">ДОГОВІР</snippet> N</title>\n" +
                "<meta content=\"Volodyko-N\" name=\"author\">\n" +
                "</head>\n" +
                "<body class=\"b1 b2\">\n" +
                "<p class=\"p1\">\n" +
                "<span class=\"s1\"><span id='snippet_1213'></span><snippet class=\"found\" style=\"background:#2196f3\">ДОГОВІР</snippet> N</span>\n" +
                "<br>\n" +
                "<span class=\"s1\"><span id='snippet_1252'></span><snippet class=\"found\" style=\"background:#2196f3\">про</snippet> <span id='snippet_1256'></span><snippet class=\"found\" style=\"background:#2196f3\">творчу</snippet> <span id='snippet_1263'></span><snippet class=\"found\" style=\"background:#2196f3\">співпрацю</span></snippet>\n" +
                "</p>\n" +
                "<p class=\"p1\"></p>\n" +
                "<table border=\"1\" class=\"bigtable t1\">\n" +
                "<tbody>\n" +
                "<tr class=\"r1\">\n" +
                "<td class=\"td1\">\n" +
                "<p";


        //обрезаем до закрівающего тега
        String s = HtmlReplacing.trimHtmlCode(resSnipet);
        //  System.out.println(resSnipet);
        String test = HtmlReplacing.stripHtmlRegex(s);

        String test2 = HtmlReplacing.stripTagsCharArray(test);
        //  String s1 = HtmlReplacing.trimNotClosedHtmlTagRegex(test2);
        System.out.println(test2);
        Assert.assertNotNull(test2);
    }


    final String resSnipet = ";keep-together:always;}\n" +
            ".t1{table-layout:fixed;border-collapse:collapse;border-spacing:0;}\n" +
            "</style>\n" +
            "<title><span id='snippet_1092'></span><snippet class=\"found\" style=\"background:#2196f3\">ДОГОВІР</snippet> N</title>\n" +
            "<meta content=\"Volodyko-N\" name=\"author\">\n" +
            "</head>\n" +
            "<body class=\"b1 b2\">\n" +
            "<p class=\"p1\">\n" +
            "<span class=\"s1\"><span id='snippet_1213'></span><snippet class=\"found\" style=\"background:#2196f3\">ДОГОВІР</snippet> N</span>\n" +
            "<br>\n" +
            "<span class=\"s1\"><span id='snippet_1252'></span><snippet class=\"found\" style=\"background:#2196f3\">про</snippet> <span id='snippet_1256'></span><snippet class=\"found\" style=\"background:#2196f3\">творчу</snippet> <span id='snippet_1263'></span><snippet class=\"found\" style=\"background:#2196f3\">співпрацю</span></snippet>\n" +
            "</p>\n" +
            "<p class=\"p1\"></p>\n" +
            "<table border=\"1\" class=\"bigtable t1\">\n" +
            "<tbody>\n" +
            "<tr class=\"r1\">\n" +
            "<td class=\"td1\">\n" +
            "<p";;

    @Test
    public void replaceSnippetShouldWorkCorrect2() {



        String test0 = HtmlReplacing.stripHtmlRegex(resSnipet);

        //обрезаем до закрівающего тега
        String s = HtmlReplacing.trimHtmlCode(resSnipet);
        //  System.out.println(resSnipet);
        String test = HtmlReplacing.stripHtmlRegex(s);

        String test2 = HtmlReplacing.stripTagsCharArray(test);
        //  String s1 = HtmlReplacing.trimNotClosedHtmlTagRegex(test2);
        System.out.println(test2);
        Assert.assertNotNull(test2);
    }

    @Test
    public void testJsoup (){
        Document parse = Jsoup.parse(resSnipet);

        String clean = Jsoup.clean(resSnipet, Safelist.relaxed());

        int a =0;
    }

    @Test
    public void testAlg(){

        String s = "Its a great <strong><b>job</strong>";

        Map<Integer, Integer> indexes = new HashMap();

     //   Pattern p = Pattern.compile("<(\\w)*>([^<])*</(\\w)>");

        Pattern p = Pattern.compile("(<.+?/>)([^<]+)?");
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

        int aa= 0;
    }

}