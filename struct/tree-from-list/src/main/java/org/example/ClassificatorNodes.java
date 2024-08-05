package org.example;

import org.example.model.Node;

import java.util.Arrays;
import java.util.List;

public class ClassificatorNodes {


    public static void main(String[] args) {


        List<String> strings = Arrays.asList(
                "323-200",
                "323-200.010",
                "323-200.010.010",
                "323-200.010.020",
                "323-200.010.030",
                "323-200.010.040",
                "323-200.010.050",
                "323-200.020",
                "323-200.020.010",
                "323-200.020.030"
        );

        Node root = groupClassificator(strings);
    }

    private static Node groupClassificator(List<String> strings) {

        Node root = new Node();

        for (String item : strings) {
            Node currentParent = root;

            String[] split = item.split("\\.");
            String parentId = item;

            for (int i = 0; i < split.length - 1; i++) {
                parentId = i == 0 ? split[i] : parentId + ("." + split[i]);

                // TODO: проверить что для этого есть родитель
                // currentParent = map.get(parentId);
            }
            // текущий корень изменился
            if (!item.equals(parentId)) {

            } else {
                currentParent.add(item);
            }
        }

        return root;

    }
}
