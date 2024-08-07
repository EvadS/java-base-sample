package org.example.demo3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * рабочий вариант
 */
public class GroupString {

    static class Node {
        String value;
        List<Node> children;

        Node(String value) {
            this.value = value;
            this.children = new ArrayList<>();
        }
    }

    public static void main(String[] args) {

        String[] input = {
                "323-060",
                "323-060.040",
                "323-060.040.030",
                "323-060.088",
                "323-060.088.020",
                "323-060.010",
                "323-060.010.080",
                "323-060.010.080.020",
                "323-060.010.080.060",
                "323-060.010.090",
                "323-060.010.090.060",
                "323-060.030",
                "323-060.030.010",
                "323-060.030.010.020",
                "323-060.010.140",
                "323-060.010.140.090",
                "323-060.010.090.160"
        };

        Node root = buildTree(input);
        List<String> result = new ArrayList<>();
        generatePaths(root, new ArrayList<>(), result);

        for (String path : result) {
            System.out.println(path);
        }
    }

    private static Node buildTree(String[] input) {
        Map<String, Node> nodeMap = new HashMap<>();
        Node root = null;

        for (String path : input) {
            String[] parts = path.split("\\.");
            StringBuilder currentPath = new StringBuilder();
            Node parent = null;

            for (String part : parts) {
                if (currentPath.length() > 0) {
                    currentPath.append(".");
                }
                currentPath.append(part);
                String key = currentPath.toString();

                Node currentNode = nodeMap.getOrDefault(key, new Node(key));
                nodeMap.putIfAbsent(key, currentNode);

                if (parent != null) {
                    if (!parent.children.contains(currentNode)) {
                        parent.children.add(currentNode);
                    }
                } else {
                    root = currentNode;
                }

                parent = currentNode;
            }
        }

        return root;
    }

    private static void generatePaths(Node node, List<String> path, List<String> result) {
        if (node == null) return;

        path.add(node.value);

        if (node.children.isEmpty()) {
            result.add(String.join("\\", path));
        } else {
            for (Node child : node.children) {
                generatePaths(child, new ArrayList<>(path), result);
            }
        }
    }
}
