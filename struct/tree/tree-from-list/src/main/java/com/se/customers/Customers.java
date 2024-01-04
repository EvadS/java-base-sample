package com.se.customers;

import java.util.ArrayList;
import java.util.List;

public class Customers {

    private int id;
    private String name;
    private int parentId;
    private List<Customers> childs;

    public Customers(int id, String name, int parentId) {
        this(id, name, parentId, null);
    }

    public Customers(int id, String name, int parentId, List<Customers> childs) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
        this.childs = childs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public List<Customers> getChilds() {
        return childs;
    }

    public void setChilds(List<Customers> childs) {
        this.childs = childs;
    }
}
