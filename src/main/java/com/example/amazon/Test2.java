package com.example.amazon;

import javax.print.attribute.IntegerSyntax;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test2 {
    public static void ans(List<Integer> list){
        for (int x=0;x<list.size();x++) {
            if (x+1 == list.size()){
                System.out.println(list);
                break;
            }
            if (list.get(x)<list.get(x+1)){
                int lower = list.get(x);
                int higher = list.get(x+1);
                int new_item = lower+higher;
                list.set(x,new_item);
                list.remove(x+1);
                ans(list);

            }

        }

    }

    public static void main(String[] args){
        List<Integer> list = Arrays.asList(2,19,3,7);
        ans(new ArrayList<>(list));

    }
}
