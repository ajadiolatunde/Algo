package com.example.Hackerrank;

import java.util.*;
import java.util.stream.Collectors;

public class Lonelyinteger {
    public static int lonelyinteger(List<Integer> a) {
        Map<Integer,Integer> table = a.stream()
                .collect(Collectors.groupingBy(x->x,Collectors.summingInt(x -> 1)));

        int min = table.entrySet().stream().min(Map.Entry.comparingByValue()).get().getKey();
        System.out.println(min);

        return min;
        // Write your code here

    }
    public static void main(String[] args){
        List<Integer>  arr = new ArrayList<>(Arrays.asList(1,1,2));
        lonelyinteger(arr);
    }
}
