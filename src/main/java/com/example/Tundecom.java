package com.example;

public class Tundecom {
    private static String recurLogic(int n,int score){
       // System.out.println("----"+n+"===="+score);
        if (score<=n) return "\n"+score;

        return recurLogic(n,score-n)+n;
    }

    private static void  getNum(int score,Integer[] point){
        for (int p:point){
            System.out.println( recurLogic(p,score));
        }
    }
    public static void main(String[] args){
       //System.out.println( recurLogic(2,11));
       getNum(5,new Integer[]{1,2,3});
    }
}
