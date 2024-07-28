package org.example;

import org.example.model.ClassName;

import java.util.*;


/**
 * вариант1
 */
public class TreeBuilder {

    public static void main(String[] args) {
        List<String> rows = new ArrayList<>();
//        rows.add("1.2.3.4.5");
//        rows.add("1.3.2.4.5");
//        rows.add("1.2.4.5.6");
//
//        rows.add("A1.2.4.5.6");

        rows.add("323-050");
        rows.add("323-050.130");
        rows.add("323-050.130.020");


        rows.add("323-060");
        rows.add("323-060.070");
        rows.add("323-060.070.170");

        MyTreeMap root = new MyTreeMap();
        for (String row : rows) {
            MyTreeMap n = root;
            String[] cells = row.split("\\.");
            for (String cell : cells) {
                MyTreeMap child = n.get(cell);
                if (child == null) {
                    n.put(cell, child = new MyTreeMap());
                }
                n = child;
            }
        }

        int a =0;

       String res = DocumentDiffResponse(root);
      //  print(root, "", "/");
    }

    public static String DocumentDiffResponse(MyTreeMap parent) {
        StringBuilder builder = new StringBuilder();

        for (Map.Entry<String, MyTreeMap> current : parent.entrySet()) {
            String docStructDiffResult = BuildDocumentDiffResultRecursive(current, "");
            builder.append(docStructDiffResult);
        }
        return builder.toString();
    }

    private static String BuildDocumentDiffResultRecursive(Map.Entry<String, MyTreeMap> current, String curr) {

        if (current != null) {
            int a =0;
           // return current.getKey() + BuildDocumentDiffResultRecursive(current, times - 1);
        }
        return current.getKey();

    }

    static void print(MyTreeMap parent, String indentationStr, String indentationStrAddition) {
        for (Map.Entry<String, MyTreeMap> o : parent.entrySet()) {
            System.out.println(indentationStr + o.getKey());
            print(o.getValue(), indentationStr + indentationStrAddition, indentationStrAddition);
        }
    }

    /**
     * This is just a construct that helps us to parameterize recursively.
     */
    static class MyTreeMap extends TreeMap<String, MyTreeMap> {
        private static final long serialVersionUID = 1L;
    }

}