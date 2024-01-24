package com.se.sample.search;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestStringSearch {
    String input = "<html>\\n<head>\\n<META http-equiv=\\\"Content-Type\\\" content=\\\"text/html; charset=UTF-8\\\">\\n<style type=\\\"text/css\\\">.b1{white-space-collapsing:preserve;}\\n.b2{margin: 0.39375in 1.18125in 0.39375in 1.18125in;}\\n.s1{font-weight:bold;}\\n.s2{}\\n.p1{margin-top:0.027777778in;margin-bottom:0.027777778in;text-align:center; font-weight:bold;hyphenate:auto;}\\n.p2{margin-top:0.027777778in;margin-bottom:0.027777778in;text-align:justify;hyphenate:auto;}\\n.p3{margin-top:0.027777778in;margin-bottom:0.027777778in;text-align:end;hyphenate:auto;}\\n.p4{text-indent:0.19722222in;margin-top:0.027777778in;margin-bottom:0.027777778in;text-align:justify;hyphenate:auto;}\\n.p5{margin-top:0.06944445in;margin-bottom:0.06944445in;text-align:center; font-weight:bold;hyphenate:auto;}\\n.td1{width:3.3319445in;padding-start:0.027777778in;padding-end:0.027777778in;border-bottom:thin solid black;}\\n.td2{width:2.63125in;padding-start:0.027777778in;padding-end:0.027777778in;border-bottom:thin solid black;}\\n.r1{height:0.20694445in;keep-together:always;}\\n.t1{table-layout:fixed;border-collapse:collapse;border-spacing:0;}\\n</style>\\n<title>ДОГОВІР N</title>\\n<meta content=\\\"Volodyko-N\\\" name=\\\"author\\\">\\n</head>\\n<body class=\\\"b1 b2\\\">\\n<p class=\\\"p1\\\">\\n<span class=\\\"s1\\\">ДОГОВІР N</span>\\n<br>\\n<span class=\\\"s1\\\">про творчу співпрацю</span>\\n</p>\\n<p class=\\\"p1\\\"></p>\\n<table border=\\\"1\\\" class=\\\"bigtable t1\\\">\\n<tbody>\\n<tr class=\\\"r1\\\">\\n<td class=\\\"td1\\\">\\n<p class=\\\"p2\\\">\\n<span>м. ____________</span>\\n</p>\\n</td><td class=\\\"td2\\\">\\n<p class=\\\"p3\\\">\\n<span>\\\"___\\\" ____________ 20__ р.</span>\\n</p>\\n</td>\\n</tr>\\n</tbody>\\n</table>\\n<p class=\\\"p2\\\"></p>\\n<p class=\\\"p2\\\">\\n<span>_______________________________________________________________, в особі</span>\\n<br>\\n<span>                                            </span><span class=\\\"s2\\\">(назва юридичної особи)</span>\\n</p>\\n<p class=\\\"p2\\\">\\n<span>______________________________________________, що діє на підставі Статуту,</span>\\n<br>\\n<span>                   </span><span class=\\\"s2\\\">(посада, прізвище, ініціали)</span>\\n</p>\\n<p class=\\\"p2\\\">\\n<span>з однієї сторони, і ________________________________________________, в особі</span>\\n<br>\\n<span>                                                             </span><span class=\\\"s2\\\">(назва юридичної особи)</span>\\n</p>\\n<p class=\\\"p2\\\">\\n<span>______________________________________________, що діє на підставі Статуту,</span>\\n<br>\\n<span>                   </span><span class=\\\"s2\\\">(посада, прізвище, ініціали)</span>\\n</p>\\n<p class=\\\"p2\\\">\\n<span>з іншої сторони (разом іменуються \\\"Сторони\\\", а кожна окремо - \\\"Сторона\\\"), уклали цей договір про наступне:</span>\\n</p>\\n<p class=\\\"p4\\\">\\n<span class=\\\"s1\\\">1.</span><span> Сторони виходять з того, що спільне використання їх творчих зусиль зможе прискорити вирішення наступних питань: _________________________________.</span>\\n<br>\\n<span>                                                               </span><span class=\\\"s2\\\">(вказати, які питання сторони збираються вирішувати)</span>\\n</p>\\n<p class=\\\"p4\\\">\\n<span class=\\\"s1\\\">2.</span><span> Для забезпечення вирішення цих питань Сторони домовились:</span>\\n</p>\\n<p class=\\\"p4\\\">\\n<span class=\\\"s1\\\">2.1.</span><span> Обмінюватись матеріалами та інформацією, яка є в їх розпорядженні щодо питань зазначених у п. 1 цього Договору.</span>\\n</p>\\n<p class=\\\"p4\\\">\\n<span class=\\\"s1\\\">2.2.</span><span> Раз на місяць (квартал) проводити із залученням заінтересованих осіб та організацій обговорення проблем та узгодження спільних зусиль для їх вирішення.</span>\\n</p>\\n<p class=\\\"p4\\\">\\n<span class=\\\"s1\\\">2.3.</span><span> Налагоджувати творчі зв'язки з третіми особами та інформувати одна одну про результати цих контактів.</span>\\n</p>\\n<p class=\\\"p4\\\">\\n<span class=\\\"s1\\\">2.4. </span><span>________________________________________________________________.</span>\\n</p>\\n<p class=\\\"p4\\\">\\n<span class=\\\"s1\\\">3.</span><span> Цей договір є передумовою для укладання інших договорів (на проведення науково-дослідних та дослідно-конструкторських робіт), постачання.</span>\\n</p>\\n<p class=\\\"p4\\\">\\n<span class=\\\"s1\\\">4.</span><span> Цей договір не тягне за собою фінансових зобов'язань для Сторін.</span>\\n</p>\\n<p class=\\\"p4\\\">\\n<span class=\\\"s1\\\">5.</span><span> Цей Договір набирає чинності з моменту його підписання і діє до виконання сторонами взятих за ним зобов&rsquo;язань та досягнення поставлених цілей. </span>\\n</p>\\n<p class=\\\"p4\\\">\\n<span class=\\\"s1\\\">6.</span><span> Зміни у цей договір набирають чинності з моменту їх належного оформлення та скріплення підписами обох сторін. </span>\\n</p>\\n<p class=\\\"p2\\\"></p>\\n<p class=\\\"p5\\\">\\n<span class=\\\"s1\\\">Юридичні адреси і підписи сторін</span>\\n</p>\\n<p class=\\\"p5\\\"></p>\\n<p class=\\\"p5\\\"></p>\\n<p class=\\\"p5\\\"></p>\\n<p class=\\\"p5\\\"></p>\\n<p class=\\\"p5\\\"></p>\\n<p class=\\\"p5\\\"></p>\\n</body>\\n</html>\\n";
    String nestedFragment = "<html>\\n<head>\\n<META http-equiv=\\\"Content-Type\\\" content=\\\"text/html; charset=UTF-8\\\">\\n<style type=\\\"text/css\\\">.b1{white-space-collapsing:preserve;}\\n.b2{margin: 0.39375in 1.18125in 0.39375in 1.18125in;}\\n.s1{font-weight:bold;}\\n.s2{}\\n.p1{margin-top:0.027777778in;margin-bottom:0.027777778in;text-align:center; font-weight:bold;hyphenate:auto;}\\n.p2{margin-top:0.027777778in;margin-bottom:0.027777778in;text-align:justify;hyphenate:auto;}\\n.p3{margin-top:0.027777778in;margin-bottom:0.027777778in;text-align:end;hyphenate:auto;}\\n.p4{text-indent:0.19722222in;margin-top:0.027777778in;margin-bottom:0.027777778in;text-align:justify;hyphenate:auto;}\\n.p5{margin-top:0.06944445in;margin-bottom:0.06944445in;text-align:center; font-weight:bold;hyphenate:auto;}\\n.td1{width:3.3319445in;padding-start:0.027777778in;padding-end:0.027777778in;border-bottom:thin solid black;}\\n.td2{width:2.63125in;padding-start:0.027777778in;padding-end:0.027777778in;border-bottom:thin solid black;}\\n.r1{height:0.20694445in;";
    String input2 = "<html>\\n<head>\\n<META http-equiv=\\\"Content-Type\\\" content=\\\"text/html; charset=UTF-8\\\">\\n<style type=\\\"text/css\\\">.b1{white-space-collapsing:preserve;}\\n.b2{margin: 0.39375in 1.18125in 0.39375in 1.18125in;}\\n.s1{font-weight:bold;}\\n.s2{}\\n.p1{margin-top:0.027777778in;margin-bottom:0.027777778in;text-align:center; font-weight:bold;hyphenate:auto;}\\n.p2{margin-top:0.027777778in;margin-bottom:0.027777778in;text-align:justify;hyphenate:auto;}\\n.p3{margin-top:0.027777778in;margin-bottom:0.027777778in;text-align:end;hyphenate:auto;}\\n.p4{text-indent:0.19722222in;margin-top:0.027777778in;margin-bottom:0.027777778in;text-align:justify;hyphenate:auto;}\\n.p5{margin-top:0.06944445in;margin-bottom:0.06944445in;text-align:center; font-weight:bold;hyphenate:auto;}\\n.td1{width:3.3319445in;padding-start:0.027777778in;padding-end:0.027777778in;border-bottom:thin solid black;}\\n.td2{width:2.63125in;padding-start:0.027777778in;padding-end:0.027777778in;border-bottom:thin solid black;}\\n.r1{height:0.20694445in;keep-together:always;}\\n.t1{table-layout:fixed;border-collapse:collapse;border-spacing:0;}\\n</style>\\n<title>ДОГОВІР N</title>\\n<meta content=\\\"Volodyko-N\\\" name=\\\"author\\\">\\n</head>\\n<body class=\\\"b1 b2\\\">\\n<p class=\\\"p1\\\">\\n<span class=\\\"s1\\\">ДОГОВІР N</span>\\n<br>\\n<span class=\\\"s1\\\">про творчу співпрацю</span>\\n</p>\\n<p class=\\\"p1\\\"></p>\\n<table border=\\\"1\\\" class=\\\"bigtable t1\\\">\\n<tbody>\\n<tr class=\\\"r1\\\">\\n<td class=\\\"td1\\\">\\n<p class=\\\"p2\\\">\\n<span>м. ____________</span>\\n</p>\\n</td><td class=\\\"td2\\\">\\n<p class=\\\"p3\\\">\\n<span>\\\"___\\\" ____________ 20__ р.</span>\\n</p>\\n</td>\\n</tr>\\n</tbody>\\n</table>\\n<p class=\\\"p2\\\"></p>\\n<p class=\\\"p2\\\">\\n<span>_______________________________________________________________, в особі</span>\\n<br>\\n<span>                                            </span><span class=\\\"s2\\\">(назва юридичної особи)</span>\\n</p>\\n<p class=\\\"p2\\\">\\n<span>______________________________________________, що діє на підставі Статуту,</span>\\n<br>\\n<span>                   </span><span class=\\\"s2\\\">(посада, прізвище, ініціали)</span>\\n</p>\\n<p class=\\\"p2\\\">\\n<span>з однієї сторони, і ________________________________________________, в особі</span>\\n<br>\\n<span>                                                             </span><span class=\\\"s2\\\">(назва юридичної особи)</span>\\n</p>\\n<p class=\\\"p2\\\">\\n<span>______________________________________________, що діє на підставі Статуту,</span>\\n<br>\\n<span>                   </span><span class=\\\"s2\\\">(посада, прізвище, ініціали)</span>\\n</p>\\n<p class=\\\"p2\\\">\\n<span>з іншої сторони (разом іменуються \\\"Сторони\\\", а кожна окремо - \\\"Сторона\\\"), уклали цей договір про наступне:</span>\\n</p>\\n<p class=\\\"p4\\\">\\n<span class=\\\"s1\\\">1.</span><span> Сторони виходять з того, що спільне використання їх творчих зусиль зможе прискорити вирішення наступних питань: _________________________________.</span>\\n<br>\\n<span>                                                               </span><span class=\\\"s2\\\">(вказати, які питання сторони збираються вирішувати)</span>\\n</p>\\n<p class=\\\"p4\\\">\\n<span class=\\\"s1\\\">2.</span><span> Для забезпечення вирішення цих питань Сторони домовились:</span>\\n</p>\\n<p class=\\\"p4\\\">\\n<span class=\\\"s1\\\">2.1.</span><span> Обмінюватись матеріалами та інформацією, яка є в їх розпорядженні щодо питань зазначених у п. 1 цього Договору.</span>\\n</p>\\n<p class=\\\"p4\\\">\\n<span class=\\\"s1\\\">2.2.</span><span> Раз на місяць (квартал) проводити із залученням заінтересованих осіб та організацій обговорення проблем та узгодження спільних зусиль для їх вирішення.</span>\\n</p>\\n<p class=\\\"p4\\\">\\n<span class=\\\"s1\\\">2.3.</span><span> Налагоджувати творчі зв'язки з третіми особами та інформувати одна одну про результати цих контактів.</span>\\n</p>\\n<p class=\\\"p4\\\">\\n<span class=\\\"s1\\\">2.4. </span><span>________________________________________________________________.</span>\\n</p>\\n<p class=\\\"p4\\\">\\n<span class=\\\"s1\\\">3.</span><span> Цей договір є передумовою для укладання інших договорів (на проведення науково-дослідних та дослідно-конструкторських робіт), постачання.</span>\\n</p>\\n<p class=\\\"p4\\\">\\n<span class=\\\"s1\\\">4.</span><span> Цей договір не тягне за собою фінансових зобов'язань для Сторін.</span>\\n</p>\\n<p class=\\\"p4\\\">\\n<span class=\\\"s1\\\">5.</span><span> Цей Договір набирає чинності з моменту його підписання і діє до виконання сторонами взятих за ним зобов&rsquo;язань та досягнення поставлених цілей. </span>\\n</p>\\n<p class=\\\"p4\\\">\\n<span class=\\\"s1\\\">6.</span><span> Зміни у цей договір набирають чинності з моменту їх належного оформлення та скріплення підписами обох сторін. </span>\\n</p>\\n<p class=\\\"p2\\\"></p>\\n<p class=\\\"p5\\\">\\n<span class=\\\"s1\\\">Юридичні адреси і підписи сторін</span>\\n</p>\\n<p class=\\\"p5\\\"></p>\\n<p class=\\\"p5\\\"></p>\\n<p class=\\\"p5\\\"></p>\\n<p class=\\\"p5\\\"></p>\\n<p class=\\\"p5\\\"></p>\\n<p class=\\\"p5\\\"></p>\\n</body>\\n</html>\\n";


    String resSnipet = ";keep-together:always;}\n" +
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


    @Test
    public void cleanHtml(){
        //("/>"
        int i = resSnipet.indexOf("</");

       // Pattern pattern = Pattern.compile("<(?:\"[^\"]*\"['\"]*|'[^']*'['\"]*|[^'\">])+>");


        int a =0;
    }

    @Test
    public void testSubString() {
        int somepos = 400;
        String snippetTail = input.substring(0,somepos);

        String res = input.substring(somepos, input.length() - somepos);
        String res2 = input2.substring(somepos, input2.length() );





        int a = 0;
    }
}
