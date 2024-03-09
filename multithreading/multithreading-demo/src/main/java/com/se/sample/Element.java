package com.se.sample.model;

import java.util.LinkedList;

public class Element {
    private String typedFacet;
    private  String decode;
    private Long count;
    private String dictTypedFacetDecode;
    private LinkedList<Element> childs;
    private String name;


    public Element(String typedFacet, String decode, Long count, String dictTypedFacetDecode, LinkedList<Element> childs, String name) {
        this.typedFacet = typedFacet;
        this.decode = decode;
        this.count = count;
        this.dictTypedFacetDecode = dictTypedFacetDecode;
        this.childs = childs;
        this.name = name;
    }

    public String getTypedFacet() {
        return typedFacet;
    }

    public void setTypedFacet(String typedFacet) {
        this.typedFacet = typedFacet;
    }

    public String getDecode() {
        return decode;
    }

    public void setDecode(String decode) {
        this.decode = decode;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getDictTypedFacetDecode() {
        return dictTypedFacetDecode;
    }

    public void setDictTypedFacetDecode(String dictTypedFacetDecode) {
        this.dictTypedFacetDecode = dictTypedFacetDecode;
    }

    public LinkedList<Element> getChilds() {
        return childs;
    }

    public void setChilds(LinkedList<Element> childs) {
        this.childs = childs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
