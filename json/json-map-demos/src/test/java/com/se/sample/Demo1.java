package com.se.sample;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public class Demo1 {

    List<Map<String, String>> getAccounts(String payload) {
        Gson gson = new Gson();
        java.lang.reflect.Type myMapType = new TypeToken<Map<String, List<Map<String, String>>>>() { }.getType();
        Map<String, List<Map<String, String>>> parsed = gson.fromJson(payload, myMapType);
        return parsed.get("Accounts");
    }

    @Test
    void test() throws ParseException {
        List<Map<String, String>> accounts = getAccounts(payload);
        accounts.forEach(acc ->
                System.out.println(String.format("owner=%s value=%s",acc.get("owner"), acc.get("Value"))));
    }

    String payload = "";
}
