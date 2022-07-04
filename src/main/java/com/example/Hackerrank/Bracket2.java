package com.example.Hackerrank;

public class Bracket2 {
    private static String isBalanced(String s){

        while (s.contains("[]") || s.contains("{}")|| s.contains("()")){
           s= s.replace("[]","").replace("{}","").replace("()","");

        }
        return s.length()>0?"NO":"YES";

    }
    public static void main(String[] args){
        String pl = "{[()]}";
        String p2 = "()[]";
        System.out.println( isBalanced(p2));


    }
}
