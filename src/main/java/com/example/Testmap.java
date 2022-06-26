package com.example;

import java.util.*;

public class Testmap {
    public static void main(String[] args){
        List<Map<String, String>> blocks = new ArrayList<Map<String, String>>();
        //Assuming gym,rest,bake
        Map<String, String> item = new HashMap<>();
        item.put("gym", "true1");
        item.put("rest", "false");
        item.put("bake", "false");

        Map<String, String> item2 = new HashMap<>();
        item.put("gbbym", "false");
        item.put("dfrest", "true1");
        item.put("bdfdake", "true");
        Collection<Map<String, String>> collection = new ArrayList<>();
        collection.add(item2);
        collection.add(item);
//        blocks.addAll(item,item2);
//        blocks.add(item2);
        collection.stream().forEach(System.out::println);
    }
}
