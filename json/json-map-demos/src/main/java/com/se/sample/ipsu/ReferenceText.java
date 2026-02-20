package com.se.sample.ipsu;

import com.fasterxml.jackson.databind.JsonNode;

public class ReferenceText {
    public String id;
    public String text;
    public String an;

    public ReferenceText(String id, String text, String an) {
        this.id = id;
        this.text = text;
        this.an = an;
    }
}
