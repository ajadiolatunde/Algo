package com.example.Toptal;

import java.util.stream.IntStream;

public class Teststreamint {
    public static void main(String[] args){
        IntStream.rangeClosed(0,20).forEach(System.out::println);
    }
}
