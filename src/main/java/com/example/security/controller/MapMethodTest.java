package com.example.security.controller;

import java.util.HashMap;
import java.util.Map;

/**
 * @author DELL
 * @since 1.0.0
 */
public class MapMethodTest {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        for (int i = 0; i < 6; i++){
            map.put(i, "val_" + i);
        }
        map.put(10, null);

        map.forEach((key, value) -> System.out.println(key + "=" + value));

        String kongde1 = map.getOrDefault(11, "kongde");
        String kongde2 = map.getOrDefault(3, "kongde");
        System.out.println(kongde1);
        System.out.println(kongde2);

        System.out.println(map.putIfAbsent(11, "val_66"));
        System.out.println(map.get(11));
        map.put(11, "1122");
        System.out.println(map.get(11));
    }
}