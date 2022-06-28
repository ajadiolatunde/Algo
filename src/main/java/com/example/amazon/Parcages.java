package com.example.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parcages {
    /**
     *
     To increase efficiency, the Amazon shipping team will group packages being shipped according to weight. They will merge a lighter package with a heavier package, which eliminates the need for separate shipments.
     More formally, consider n packages, where packageWeightsffi represents the weight of the nth package. You can combine the ith and (1,11th package if packageWeights[i] a packageWeights[i+1], then discard the th package
     */
    private static List<Integer> getlist(List<Integer> list){
        int i = 0;
        while(i<list.size()-1){
            //System.out.println(list);
            if (list.get(i)<list.get(i+1)){
                int lower = list.get(i);
                int higher = list.get(i+1);
                int total = lower + higher;
                list.set(i,total);
                list.remove(i+1);
            }else{
                i++;
            }


        }

        return list;
    }
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>(Arrays.asList(2,19,3,7));
        System.out.println(getlist(list));

    }
}
