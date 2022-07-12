package com.example.Toptal;

import java.util.*;
import java.util.stream.Collectors;

public class indexOfArrays {
    public static void main(String[] args){
        int[] jk = new int[]{2,6,3,1,3,4,4};
        String[] at1 = {"300.00","100.00","200.00"};

        Map<Integer, Double> kl = new HashMap<>();
        for (int g=0;g<at1.length;g++){
            kl.put(g, Double.parseDouble(at1[g]));
        };
        System.out.println(kl.entrySet());
        Map<Integer,Double> sortmap = kl.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(oldV,neV)->oldV, LinkedHashMap::new));
        System.out.println(sortmap.entrySet());


    }
}
