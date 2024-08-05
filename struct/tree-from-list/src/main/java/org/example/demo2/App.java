package org.example.demo2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) {

        List<String> rows = Arrays.asList(
                "323-200",
                "323-200.010",
                "323-200.010.011",
                "323-200.010.012",

                "323-200.020"
//                "323-200.020.010",
//                "323-200.020.030"
        );

        IntermediateNode root = new App().build(rows);


        String str = print(root, "", "");
        int a = 0;
    }

    private static String print(IntermediateNode root, String prev,  String full) {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, IntermediateNode> item : root.valueMap.entrySet()) {

            if(!full.isEmpty()) {
                prev = prev +"."+item.getKey() ; //323-200/323-200.010 -> 323-200.010
                full = full + "/"+prev;
            }
            else{
                full = item.getKey();
                prev = full;
            }

            sb.append(print(item.getValue(), prev, full));

            System.out.println("=============================");
            System.out.println(full);
            sb.append("|");
        }

        return sb.append(full).toString();
    }

    public IntermediateNode build(List<String> lines) {
        IntermediateNode root = new IntermediateNode();


        for (String line : lines) {
            List<String> values = new LinkedList<>(Arrays.asList(line.split(",")));
            String[] paths = values.get(0).split("\\.");

            IntermediateNode currentNode = root;
            for (int i = 0; i < paths.length; i++) {
                IntermediateNode node = currentNode.valueMap.get(paths[i]);
                if (node == null) {
                    IntermediateNode child = new IntermediateNode();
                    currentNode.valueMap.put(paths[i].trim(), child);
                    currentNode = child;
                } else {
                    currentNode = node;
                }
            }
        }
        return root;

    }

}
