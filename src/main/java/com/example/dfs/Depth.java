package com.example.dfs;

import java.util.*;
import java.util.stream.Collectors;

public class Depth {

    public static void main(String[] args){
        ArrayList<int[]> geop = new ArrayList<>();
        geop.add(new int[]{0,1});
        geop.add(new int[]{2,1});
        geop.add(new int[]{0,2});
        geop.add(new int[]{1,3});
        System.out.println(geop.get(0)[1]);
        Map<Integer, List<Integer>> res = geop.stream()
                .collect(Collectors.groupingBy(x->x[0], Collectors.mapping(x->x[1], Collectors.toList())))
                        .entrySet().stream()
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println(res.entrySet());

    }
}
