package com.se.sample.providers.simple;

import org.json.simple.JSONObject;

/**
 * Простая программа для JSON на Java
 * используем библиотеку json.simple
 */
public class JsonSimpleApplication {
    public static void main(String[] args) {

        buildSimpleJsonObject();
    }

    private static void buildSimpleJsonObject() {
        JSONObject j = new JSONObject();
        j.put("Name", "Kotte");
        j.put("College", "BVRIT");
        j.put("Branch", "Computer science engineering");
        j.put("Section", "CSE-C");

        System.out.println(j);
    }
}
