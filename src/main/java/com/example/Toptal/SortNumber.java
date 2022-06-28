package com.example.Toptal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortNumber {

    public static void main(String[] args){
        int[] list =new int[]{1,2,5,8,2};
        for (int i=0; i<list.length; i++){
            for (int j=0; j<list.length; j++){
                if (list[i]<list[j]){
                    int temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }
        List<String> kl = Arrays.stream(list)
                .mapToObj(String::valueOf)
                .collect(Collectors.toList());

        System.out.println(kl);


    }
}
