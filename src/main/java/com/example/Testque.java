package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Testque {
    public static void main(String[] str) {
        String test1 = "acc?7??sss?3rr1??????5";
        //char[] chars = str.replaceAll("[^?0-9]","").toCharArray();
        //Get a digit turn ? counter
        boolean startcount = false;
        int count = 0;
        String first="0";

        for (int x=0;x<test1.length();x++){
            System.out.println(String.valueOf(test1.charAt(x)));
            if (startcount){
               if ( String.valueOf(test1.charAt(x)).equals("?")){
                   count++;
                }

            }
            if (Character.isDigit(test1.charAt(x))){
                System.out.println("--------"+String.valueOf(test1.charAt(x))+"----"+count+ "  "+first);
                if (count == 3){
                    System.out.println(Integer.valueOf(first));
                    if (Integer.valueOf(first)+ Integer.valueOf(String.valueOf(test1.charAt(x)))==10){
                        System.out.println("true");
                    }
                }
                first = String.valueOf(test1.charAt(x));
                startcount = true;

                count = 0;
            }
        }

        // code goes here
        System.out.println("false");
    }
}
