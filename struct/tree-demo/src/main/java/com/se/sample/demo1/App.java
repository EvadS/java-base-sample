package com.se.sample.demo1;

import java.util.*;
import java.util.stream.Collectors;

/**
 * построение дерева из 000.0000.0000
 */
public class App {


    private static List<TreeNodeHierachy1> overAllNodeList;

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

        List<TreeNodeHierachy1> overAllNodeList =  AddNodes(test);




        System.out.println("Hello World!");
    }

    private static List<TreeNodeHierachy1> AddNodes(Iterable<String> data) {
        overAllNodeList = new ArrayList<>();

        for (String item : data) {
            List<TreeNodeHierachy1> nodeList = new ArrayList<>();
            String[] split = item.split("\\.");
            for (int i = 0; i < split.length; i++) {

                UUID guid = UUID.randomUUID();
                int finalI = i;

                TreeNodeHierachy1 parent = null;
                Optional<TreeNodeHierachy1> parentOpt = i == 0 ? null :
                        nodeList.stream().filter(x -> x.Level == finalI - 1)
                                .findFirst();

                if(parentOpt!=null &&  !parentOpt.isPresent()){
                    parent = parentOpt.get();
                }

                // корень
                TreeNodeHierachy1 root = null;
                Optional<TreeNodeHierachy1> rootOpt = i == 0 ? null :
                        nodeList.stream().filter(n -> n.Level == 0).findFirst();

                if(rootOpt!=null &&  rootOpt.isPresent()){
                    root = rootOpt.get();
                }

                TreeNode1 treeNode1 = new TreeNode1(split[i], guid);

                TreeNodeHierachy1 treeNodeHierachy = new TreeNodeHierachy1(i,
                        treeNode1, guid,
                        parent != null ? parent.Id : new UUID(0, 0),
                        root != null ? root.RootText : split[i]);

                nodeList.add(treeNodeHierachy);
            }// for

            if (!overAllNodeList.stream().findAny().isPresent()) {
                overAllNodeList.addAll(nodeList);
            } else {

                nodeList = nodeList.stream().sorted(Comparator.comparingInt(o -> o.Level)).collect(Collectors.toList());
                for (int i = 0; i < nodeList.size(); i++) {

                    List<TreeNodeHierachy1> finalNodeList = nodeList;
                    int finalI = i;

                    Optional<TreeNodeHierachy1> first = overAllNodeList.stream().filter(
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
