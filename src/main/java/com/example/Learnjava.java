package com.example;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Learnjava {
    static String getString(String[] arr,String input){
        for (int x=0;x<input.length()+1- arr.length;x++){
            String search = input.substring(x,x+3);
            int count= 0;
            for (String n:arr){
                if (search.contains(n)){
                    count++;
                }else{
                    break;
                }
            }
            if (count==arr.length) {
                //System.out.println(search);
                return search;
            }
        }

        return input;
    }
    private static void tryArray(){
        String[] ola[]=new String[7][7];
        ola[0][1]="ade";
        for (int i=0; i<7; i++)
            ola[i][i]="true";
        System.out.println(Arrays.stream(ola[0]).findFirst());
    }

    public static void main(String[] args){
       String[] arr = new String[]{"x","y","z"};
       String input = "xyyzyzyx";
       tryArray();

    }
}
