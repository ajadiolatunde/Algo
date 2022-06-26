package com.example.set;

import java.util.*;

public class Testset {
    public static Set<String> getSet(){
        Set<String> tunde = new HashSet<>();
        //TODO queue and stack;

       List<List<String>> ade = new ArrayList<>();
       List<String> list1 = Arrays.asList("john","tom");
        List<String> list2 = Arrays.asList("john","mary");
        List<String> list3 = Arrays.asList("john","tom");
        List<String> list4 = Arrays.asList("mary","tom");
        List<String> list5 = Arrays.asList("mary","tom");
        Set<List<String>> ola = new HashSet<>();
        ola.add(list1);
        System.out.println(ola.size());
        ola.add(list2);
        System.out.println(ola.size());
        ola.add(list3);
        System.out.println(ola.size());
        ola.add(list4);
        System.out.println(ola.size());
        ola.add(list5);
        System.out.println(ola.size());


        return null;
    }

    public static void main(String[] args){
        getSet();
    }
}
