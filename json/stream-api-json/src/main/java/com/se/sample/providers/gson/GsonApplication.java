package com.se.sample.providers.gson;


import com.google.gson.*;


/**
 * Библиотека GSON была разработана программистами Google и позволяет конвертировать
 * объекты JSON в Java-объекты и наоборот
 */
public class GsonApplication {

    public static void main(String[] args) {

    }


   private static  void base (){
        String jsonString = "{\"name\":\"John\", \"age\":30}";

        // Method 1: Using JsonParser
        JsonElement jsonElement = JsonParser.parseString(jsonString);
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        System.out.println(jsonObject.get("name").getAsString()); // Output: John

        // Method 2: Using Gson.fromJson
        Gson gson = new Gson();
        JsonElement element = gson.fromJson(jsonString, JsonElement.class);
        System.out.println(element.getAsJsonObject().get("age").getAsInt()); // Output: 30
    }

    private static void createFromString(){
        String jsonText = "{\"name\":\"Мурзик\",\"color\":-16777216,\"age\":9}";

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Cat murzik = gson.fromJson(jsonText, Cat.class);
    }

    private static void createComplexTypeFromJson(){
        CatComplexType murzik = new CatComplexType();
        murzik.name = "Мурзик";
        murzik.age = 9;
        murzik.color = 1;

        murzik.address = new Address("Arbat", "Moscow", "Russia");

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        //Пробуем в обратном порядке - из json-строки получим объект.


        String jsonText = "{\"address\":{\"city\":\"New York\",\"country\":\"USA\"," +
                "\"street\":\"Wall Street\"},\"age\":11,\"color\":-16777216,\"name\":\"Murzik\"}";

        murzik = gson.fromJson(jsonText, CatComplexType.class);
    }
}
