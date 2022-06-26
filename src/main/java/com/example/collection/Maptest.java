package com.example.collection;

import java.util.*;
import java.util.stream.Collectors;

public class Maptest {
    public static void main(String[] args){
        Map<String,Integer> kl = new HashMap<String,Integer>();
        kl.put("house",3);
        kl.put("car",4);
        kl.put("food",6);
        kl.put("class",7);
        System.out.println(kl.entrySet());
        Map<String,Integer> jk= kl.entrySet().stream().sorted( Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println(kl.entrySet());




    }
}
