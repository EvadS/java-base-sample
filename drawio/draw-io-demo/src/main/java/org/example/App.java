package org.example;


import org.nasdanika.drawio.*;
import org.w3c.dom.NamedNodeMap;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Hello world!
 * //Build-Jdk: 11.0.15
 */
public class App 
{
    public static void main( String[] args ) throws ParserConfigurationException, IOException, TransformerException {


            App app = new App();
            app.test();

            // app.testCreate();
    }

    public void test ()   {
        try {
            URL resource = getClass().getClassLoader().getResource("compressed.drawio");

                       Document document = Document.load(resource);
            List<Page> pages = document.getPages();
            Page page = pages.get(0);

            Model model = page.getModel();
            Root root = model.getRoot();
            List<Layer> layers = root.getLayers();

            //первый слой
            Layer layer = layers.get(0);
            List<ModelElement> modelElements = layer.getElements();

            // NodeImpl
            for(ModelElement modelElement :  modelElements ){

                NamedNodeMap attributes = modelElement.getElement().getAttributes();

                int length = modelElement.getElement().getAttributes().getLength();
                // добрались до того места где лига-закон
                org.w3c.dom.Node value1 = attributes.getNamedItem("value");
                if(value1!= null) {
                    String value = attributes.getNamedItem("value").toString();
                    String replacedString = replaceToCorrectServer(value);
                    attributes.getNamedItem("value").setNodeValue(replacedString);
                    int aa = 0;
                }
            }

            // сохранить розархивируванную
            String save2 = document.save(false);
            writeUsingOutputStream(save2,"uncompressed_server.drawio");

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParserConfigurationException | TransformerException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }

        System.out.println( "Hello World!" );
    }

    private String replaceToCorrectServer(String value) {
        String oldServer = "https://ips.ligazakon.net";
        String newServer = "https://legislation-dev.ligaunited.net";

        int pos = value.indexOf(oldServer);
        if (pos != -1) {
            StringBuffer textBuff = new StringBuffer(value);
            textBuff = textBuff.replace(pos, pos + oldServer.length(), newServer);
            value = textBuff.toString();
        }


        return value;
    }

    public void testCreate () throws ParserConfigurationException, IOException, TransformerException {
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

      //  Files.writeString(new File("new-uncompressed.drawio").toPath(), document.save(null));


        Path path = new File("new-compressed.drawio").toPath();
        String save2 = document.save(true);
        writeUsingOutputStream(save2,"new-uncompressed.drawio");

    }

    private  void writeUsingOutputStream(String data, String fileName) {
        URL resource = getClass().getClassLoader().getResource(fileName);
        OutputStream os = null;
        try {
            os = new FileOutputStream(fileName);
            os.write(data.getBytes(), 0, data.length());
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
