package com.example.recursion;

public class Test1 {
    private static String findRecur(String s){
        if (s.length()==1){
            System.out.println(s);
            return "";
        }
        System.out.print(s.charAt(s.length()-1));
        return findRecur(s.substring(0,s.length()-1));

    }
    public static void main(String[] args){
        findRecur("olatunde");
    }
}
