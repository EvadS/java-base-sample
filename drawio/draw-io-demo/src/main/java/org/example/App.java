package org.example;


import org.apache.commons.codec.CharEncoding;
import org.apache.commons.text.StringEscapeUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Entities;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;
import org.nasdanika.drawio.*;
import org.w3c.dom.NamedNodeMap;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.*;
import java.net.URL;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Hello world!
 * //Build-Jdk: 11.0.15
 */
public class App {
    public static void main(String[] args) throws IOException {
        App app = new App();
        ///  app.readDiagramAndRewrite();
        //app.testCreate();


        String fileText;
        InputStream inputStream = null;
        BufferedReader bufferedReader = null;
        try {
            inputStream = App.class.getClassLoader().getResourceAsStream("compressed-html.txt");
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));


            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                builder.append(line);
            }

            fileText = builder.toString();

        } finally {
            bufferedReader.close();
            inputStream.close();
        }

        org.jsoup.nodes.Document newDocument = Jsoup.parse(fileText.replace("\\", ""), "", Parser.htmlParser());
        newDocument.outputSettings().escapeMode(Entities.EscapeMode.base);
        newDocument.outputSettings().charset(CharEncoding.UTF_8);

        Elements select = newDocument.select("div.mxgraph");
        String attr = select.get(0).attr("data-mxgraph");


        int diagram = attr.indexOf("<diagram");
        int diagramEnd = attr.indexOf("</diagram>");

        String substring2 = attr.substring(diagram, diagramEnd + "</diagram>".length());
        String str = "<mxfile>" + substring2 + "</mxfile>";
        readFromHtml(str);
    }


    public static void readFromHtml(String htmlData)  {
        try {
            Document document = Document.load(htmlData, null);
            List<Page> pages = document.getPages();
            Page page = pages.get(0);

            Model model = page.getModel();
            Root root = model.getRoot();
            List<Layer> layers = root.getLayers();
            //первый слой
            Layer layer = layers.get(0);
            List<LayerElement> layerElements = layer.getElements();
            // NodeImpl
            for (ModelElement modelElement : layerElements) {

                NamedNodeMap attributes = modelElement.getElement().getAttributes();

                int length = modelElement.getElement().getAttributes().getLength();
                // добрались до того места где лига-закон
                org.w3c.dom.Node value1 = attributes.getNamedItem("value");
                if (value1 != null) {
                    String value = attributes.getNamedItem("value").toString();
                    String replacedString = replaceToCorrectServer(value);
                    attributes.getNamedItem("value").setNodeValue(replacedString);
                }
            }

            // сохранить роз-архивируванную
            String save2 = document.save(false);
            writeUsingOutputStream(save2, "real_diagram.drawio");

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParserConfigurationException | TransformerException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }

    }

    private static String replaceToCorrectServer(String value) {
        String oldServer = "https://ips.ligazakon.net";
        String newServer = "https://legislation-dev.ligaunited.net";

        int pos = value.indexOf(oldServer);
        if (pos != -1) {
            StringBuilder textBuff = new StringBuilder(value);
            textBuff.replace(pos, pos + oldServer.length(), newServer);
            value = textBuff.toString();
        }

        return value;
    }

    public void readDiagramAndRewrite() {
        try {
            URL resource = getClass().getClassLoader().getResource("compressed.drawio");

            Document document = Document.load(resource);
            List<Page> pages = document.getPages();
            if(pages.isEmpty()){
                // log
                return;
            }
            Page page = pages.get(0);

            Model model = page.getModel();
            Root root = model.getRoot();
            List<Layer> layers = root.getLayers();

            //первый слой
            Layer layer = layers.get(0);
            List<LayerElement> layerElements = layer.getElements();

            // NodeImpl
            for (ModelElement modelElement : layerElements) {

                NamedNodeMap attributes = modelElement.getElement().getAttributes();

                int length = modelElement.getElement().getAttributes().getLength();
                // добрались до того места где лига-закон
                org.w3c.dom.Node value1 = attributes.getNamedItem("value");
                if (value1 != null) {
                    String value = attributes.getNamedItem("value").toString();
                    String replacedString = replaceToCorrectServer(value);
                    attributes.getNamedItem("value").setNodeValue(replacedString);
                }
            }
            // сохранить роз-архивируванную
            String save2 = document.save(false);
            writeUsingOutputStream(save2, "uncompressed_server.drawio");

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParserConfigurationException | TransformerException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Hello World!");
    }

    public void testCreate() throws ParserConfigurationException, IOException, TransformerException {
        Document document = Document.create(false, null);
        Page page = document.createPage();
        page.setName("My first new page");

        Model model = page.getModel();
        Root root = model.getRoot();
        List<Layer> layers = root.getLayers();

// Add layer
        Layer newLayer = root.createLayer();
        newLayer.setLabel("My new layer");

// Add nodes
        Node source = newLayer.createNode();
        source.setLabel("My source node");
        Rectangle sourceGeometry = source.getGeometry();
        sourceGeometry.setX(200);
        sourceGeometry.setX(100);
        sourceGeometry.setWidth(70);
        sourceGeometry.setHeight(30);
        source.getTags().add("aws");

        Node target = newLayer.createNode();
        target.setLabel("My target node");
        target.getGeometry().setBounds(300, 150, 100, 30);
        Set<String> targetTags = target.getTags();
        targetTags.add("aws");
        targetTags.add("azure");

// Add connection
        Connection connection = newLayer.createConnection(source, target);
        connection.setLabel("My connection");
        Map<String, String> connectionStyle = connection.getStyle();
        connectionStyle.put("edgeStyle", "orthogonalEdgeStyle");
        connectionStyle.put("rounded", "1");
        connectionStyle.put("orthogonalLoop", "1");
        connectionStyle.put("jettySize", "auto");
        connectionStyle.put("html", "1");

        String save2 = document.save(false);
        writeUsingOutputStream(save2, "new-uncompressed.drawio");

    }

    private static void writeUsingOutputStream(String data, String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(data);

        writer.close();


    }
}
