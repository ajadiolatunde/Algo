package com.example;

public class Testreap {
    public static void main(String[] ar){
        String ap = "ABCDCDC" ;
        String check = "CDC";
        //Get all index of c
        int count = 0;
        for (int x=0;x<ap.length()-check.length()+1;x++){
            if (ap.charAt(x) == check.toCharArray()[0] ){
                System.out.println(ap.substring(x,x+check.length()));
                if (ap.substring(x,x+check.length()).equals(check)) count++;
            }
        }
        System.out.println(count);
    }
}
