package com.se.sample.providers.gson;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonArrayExample {
    public static void main(String[] args) {
        // 1. Create an empty JSONArray
        JSONArray jsonArray = new JSONArray();

        // 2. Add different types of values
        jsonArray.put("itemPrice");
        jsonArray.put(100);
        jsonArray.put(true);

        // 3. Add a JSONObject to the array
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("type", "home");
        jsonObject.put("number", "212 555-1234");
        jsonArray.put(jsonObject);

        // 4. Convert the JSONArray to a JSON formatted string
        System.out.println(jsonArray.toString(4)); // Pretty print with 4 spaces indent
    }

    static void readingParsingJsonArray(){
        String jsonArrayString = "[\"apple\", \"banana\", \"cherry\"]";
        JSONArray jsonArray = new JSONArray(jsonArrayString);

        // Iterate through the JSONArray
        for (int i = 0; i < jsonArray.length(); i++) {
            String fruit = jsonArray.getString(i); // Use typed get methods
            System.out.println("Fruit at index " + i + ": " + fruit);
        }

        // You can also get a List view of the array if needed
        // List<Object> list = jsonArray.toList();
    }

    static void create (){
        // 1. Create an empty JSONArray
        JSONArray jsonArray = new JSONArray();

        // 2. Add different types of values
        jsonArray.put("itemPrice");
        jsonArray.put(100);
        jsonArray.put(true);

        // 3. Add a JSONObject to the array
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("type", "home");
        jsonObject.put("number", "212 555-1234");
        jsonArray.put(jsonObject);

        // 4. Convert the JSONArray to a JSON formatted string
        System.out.println(jsonArray.toString(4));
    }
}
