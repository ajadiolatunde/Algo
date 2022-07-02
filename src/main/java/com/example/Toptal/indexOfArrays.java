package com.example.Toptal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class indexOfArrays {
    public static void main(String[] args){
        int[] jk = new int[]{2,6,3,1,3,4,4};
        int[] cjk = Arrays.copyOfRange(jk,0,jk.length);
        Arrays.sort(jk);
        Map<String, Integer> kl = new HashMap<>();
        final int[] count = {cjk.length - 1};
        Arrays.stream(jk).forEach(x->{
            kl.put(String.valueOf(count[0]), x);
            count[0]--;
        });
        System.out.println(kl.entrySet());


    }
}
