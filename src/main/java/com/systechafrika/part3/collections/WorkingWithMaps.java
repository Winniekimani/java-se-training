package com.systechafrika.part3.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorkingWithMaps {
    public static void main(String[] args) {
        // Map<KeyType,ValueType>map;
        List<String> winnieNickNames = new ArrayList<>();
        winnieNickNames.add("wagio");
        winnieNickNames.add("njoki");
        winnieNickNames.add("winnie");

        List<String> njeriNickNames = new ArrayList<>();
        njeriNickNames.add("waithera");
        njeriNickNames.add("maryann");
        njeriNickNames.add("njeri");

        // if we want to store the above lists into one we can use maps
        Map<String, List<String>> studentMap = new HashMap<>();
        studentMap.put("winnie", winnieNickNames);
        studentMap.put("njeri", njeriNickNames);
        System.out.println(studentMap);

        System.out.println("get winnieNickNames:" + studentMap.get("winnie"));
        System.out.println("contains key value:" + studentMap.containsKey("winnie"));
        System.out.println("contains emily keyValue:" + studentMap.containsKey("emily"));

    }
}
