package com.example.araay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LearnArray {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>(Arrays.asList(2,19,3,7));
        int[] jk = {2,19,3,7};
        List<Integer> bh = Arrays.stream(jk).boxed().collect(Collectors.toList());
        bh.remove(0);
       // Arrays.stream(jk).forEach(x->bh.add(x));int
        int x = 1;
        int ans = 1;
        //factorial 3
         while (x<5){
             ans*=x;
             x++;
         }

        //getlist(list);
        list.remove(0);
        System.out.println(ans);

    }
}
