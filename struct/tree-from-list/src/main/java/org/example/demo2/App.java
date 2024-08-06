package org.example.demo2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) {

//        List<String> rows = Arrays.asList(
//                "323-200",
//                "323-200.010",
//                "323-200.010.011",
//                "323-200.010.012",
//
//                "323-200.020"
////                "323-200.020.010",
////                "323-200.020.030"
//        );

        List<String> rows = Arrays.asList(
                "a",
                "a.b1",
                "a.b1.c1",
                "a.b1.c10",

                "a.b2.c1",
                "a.b2.c10"
        );
        IntermediateNode root = new App().build(rows);


        String str = print(root, "", "");
        int a = 0;
    }

    private static String print(IntermediateNode root, String prev,  String curr) {
        StringBuilder sb = new StringBuilder();
        System.out.println("prev:" + prev + " curr:" + curr);
        for (Map.Entry<String, IntermediateNode> item : root.valueMap.entrySet()) {

            if(!curr.isEmpty()) {
                prev = curr;
                curr = prev + "/" + item.getKey();
            }
            else{
                curr = item.getKey();
            }

            String res = print(item.getValue(), prev, curr);
            curr=prev;
            sb.append(res);
            sb.append("|");


        }
        // что здесь ?
        return sb.append(curr).toString();
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
