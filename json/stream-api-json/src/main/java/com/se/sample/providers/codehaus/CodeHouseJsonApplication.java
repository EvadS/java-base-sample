package com.se.sample.providers.codehaus;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Простая программа для JSON на Java
 * используем библиотеку org.codehaus.jettison
 */
public class CodeHouseJsonApplication {
    static  String jsonString = "{\"User\":{\"FirstName\":\"John\",\"LastName\":\"Reese\"},\"Command\":\"CreateNewUser\"}";

        public static void main(String[] args) throws Exception {
            createManually();
        }

    private static void createManually() throws JSONException {
        JSONObject obj = new JSONObject();
        obj.put("name", "John");
        obj.put("age", 30);
        System.out.println(obj.toString());
    }

    String escapeJson(String input) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", input);
        return jsonObject.toString();
    }

    static void jsonFromMap() throws JSONException {
        Map<String, String> data = new HashMap<>();
        data.put("CS", "Post1");
        data.put("Linux", "Post1");
        data.put("Kotlin", "Post1");
        JSONObject jsonObject = new JSONObject(data);
        String orgJsonData = jsonObject.toString();
    }


    static void create2() throws JSONException {
        String json = "{\"id\":101, \"status\":\"success\"}";
        JSONObject obj = new JSONObject(json);
    }

    static void create4() throws JSONException {
        try {
            JSONObject jsonObject = new JSONObject(jsonString);

            // Get simple string values
            String command = jsonObject.getString("Command");
            System.out.println("Command: " + command); // Output: Command: CreateNewUser

            // Get a nested JSONObject
            JSONObject userObject = jsonObject.getJSONObject("User");
            String firstName = userObject.getString("FirstName");
            System.out.println("First Name: " + firstName); // Output: First Name: John

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}
