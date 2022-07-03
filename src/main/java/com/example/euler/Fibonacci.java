package com.example.euler;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Fibonacci {
    public static void main(String[] args){
        int x = 4000000;
        getFiboa(x);
    }

    private static void getFiboa(int x) {
        int[] num = new int[x];

        num[0] = 1;
        num[1] = 2;
        int b = 2;
        int current = 0;
        while (true){
            num[b] = num[b-1] + num[b-2];
            current = num[b];
            if (current>x) {
                num[b] = 0;
                break;
            }
            b++;
        }
        Predicate<Integer> streamsPredicate = item -> item % 2 == 0;
        int total = Arrays.stream(num).filter(item -> item % 2 == 0).sum();
        //System.out.println(Arrays.toString(num));
        System.out.println(total);



    }
}
