package org.example.demo2;

import java.util.*;

public class App {

    public static void main(String[] args) {

        List<String> rows = Arrays.asList(
                "323-200",
                "323-200.010",
                "323-200.010.011",
                "323-200.010.012",

                "323-200.020",
                "323-200.020.010",
                "323-200.020.030"
        );

//        List<String> rows = Arrays.asList(
//                "a-0",
//                "a-0.b1",
//                "a-0.b1.c1",
//                "a-0.b1.c10",
//                "a-0.b2.c1",
//                "a-0.b2.c10"
//        );


        IntermediateNode root = new App().build(rows);
        List<String> str = print(root, "", "", new LinkedList<String>());
        int a = 0;
    }

    static  int i =0;
    private static List<String> print(IntermediateNode root, String prev,  String curr, LinkedList<String> segments) {
        StringBuilder sb = new StringBuilder();

        i++;
        for (Map.Entry<String, IntermediateNode> item : root.valueMap.entrySet()) {

            if(!curr.isEmpty()) {
                prev = curr;
                curr = prev  + "." + item.getKey();
            }
            else{
                curr = item.getKey();
            }

            segments.add(curr);

            List<String> res = print(item.getValue(), prev, curr, segments);

            curr=prev;
            sb.append(res);
            sb.append("|");


        }
        // что здесь ?
        return segments;///sb.append(curr).toString();
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
