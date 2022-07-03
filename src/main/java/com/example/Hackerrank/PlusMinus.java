package com.example.Hackerrank;

import java.util.*;

public class PlusMinus {
    public static void plusMinus(List<Integer> arr) {
        Map<String,Integer> table = new HashMap<>();
        table.put("P",0);
        table.put("Z",0);
        table.put("N",0);


        arr.stream().forEach(x->{
            if (x<0)table.put("N",table.getOrDefault("N", 0)+1);
            if (x>0)table.put("P",table.getOrDefault("P", 0)+1);
            if (x==0)table.put("Z",table.getOrDefault("Z", 0)+1);

        });
        double p = Double.valueOf(table.get("P"))/arr.size();
        double n = Double.valueOf(table.get("N"))/arr.size();

        double z = Double.valueOf(table.get("Z"))/arr.size();
        System.out.println(z+"--------z");
        System.out.printf("%.6f%n", p);
        System.out.printf("%.6f%n", n);
        System.out.printf("%.6f%n", z);

        // Write your code here

    }

    public static void main(String[] args){
        List<Integer> arr = new ArrayList<>(Arrays.asList(-4, 3, -9, 0, 4, 1));
        plusMinus(arr);
    }
}
