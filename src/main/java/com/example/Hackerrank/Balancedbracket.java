package com.example.Hackerrank;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Balancedbracket {
    public static String isBalanced(String s) {
        String cl = "(";
        String cr = ")";
        String bl = "[";
        String br = "]";
        String vr = "{";
        String vl = "}";
        String[] sk = s.split("");
        Map<String,Integer> map = Arrays.asList(sk).stream().collect(Collectors.groupingBy(x->x,Collectors.summingInt(x->1)));
        if (s.length()%2 != 0)return "NO";
        if (map.entrySet().size()%2 != 0)return "NO";
        if (map.get(cl) != map.get(cr)|| map.get(bl) != map.get(br) ||map.get(vl) != map.get(vr) ) return "NO";
        return "YES";

        // Write your code here

    }
    public static void main(String[] args){

    }
}
