package com.example.collection;

import java.sql.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Tundearay {
    List<Integer> grapg = new ArrayList<>();
    ArrayList<int[]> grap = new ArrayList<>();
    public static void main(String[] args){
        Tundearay t = new Tundearay();
        t.grapg.add(2);
        boolean[] visited = new boolean[7];
        visited[1] = true;
        visited[2] = false;

        t.grap.add(0,new int[]{2,5,6,8,9});

        System.out.println(t.grapg);
        int[] h=t.grap.get(0);
        Arrays.stream(h).sum();
        System.out.println( Arrays.stream(h).mapToObj(String::valueOf)

                .collect(Collectors.groupingBy(x->Integer.valueOf(x)%2,Collectors.counting())));
    }
}
