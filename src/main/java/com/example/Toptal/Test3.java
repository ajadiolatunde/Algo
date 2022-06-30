package com.example.Toptal;

import java.util.Arrays;

public class Test3 {
    public static int solution(int X, int[] B, int Z) {
        if ( X==0 || B.length ==0) return -1;
        int filesize = X;
        int downloaded = Arrays.stream(B).sum();
        int remains = filesize-downloaded;
        if (filesize == downloaded) return 0;
        int count = 0;
        int suml = 0;
        int copy = Arrays.stream(Arrays.copyOfRange(B, B.length-Z,B.length)).sum();
        System.out.println("---------------"+copy);
        //Arrays.stream(copy).forEach(System.out::println);
        System.out.println("---------------");

        for (int x=B.length-1;x>=0;x--){
            suml+= B[x];
            if (count==Z-1)break;
            count++;


        }
        int average = suml/Z;


        System.out.println(average);

        return remains/average;
    }
    public static void main(String[] args){
        int as[]= {10,6,6,8};
        System.out.println(  solution(100,as,2));
    }
}
