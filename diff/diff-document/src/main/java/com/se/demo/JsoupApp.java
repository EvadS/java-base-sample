package com.se.demo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;

public class JsoupApp {
    public static void main(String[] args) throws IOException {
        File in = new File("KD0003_2021_07_15.txt");
        Document doc1 = Jsoup.parse(in, "UTF-8");

        File in2= new File("KD0003_2022_11_19.txt");
        Document doc2 = Jsoup.parse(in2, "UTF-8");


        Function<String, String> normalizer = (original) ->
                original
                        .replaceAll("[\\s+]?\n+[\\s+]?", "") // remove newline chars
                        .replaceAll("(>)(\\s+)(<)", "$1$3") // remove white space between tags
                        .toLowerCase();
        String html1 = normalizer.apply(doc1.html());
        String html2 = normalizer.apply(doc2.html());


        Element h30 = doc1.select("h3").get(0);

        List<Node> nodes = h30.childNodes();
        for(Node item : nodes){

            int a =0;
            List<Node> nodes1 = item.childNodes();
            for(Node item2 : nodes1){
                int b= 0;
            }
        }


        int a =0;
    }
}
