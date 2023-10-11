package com.systechafrika.part3.collections;

import java.util.LinkedList;

public class WorkingWithLinkedList {
    public static void main(String[] args) {
        LinkedList<String> animals = new LinkedList<>();
        animals.add("dog");
        animals.add("goat");
        animals.add("cow");
        System.out.println(animals);

        System.out.println(animals.getFirst());
        System.out.println(animals.getLast());
        System.out.println(animals.get(0));

        animals.set(1, "zebra");
        System.out.println(animals);

    }
}
