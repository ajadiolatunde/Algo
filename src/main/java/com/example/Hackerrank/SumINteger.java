package com.example.Hackerrank;

import java.util.*;
import java.util.stream.Collectors;

public class SumINteger {
    public static void miniMaxSum(List<Integer> arr) {
        List<Long> records = new ArrayList<>();
        for (int x=0;x<arr.size();x++){
            List<Integer> nearray = new ArrayList<>();
            nearray.addAll(arr);

            nearray.remove(x);
            long sum = nearray.stream().mapToLong(Integer::intValue).sum();
            records.add(sum);

        }

        Collections.sort(records);
        String  res =  records.get(0)+" "+records.get(records.size()-1);

        System.out.println(res);;
        // Write your code here

    }
     public static void main(String[] args){
         //256741038 623958417 467905213 714532089 938071625 ---2063136757 2744467344
         List<Integer> gh = Arrays.asList(256741038,623958417,467905213,714532089,938071625);
         miniMaxSum(gh);
         long sum = gh.stream().mapToLong(Integer::intValue).sum();
         System.out.println(sum);


     }

}
