package com.example.Toptal;

import java.util.Arrays;
import java.util.List;

public class Centre {

    private static  int getNotCount(List<Integer> pl,int se){
        int count = (int) pl.stream().filter(x->x!= se).count();
        System.out.println("----count---"+count);

        return count;
    }
    private static int getCount(List<Integer> pl,int se){
        int count = (int) pl.stream().filter(x->x== se).count();
        return count;
    }
    private static int getNumber(List<Integer> kl,int num){
        for (int x=1;x<kl.size();x++){
            //
           int sideright = getCount( kl.subList(0,x),num);
            int sideleft = getNotCount(kl.subList(x,kl.size()),num);
            if (sideleft == sideright) return x;
        }
        return 0;
    }

    public  static void main(String[] args){
        List<Integer> num = Arrays.asList(5,5,1,3,6,5,6);
        System.out.println(getNumber(num,5));
    }
}
