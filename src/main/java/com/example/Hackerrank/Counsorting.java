package com.example.Hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Counsorting {
    public static List<Integer> countingSort(List<Integer> arr) {
        int[] kl = new int[100];
        Arrays.fill(kl, 0);
        arr.stream().forEach(x->{
            kl[x] = kl[x]+1;
        });
        System.out.println(Arrays.toString(kl));
        List<Integer> mk = Arrays.stream(kl).boxed().collect(Collectors.toList());
        return mk;

    }

    public static void main(String[] args){
        List<Integer> lk = Arrays.asList(63 ,25 ,73, 1 ,98, 73, 56, 84, 86, 81, 40,75 ,75, 13, 87, 70, 33 );
        System.out.println(countingSort(lk));
    }
}
