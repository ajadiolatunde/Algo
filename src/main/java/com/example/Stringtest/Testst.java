package com.example.Stringtest;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Testst {
    public static void main(String[] args){
        String test1 = "acc?7??sss?3rr1??????5";
        String my = test1.replaceAll("[^\\d\\?]","");
        System.out.println("--------"+my);
        String[] out = test1.replaceAll("[^\\d\\?]","")
                .split("\\?{3}");
        System.out.println(Arrays.asList(out));
        String curl = "((())(())(((()))";

        Arrays.asList(curl.toCharArray());

    }
}
