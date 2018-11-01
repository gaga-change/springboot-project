package com.example.admin.util;

import java.util.HashMap;
import java.util.Map;

public class ResFactory {
    public static Map getRes(String message, Object obj) {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", message);
        if (obj != null)
            map.put("data", obj);
        return map;
    }

    public static Map getRes(Object obj) {
        return getRes("", obj);
    }

    public static Map getRes(String message) {
        return getRes(message, null);
    }
}
