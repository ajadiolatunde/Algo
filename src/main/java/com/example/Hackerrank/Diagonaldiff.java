package com.example.Hackerrank;

import lombok.val;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Diagonaldiff {
    public static int diagonalDifference(List<List<Integer>> arr) {
        List<Integer> left = new ArrayList<>();
        List<Integer>  right = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            left.add(arr.get(i).get(i));
            int col = arr.get(0).size()-1;
            right.add(arr.get(i).get(col-i));
        }
        int l=  left.stream().mapToInt(x -> x).sum();
        int r = right.stream().collect(Collectors.summingInt(x->x));


        return  Math.abs(l-r);
    }
    public static void main(String[] args){
        List<List<Integer>> kl = new ArrayList<>();
        List<Integer> one = Arrays.asList(11,2,4);
        List<Integer> two = Arrays.asList(4,5,6);
        List<Integer> three = Arrays.asList(10,8,-12);
        kl.add(one);
        kl.add(two);
        kl.add(three);
        diagonalDifference(kl);





    }
}
