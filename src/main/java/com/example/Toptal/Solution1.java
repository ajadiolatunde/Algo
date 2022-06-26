package com.example.Toptal;

import java.util.*;
import java.util.stream.IntStream;

public class Solution1 {
   //that, given an array A of N integers,
   // returns the smallest positive integer (greater than 0) that does not occur in A.
    public static void main(String[] args) {
        Integer[] A = new Integer[]{1, 2, 3};
        Arrays.sort(A);
        int min = A[0];
        int max = A[A.length - 1];
        System.out.println(min);
        System.out.println(max);
        for (int i = 1; i <= max; i++) {
            int se = i;
            boolean contains = Arrays.stream(A).anyMatch(x -> x == se);
            if (!contains) {
                System.out.println("ans---"+i) ;
                break;
            }
        }
        System.out.println("-ans---"+(max+1)) ;
    }
}
