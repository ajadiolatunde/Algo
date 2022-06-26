package com.example.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Mysort {
    public static void main(String[] args){
        String[] ade = new String[]{"3.b", "2.c", "4.d", "10.u", "11.a", "6.p", "5.i", "8.t", "9.e", "7.i"};
        Arrays.stream(ade).sorted(Comparator.comparing(x->Integer.valueOf(x.substring(0,x.indexOf("."))),Comparator.reverseOrder())).collect(Collectors.toList()).forEach(System.out::println);

    }
}
