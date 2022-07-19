package com.example.Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Countunique {
    private static int f(int k){
        return k+1;
    }
    private static void count(String s){
        Map<Character,List<Integer>> all_indexes = new HashMap<>();
        for (int i = 0;i<s.length();i++){
            all_indexes.computeIfAbsent(s.charAt(i), key-> new ArrayList<>()).add(i);
        }
        System.out.println(all_indexes.entrySet());
    }

    public static void main(String[] args){
        count("olatundeajadi");

    }
}
