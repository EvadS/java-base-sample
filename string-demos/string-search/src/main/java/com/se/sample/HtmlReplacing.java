package com.se.sample;

public class HtmlReplacing {

    static String resSnipet = "<style>;keep-together:always;}\n" +
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

    /**
     * убрать html теги из текста
     * @param source строка для преобразования
     * @return текст без html аттрибутов
     */
    public static String stripHtmlRegex(String source) {
        // Replace all tag characters with an empty string.
        return source.replaceAll("<.*?>", "");
    }

    /**
     * убрать html тег который не закрыт
     * @param source проверяемый на незакрытый тег
     * @return строка без html
     */
    public static String trimNotClosedHtmlTagRegex(String source) {
        // Replace all tag characters with an empty string.
        return source.replaceAll("<.*?", "");
    }


    /**
     * вернуть текст между < и >
     * @param source входная строка
     * @return
     */
    public static String stripTagsCharArray(String source) {
        // Create char array to store our result.
        char[] array = new char[source.length()];
        int arrayIndex = 0;
        boolean inside = false;

        // Loop over characters and append when not inside a tag.
        for (int i = 0; i < source.length(); i++) {
            char let = source.charAt(i);
            if (let == '<') {
                inside = true;
                continue;
            }
            if (let == '>') {
                inside = false;
                continue;
            }
            if (!inside) {
                array[arrayIndex] = let;
                arrayIndex++;
            }
        }
        // ... Return written data.
        return new String(array, 0, arrayIndex);
    }

    /**
     * убрать текст перед закрывающим html тегом
     * @param htmlString
     * @return
     */
    public static  String trimHtmlCode(String htmlString){
        int i = htmlString.indexOf("</");
        return htmlString.substring(i);
    }



    public static void main(String[] args) {
        String s = trimHtmlCode(resSnipet);

        final String html = "<p id=x>Sometimes, <b>simpler</b> is better, "
                + "but <i>not</i> always.</p>";

        System.out.println(html);
        String test = stripHtmlRegex(html);
        System.out.println(test);
        String test2 = stripTagsCharArray(html);
        System.out.println(test2);

        System.out.println("----------------------------------");
        //  System.out.println(resSnipet);
        test = stripHtmlRegex(s);
        System.out.println(test);
        test2 = stripTagsCharArray(s);
        System.out.println(test2);

        String s1 = trimNotClosedHtmlTagRegex(test2);
        System.out.println(s1);
    }
}
