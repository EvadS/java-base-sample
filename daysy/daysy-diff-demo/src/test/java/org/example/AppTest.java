package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.outerj.daisy.diff.DaisyDiff;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Locale;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }


    @Test// comes from TestNG and is not related to DaisyDiff
    public void daisyDiffTest() throws Exception {
        String html1 = "<html><body>var v2</body></html>";
        String html2 = "<html><body>Hello world</body></html>";

        try {
            StringWriter finalResult = new StringWriter();
            SAXTransformerFactory tf = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
            TransformerHandler result = tf.newTransformerHandler();
            result.getTransformer().setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            result.getTransformer().setOutputProperty(OutputKeys.INDENT, "yes");
            result.getTransformer().setOutputProperty(OutputKeys.METHOD, "html");
            result.getTransformer().setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            result.setResult(new StreamResult(finalResult));

            ContentHandler postProcess = result;
            DaisyDiff.diffHTML(new InputSource(new StringReader(html1)), new InputSource(new StringReader(html2)), postProcess, "diff", Locale.ENGLISH);
            System.out.println(finalResult.toString());
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    @Test
    public void daisyDiffTest2() throws Exception {
        String html1 = "<html><body><div class=\"mainTag\"><p class=\"tj bmf\" >" +
                "   <a class=\"tip lz_prev\" target=\"_blank\"  href=\"/document/view/T222215?ed=2022_04_21\">7) встановлення розміру пільг з оплати жилих приміщень та комунальних послуг;</a>" +
                "   </p></div><div class=\"mainTag\"><p class=\"tj bmf\" >\n" +
                "" +
                "   <a class=\"tip lz_prev\" target=\"_blank\"  href=\"/document/view/T222215?ed=2022_04_21\">8) встановлення порядку організації та діяльності житлово-будівельних кооперативів, прав і обов'язків їх членів;</a>" +
                "   </p></div></body></html>";

        String html2 = "<html><body><div class=\"mainTag\"><p>" +
                "       7) встановлення порядку організації та діяльності" +
                "   <a   href=\"/document/view/KP850186\">житлово-будівельних кооперативів</a>" +
                "   , прав і обов'язків їх членів" +
                "   </p></div><div class=\"mainTag\"><p>" +
                "   8) встановлення правил і норм технічної експлуатації жилих" +
                "   <a  href=\"/document/view/T030435\">" +
                "   будинків</a>" +
                "   і правил користування придомовими територіями;" +
                "   </p></div></body></html>";

        try {
            StringWriter finalResult = new StringWriter();
            SAXTransformerFactory tf = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
            TransformerHandler result = tf.newTransformerHandler();
            result.getTransformer().setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            result.getTransformer().setOutputProperty(OutputKeys.INDENT, "yes");
            result.getTransformer().setOutputProperty(OutputKeys.METHOD, "html");
            result.getTransformer().setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            result.setResult(new StreamResult(finalResult));

            Locale uaLocale = new Locale("ua","");
            ContentHandler postProcess = result;
            DaisyDiff.diffHTML(new InputSource(new StringReader(html1)), new InputSource(new StringReader(html2)), postProcess, "diff", uaLocale);
            System.out.println(finalResult.toString());
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        int a =0;
    }


    @Test
    public void daisyDiffTest3() throws Exception {
        String html1 = "<html><body>" +
                "<div>" +
                "<p>7) встановлення розміру пільг з оплати жилих приміщень та комунальних послуг;</p>" +
                "<p>8) встановлення порядку організації та діяльності житлово-будівельних кооперативів, прав і обов'язків їх членів;</p>" +
                "</div>" +
                "</body></html>";

        String html2 = "<html><body>" +
                "<div>" +
                "<p> 7) встановлення порядку організації та діяльності житлово-будівельних кооперативів прав і обов'язків їх членів </p>" +
                "<p> 8) встановлення правил і норм технічної експлуатації жилих будинків і правил користування придомовими територіями; </p>" +
                "</div></body></html>";

        try {
            StringWriter finalResult = new StringWriter();
            SAXTransformerFactory tf = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
            TransformerHandler result = tf.newTransformerHandler();
            result.getTransformer().setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            result.getTransformer().setOutputProperty(OutputKeys.INDENT, "yes");
            result.getTransformer().setOutputProperty(OutputKeys.METHOD, "html");
            result.getTransformer().setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            result.setResult(new StreamResult(finalResult));

            Locale uaLocale = new Locale("ua","");
            ContentHandler postProcess = result;
            DaisyDiff.diffHTML(new InputSource(new StringReader(html1)), new InputSource(new StringReader(html2)), postProcess, "diff", uaLocale);
            System.out.println(finalResult.toString());

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void daisyDiffTest4() throws Exception {
        String htmlPoint7Old = "<html><body>" +
                "<div>" +
                "<p>7) встановлення розміру пільг з оплати жилих приміщень та комунальних послуг;</p>" +

                "</div>" +
                "</body></html>";

        String htmlPoint7New = "<html><body>" +
                "<div>" +
                "<p> 7) встановлення порядку організації та діяльності житлово-будівельних кооперативів прав і обов'язків їх членів </p>" +
                "</div>" +
                "</body></html>";

        String htmlPoint8Old = "<html><body>" +
                "<div>" +
                "<p>8) встановлення порядку організації та діяльності житлово-будівельних кооперативів, прав і обов'язків їх членів;</p>" +
                "</div></body></html>";

        String htmlPoint8New = "<html><body>" +
                "<div>" +
                "<p> 8) встановлення правил і норм технічної експлуатації жилих будинків і правил користування придомовими територіями; </p>" +
                "</div></body></html>";

        try {
            StringWriter finalResult = new StringWriter();
            SAXTransformerFactory tf = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
            TransformerHandler result = tf.newTransformerHandler();
            result.getTransformer().setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            result.getTransformer().setOutputProperty(OutputKeys.INDENT, "yes");
            result.getTransformer().setOutputProperty(OutputKeys.METHOD, "html");
            result.getTransformer().setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            result.setResult(new StreamResult(finalResult));

            Locale uaLocale = new Locale("ua","");
            ContentHandler postProcess = result;
            DaisyDiff.diffHTML(new InputSource(new StringReader(htmlPoint7Old)), new InputSource(new StringReader(htmlPoint7New)), postProcess, "diff", uaLocale);
            System.out.println(finalResult.toString());
            System.out.println("-=-------------------------");

            result.setResult(new StreamResult(finalResult));
            DaisyDiff.diffHTML(new InputSource(new StringReader(htmlPoint8Old)), new InputSource(new StringReader(htmlPoint8New)), postProcess, "diff", uaLocale);
            System.out.println(finalResult.toString());

        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
