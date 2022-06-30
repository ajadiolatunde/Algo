package com.example.Toptal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cards {
    private static int getSmallest(int[] a,int[] b){
        int[] loader = new int[a.length];
        for (int x=0;x<b.length;x++){
            int[] new_a = a.clone();
            new_a[x] =b[x];
            Arrays.sort(new_a);
            int min = new_a[0];
            int max = new_a[b.length-1];
            for (int y=min;x<max;y++){
                int finalY = y;
                boolean contain = Arrays.stream(new_a).anyMatch(e->e== finalY);
                if (!contain){
                    loader[x] = finalY;
                    break;
                }
            }
        }
        Arrays.sort(loader);
        return loader[0];
    }
    public static void main(String[] args){
        System.out.println(getSmallest(new int[]{1,2,3,4},new int[]{5,2,2,3}));

    }
}
