package org.example.model;

import org.example.FolderDaoModel;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private  String value;
    private List<Node> child = new ArrayList<>();

    public  Node(){

    }

    public Node(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Node> getChild() {
        return child;
    }

    public void setChild(List<Node> child) {
        this.child = child;
    }


    public void add (String value){
        Node node = new Node(value);
        this.child.add(node);
    }
}
