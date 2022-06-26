package com.example.Toptal;

import java.util.ArrayList;
import java.util.*;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Arrays_solution {

    public static void main(String[] args){
        int[] ar[] = new int[5][5];
        // Another way to
        int[][] ars = new int[][]{{1,3,4},{3,2,8},{6,8,3}};
        Comparator<int[]> compare = Comparator.comparingInt(ints -> ints[2]);
        Arrays.sort(ars,compare);
        Arrays.stream(ars)
                .map(x->{
                    List<String> st = new ArrayList<>();
                    Arrays.stream(x).forEach(p->st.add(String.valueOf(p)));
                    return st;
                        }
                        )
                .forEach(System.out::println);
    }

}
