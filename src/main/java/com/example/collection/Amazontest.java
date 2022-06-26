package com.example.collection;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Amazontest {
    //{adg124,adg133,adg141,adg212,adg241,adg321,adg314}
    public static void main (String[] args){
        String[] st = new String[]{"adg124","adg13","adg141","adg212","adg241","adg321","adg314"};
        Map<String,Long> maps = Arrays.stream(st)
                .map(t->t.substring(0,4))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(maps.entrySet());
        Map<String,Integer> mp = new HashMap<>();
        Arrays.stream(st)
                .forEach(t->{
                    int score = (t.length()>5)?Integer.valueOf(t.substring(5,6)):0;
                    System.out.println(t+"----"+score);
                    mp.put(t.substring(0,4),mp.getOrDefault(t.substring(0,4),0)+score);
                });
        System.out.println(mp.entrySet());

    }


}
