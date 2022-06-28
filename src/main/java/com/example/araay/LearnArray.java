package com.example.araay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LearnArray {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>(Arrays.asList(2,19,3,7));
        int[] jk = new int[]{2,19,3,7};
        List<Integer> bh = new ArrayList<>();
        Arrays.stream(jk).boxed().forEach(x->bh.add(x));


        //getlist(list);
        list.remove(0);
        System.out.println(bh);

    }
}
