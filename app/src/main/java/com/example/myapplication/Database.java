package com.example.myapplication;

import com.example.myapplication.models.Currency;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Getter
public class Database {
    private static Map<String, Currency> map = new ConcurrentHashMap<>();
    private static String preview;

    public static void update(Map<String, Currency> newMap) {
        map.clear();
        map.putAll(newMap);
    }

    public static void setPreview(String cur) {
        preview = cur;
    }

    public static Currency getPreview() {
        return map.get(preview);
    }

    public static List<Currency> getList() {
        return new ArrayList<>(map.values());
    }

    public static Currency getCurrencyByString(String str) {
        return map.get(str);
    }
}
