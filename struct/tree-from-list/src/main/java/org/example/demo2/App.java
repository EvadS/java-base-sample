package org.example.demo2;

import org.example.model.Data;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// todo: я не дописал
public class App {

    static int i = 0;

    public static void main(String[] args) {

        IntermediateNode root = new App().build(Data.rowsList3);
        String str = print(root, "", "");
        int a = 0;
    }

    private static String print(IntermediateNode root, String prev, String curr) {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, IntermediateNode> item : root.valueMap.entrySet()) {
            if (!curr.isEmpty()) {
                prev = curr;
                curr = prev + "." + item.getKey();
            } else {
                curr = item.getKey();
            }

            String res =  print(item.getValue(), prev, curr);
            System.out.println("res: " + res);
            curr = prev;
        }
        // что здесь ?
        return curr;//sb.append(curr).toString();
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
