package com.example.maps;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Onespace {

    public static void one(List<Integer> list, int n){
        int hash[] = new int[n];
        Arrays.fill(hash,0);
        int i = 0;
        while(i<n){
            hash[list.get(i)] ++;
           // System.out.println(list.get(i)+" "+hash[i]);
            i++;

        }
        Arrays.stream(hash).forEach(System.out::println);

    }
    public static void main(String[] args){
        List<Integer> nums = Arrays.asList(1,2,2,2,3,6,7,3,5,8,3,6,6,2,5,2,5,6,3,6,5,3,5,7);
        one(nums,nums.size());
        Map<String, Integer> map = new HashMap<String, Integer>(2);
        map.put("ola" +
                "",2);
        map.put("loook",6);
        map.put("bayo",9);
        System.out.println(map.entrySet().size()+"------sd");
        List<Integer> gh= List.of(1,3,4,5,6,7,7);
        Set<Integer> jk = new HashSet<>();
        gh.forEach(System.out::println);
        System.out.println(jk);
    }
}
