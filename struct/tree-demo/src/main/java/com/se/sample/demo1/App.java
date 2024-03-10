package com.se.sample.demo1;

import java.util.*;
import java.util.stream.Collectors;

/**
 * построение дерева из 000.0000.0000
 */
public class App {


    private static List<TreeNodeHierarchy> overAllNodeList;

    public static void main(String[] args) {

        List<String> test = Arrays.asList(
            //   "032-0001",
                "032-0001.0021",
                "032-0001.0021.0006",
                "032-0001.0021.0006.0001",
                "032-0001.0021.0006.0002",
                "032-0001.0022",
                "032-0001.0022.0006",
                "032-0001.0022.0007",
                "032-0001.0022.0008");

        List<TreeNodeHierarchy> overAllNodeList =  AddNodes(test);




        System.out.println("Hello World!");
    }

    private static List<TreeNodeHierarchy> AddNodes(Iterable<String> data) {
        overAllNodeList = new ArrayList<>();

        for (String item : data) {
            List<TreeNodeHierarchy> nodeList = new ArrayList<>();
            String[] split = item.split("\\.");
            for (int i = 0; i < split.length; i++) {

                UUID guid = UUID.randomUUID();
                int finalI = i;

                TreeNodeHierarchy parent = null;
                Optional<TreeNodeHierarchy> parentOpt = i == 0 ? null :
                        nodeList.stream().filter(x -> x.Level == finalI - 1)
                                .findFirst();

                if(parentOpt!=null &&  !parentOpt.isPresent()){
                    parent = parentOpt.get();
                }

                // корень
                TreeNodeHierarchy root = null;
                Optional<TreeNodeHierarchy> rootOpt = i == 0 ? null :
                        nodeList.stream().filter(n -> n.Level == 0).findFirst();

                if(rootOpt!=null &&  rootOpt.isPresent()){
                    root = rootOpt.get();
                }

                TreeNode treeNode = new TreeNode(split[i], guid);

                TreeNodeHierarchy treeNodeHierarchy = new TreeNodeHierarchy(i,
                        treeNode, guid,
                        parent != null ? parent.Id : new UUID(0, 0),
                        root != null ? root.RootText : split[i]);

                nodeList.add(treeNodeHierarchy);
            }// for

            if (!overAllNodeList.stream().findAny().isPresent()) {
                overAllNodeList.addAll(nodeList);
            } else {

                nodeList = nodeList.stream().sorted(Comparator.comparingInt(o -> o.Level)).collect(Collectors.toList());
                for (int i = 0; i < nodeList.size(); i++) {

                    List<TreeNodeHierarchy> finalNodeList = nodeList;
                    int finalI = i;

                    Optional<TreeNodeHierarchy> first = overAllNodeList.stream().filter(
                            n -> n.Node.getText().equals(finalNodeList.get(finalI).Node.getText())
                                    && n.Level == finalNodeList.get(finalI).Level
                                    && n.RootText.equals(finalNodeList.get(finalI).RootText)).findFirst();

                    if (first.isPresent() && (i + 1) < nodeList.stream().count()) {
                        nodeList.get(i + 1).ParentId = first.get().Id;
                    } else {
                        overAllNodeList.add(nodeList.get(i));
                    }
                }
            }// else
        }

        return overAllNodeList;
    }
}
