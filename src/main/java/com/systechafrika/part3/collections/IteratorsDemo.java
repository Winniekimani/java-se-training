package com.systechafrika.part3.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorsDemo {
    public static void main(String[] args) {
        List<String> winnieNickNames = new ArrayList<>();
        winnieNickNames.add("wagio");
        winnieNickNames.add("njoki");
        winnieNickNames.add("winnie");

        Iterator<String> iterator = winnieNickNames.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
