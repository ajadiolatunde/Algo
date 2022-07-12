package com.example.euler;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Practice {
    public static void main(String[] args){
      int  k = IntStream.range(0,1000).filter(x->x%5 ==0 || x%3==0).boxed().collect(Collectors.summingInt(y-> y));
      System.out.println(k);
        List<Integer> prime = IntStream.range(0,100).filter(x->x%2 !=0 && x%3!=0 && x%5!=0 && x%7!=0).boxed().collect(Collectors.toList());
        System.out.println(prime);
        double p = 70/7;
        System.out.println(Math.ceil(p));

    }
}
