package com.example;

import java.util.ArrayList;

public class Reversematrix {
    public static void main(String[] args){
        ArrayList<int[]> nat = new ArrayList<int[]>();
        nat.add(new int[]{1,2,3,4});
        nat.add(new int[]{1,2,3,4});
        nat.add(new int[]{1,2,3,4});
        nat.add(new int[]{1,2,3,4});
        for (int c =nat.size()-1 ; c >=0; c--) {
           // System.out.println(c+"---c-- ");
            for (int r=0;r<nat.get(0).length;r++){
               // System.out.print(c+""+r+" ");

                System.out.print(nat.get(r)[c]);
            }
            System.out.println("");
        }
    }
}
