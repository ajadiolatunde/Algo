package com.example.Stringtest;

import java.util.Arrays;

public class Testst {
    public static void main(String[] args){
        String test1 = "acc?7??sss?3rr1??????5";
        String[] out = test1.replaceAll("[^\\d\\?]","")
                .split("\\?{3}");
        System.out.println(Arrays.asList(out));
        String curl = "((())(())(((()))";
        Arrays.asList(curl.toCharArray());

    }
}
