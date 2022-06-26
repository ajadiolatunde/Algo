package com.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Arraysort {
    public static void main(String[] args){
        String[] kl = new String[]{"kola","ta2","bola22","fola222"};
         //List<String> ko = Arrays.stream(kl)
        String[] ko = Arrays.stream(kl)
                .map(value->value+"___")
                 .filter(item-> item.contains("a"))

                 //.collect(Collectors.toList());
                .toArray(String[]::new);
        System.out.println(ko);
        String shortest = Arrays.stream(ko)
                .min(Comparator.comparing(item -> item.length()))
                .get();
        System.out.println(shortest);
//        map.compute("123", (key, value) ->
//                value == null ? null :
//                        value.toString().toUpperCase());



    }
    //    Arrays.sort(parts, (String a, String b) -> b.length() - a.length());
    //     return Arrays.stream(sen.split(" ")).max(Comparator.comparingInt(String::length)).orElse(null).toString();
}
