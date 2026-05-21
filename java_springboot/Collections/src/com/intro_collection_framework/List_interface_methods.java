package com.intro_collection_framework;


import java.util.*;

public class List_interface_methods {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("Apple");
        list.add("Banana");
        list.add("Mango");

        System.out.println("List: " + list);

        list.remove("Banana");
        System.out.println("After remove: " + list);

        System.out.println("First element: " + list.get(0));

        list.set(0, "Orange");
        System.out.println("After update: " + list);

        System.out.println("Size: " + list.size());
    }
}
